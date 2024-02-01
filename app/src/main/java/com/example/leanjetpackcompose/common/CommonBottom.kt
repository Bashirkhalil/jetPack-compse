package com.example.leanjetpackcompose.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.leanjetpackcompose.ui.theme.buttonRadius
import com.example.leanjetpackcompose.ui.theme.heightSize


@Composable
fun commonBottom(
    textValue: String, backgroundColor: Color = Color.Blue, onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(heightSize.dp)
            .clip(RoundedCornerShape(buttonRadius.dp))
            .background(color = backgroundColor)
            .fillMaxWidth()
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {

        androidx.compose.material3.Text(textValue, color = Color.White, overflow = TextOverflow.Ellipsis)

    }



}
