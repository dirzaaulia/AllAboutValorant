package com.dirzaaulia.smartphonespec.ui.latest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dirzaaulia.smartphonespec.data.model.Phone
import com.dirzaaulia.smartphonespec.ui.common.CommonError
import com.dirzaaulia.smartphonespec.ui.common.StaggeredVerticalGrid
import com.dirzaaulia.smartphonespec.utils.Constant
import com.dirzaaulia.smartphonespec.ui.common.NetworkImage
import com.dirzaaulia.smartphonespec.utils.commonErrorMessageIfEmpty
import com.dirzaaulia.smartphonespec.utils.error
import com.dirzaaulia.smartphonespec.utils.isError
import com.dirzaaulia.smartphonespec.utils.isLoading
import com.dirzaaulia.smartphonespec.utils.isSucceeded
import com.dirzaaulia.smartphonespec.utils.shimmerPlaceholder
import com.dirzaaulia.smartphonespec.utils.success

@Composable
fun Latest(
    modifier: Modifier = Modifier,
    viewModel: LatestViewModel = hiltViewModel()
) {

    val latestPhoneState by viewModel.latestPhonesState.collectAsState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        LazyColumn {
            item {
                StaggeredVerticalGrid(maxColumnWidth = 220.dp) {
                    when {
                        latestPhoneState.isLoading ->
                            repeat(Constant.DEFAULT_PLACEHOLDER_COUNT) {
                                LatestPhoneItemPlaceholder()
                            }

                        latestPhoneState.isSucceeded ->
                            latestPhoneState.success { response ->
                                response?.data?.phones?.forEach { phone ->
                                    LatestPhoneItem(phone = phone)
                                }
                            }
                    }
                }
            }
        }
        when {
            latestPhoneState.isError ->
                latestPhoneState.error { throwable ->
                    CommonError(
                        modifier = Modifier.fillMaxSize(),
                        errorMessage = throwable.message.commonErrorMessageIfEmpty(),
                        retry = { viewModel.getLatestPhones() }
                    )
                }
        }
    }
}

@Composable
fun LatestPhoneItemPlaceholder(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(220.dp, 72.dp)
            .shimmerPlaceholder()
    ) { }
}

@Composable
fun LatestPhoneItem(
    modifier: Modifier = Modifier,
    phone: Phone
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .width(220.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NetworkImage(url = phone.image)
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = phone.phoneName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}