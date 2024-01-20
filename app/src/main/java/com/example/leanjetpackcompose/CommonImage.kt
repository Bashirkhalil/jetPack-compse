package com.example.leanjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun commonImage(
    imageResourceId: Int,
    imageSize: Int = 120,
    imageWidth: Int = 50,
    imageHeight: Int = 50,
    onImageClick: () -> Unit
) {

    Image(
        modifier = Modifier
            .size(imageSize.dp)
            .clip(CircleShape),
        painter = painterResource(id = imageResourceId),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
    )

}