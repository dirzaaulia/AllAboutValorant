package com.dirzaaulia.baseprojectcompose.ui.latest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dirzaaulia.baseprojectcompose.utils.fadePlaceholder
import com.dirzaaulia.baseprojectcompose.utils.isLoading
import com.dirzaaulia.baseprojectcompose.utils.isSucceeded
import com.dirzaaulia.baseprojectcompose.utils.success

@Composable
fun Latest(
    viewModel: LatestViewModel = hiltViewModel()
) {

    val latestPhoneState by viewModel.latestPhonesState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            when {
                latestPhoneState.isLoading -> {
                    items(50) {
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                            .padding(bottom = 8.dp)
                            .fadePlaceholder()
                        ) { }
                    }
                }
                latestPhoneState.isSucceeded -> {
                    latestPhoneState.success { response ->
                        val latestPhones = response?.data?.phones ?: emptyList()
                        items(latestPhones) {phones ->
                            Row {
                                Text(text = phones.phoneName)
                            }
                        }
                    }
                }
            }
        }
    }
}