package com.example.leanjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun commonText(
    disableRipple: Boolean = false,
    textValue: String,
    textLineSize: Int = Int.MAX_VALUE,
    textColor: Color = Color.DarkGray,
    fontSize: Int = 18,
    onTextClick: (() -> Unit)? = null
) {

    Row (
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ,
    ){
        androidx.compose.material3.Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = if (disableRipple) null else rememberRipple(bounded = true)
                ) {

                    if (onTextClick != null) {
                        onTextClick()
                    }
                },
            text = textValue,
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Medium,
            overflow = TextOverflow.Ellipsis,
            maxLines = textLineSize
        )

    }
}
