package com.example.leanjetpackcompose.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CommonLoading(
    loadingType: LoadingType = LoadingType.Circle
) {

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(0x80A9A9A9))
            .clickable(enabled = false) {}
            .fillMaxSize()) {


        Column(
            verticalArrangement = Arrangement.Center
        ) {


            Box(modifier = Modifier
              //  .background(Color.Cyan)
                .clickable(enabled = false) {}
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center),
                    strokeWidth = 1.5.dp
                )
            }

            CommonSpacer.spacerHeight10()
            CommonSpacer.spacerHeight10()


            commonText(textValue = "Please wait it's loading ...", textColor = Color.Black, fontSize = 14)

        }


    }

}


enum class LoadingType { Circle, Linear, Dialog }
