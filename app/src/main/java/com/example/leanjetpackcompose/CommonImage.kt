package com.example.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun commonImage(
    imageResourceId: Int ,
    url:String? = null ,
    imageSize: Int = 120,
    imageWidth: Int = 50,
    imageHeight: Int = 50,
    onImageClick: () -> Unit
) {

    Image(
        modifier = Modifier
            .size(imageSize.dp)
            .clip(CircleShape),
        painter = getImageDirection(imageResourceId,url),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
    )

}

@Composable
private fun getImageDirection(imageResourceId: Int, url: String?) =
if(url==null)  painterResource(id = imageResourceId)  else rememberAsyncImagePainter(model = url)
