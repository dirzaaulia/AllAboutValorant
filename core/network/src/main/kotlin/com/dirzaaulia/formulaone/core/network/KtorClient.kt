package com.dirzaaulia.formulaone.core.network

import android.util.Log
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.plugins.resources.get
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.appendPathSegments
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.concurrent.TimeUnit

class KtorClient(
    chuckerInterceptor: ChuckerInterceptor,
) {
    private val ktorClient = initializeKtor(chuckerInterceptor)

    internal suspend inline fun <reified Z : Any, reified T> get(resources: Z): T {
        return ktorClient
            .get(resources)
            .body()
    }

    internal suspend inline fun <reified Z : Any, reified T> getWithQuery(
        resources: Z,
        query: Map<String, String>,
        path: String? = null,
        body: Z? = null,
    ): T {
        return ktorClient
            .get(resources) {
                url {
                    query.forEach { item ->
                        parameters.append(item.key, item.value)
                    }
                    path?.let {
                        appendPathSegments(it)
                    }
                    body?.let {
                        setBody(body)
                    }
                }
            }
            .body()
    }
    companion object {

        private const val TIMEOUT = 60L
        private const val FORMULA_ONE_BASE_URL = BuildConfig.BACKEND_URL

        private fun initializeKtor(
            chuckerInterceptor: ChuckerInterceptor,
            springUrl: String? = null,
            springHeader: Map<String, String>? = null,
        ) = HttpClient(OkHttp) {

            engine {
                addInterceptor(chuckerInterceptor)
                config {
                    connectTimeout(timeout = TIMEOUT, unit = TimeUnit.SECONDS)
                    writeTimeout(timeout = TIMEOUT, unit = TimeUnit.SECONDS)
                    readTimeout(timeout = TIMEOUT, unit = TimeUnit.SECONDS)
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Logger Ktor ->", message)
                    }
                }
                level = LogLevel.ALL
            }

//            install(Auth) {
//                bearer {
//                    loadTokens {
//                        BearerTokens(Constant.TOKEN, Constant.EMPTY_STRING)
//                    }
//                }
//            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("Http status:", "${response.status.value}")
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, Json)
                springHeader?.let { map ->
                    map.forEach {
                        header(it.key, it.value)
                    }
                }
            }

            install(Resources)
            defaultRequest {
                url {
                    protocol = if (springUrl.isNullOrBlank()) URLProtocol.HTTPS else URLProtocol.HTTP
                    host = FORMULA_ONE_BASE_URL
                }
            }

            HttpResponseValidator {
                validateResponse { response: HttpResponse ->
                    val statusCode = response.status.value
                    when (statusCode) {
                        in 300..599 -> throw ErrorException(
                            response = response,
                            responseBody = response.bodyAsText()
                        )
                    }
                    if (statusCode >= 600) {
                        throw MissingPageException(
                            response = response,
                            responseBody = "Error"
                        )
                    }
                }
            }

        }
    }
}

class MissingPageException(response: HttpResponse, responseBody: String) : ResponseException(response, responseBody) {
    override val message: String = response.status.description
}

class ErrorException(response: HttpResponse, responseBody: String) : ResponseException(response, responseBody) {
    override val message: String = responseBody
}