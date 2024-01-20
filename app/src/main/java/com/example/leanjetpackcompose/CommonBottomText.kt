package com.example.leanjetpackcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun commonBottomText(
    enableLeadingIcon: Boolean = true,
    textValue: String,
    backgroundColor: Color = Color.Blue,
    onButtonClick: () -> Unit
) {

    Button(modifier = Modifier.fillMaxWidth(), onClick = {
        onButtonClick()
    }) {

        if (enableLeadingIcon) {
            Icon(
                modifier = Modifier.height(30.dp),
                painter = painterResource(id = R.drawable.no_wifi),
                contentDescription = null,
            )
        }



        commonText(textValue = textValue, textColor = Color.White)
    }
}

