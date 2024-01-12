package com.example.leanjetpackcompose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object CommonSpacer {

    @Composable
    fun spacerHeight5(heightValue:Int = 5) =
        Spacer(modifier = Modifier.height(heightValue.dp))


    @Composable
    fun spacerHeight10(heightValue:Int = 10) =
        Spacer(modifier = Modifier.height(heightValue.dp))


    @Composable
    fun spacerWidth5(widthValue:Int = 5) =
        Spacer(modifier = Modifier.width(widthValue.dp))


    @Composable
    fun spacerWidth10(widthValue:Int = 10) =
        Spacer(modifier = Modifier.width(widthValue.dp))

}