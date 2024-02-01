package com.example.leanjetpackcompose.common

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.leanjetpackcompose.ui.theme.buttonRadius
import com.example.leanjetpackcompose.ui.theme.heightSize

private const val mRoundCorner = 7

enum class DialogType { Normal , Custom}

@Composable
fun CommonDialog(
    dialogType: DialogType = DialogType.Normal,
    message: String = "please write your message here ",
    title: String = "Please confirm",
    negativeText: String = "Cancel",
    positiveText: String = "Yes",
    onDismissClick: () -> Unit,
    onCancel: (Boolean) -> Unit,
    onAccept: (Boolean) -> Unit,
    enableOneButton: Boolean = false
) {


    when(dialogType) {

        DialogType.Normal -> {
            AlertDialog(
                onDismissRequest = { },
                confirmButton = {
                    TextButton(onClick = { onAccept(true) })
                    { androidx.compose.material3.Text(text = positiveText) }
                },
                dismissButton = if(enableOneButton) null else {
                    {
                        TextButton(onClick = { onCancel(false) })
                        { androidx.compose.material3.Text(text = negativeText) }
                    }
                },
                title = { androidx.compose.material3.Text(text = title) },
                text = { androidx.compose.material3.Text(text = message) }
            )
        }

        DialogType.Custom -> {
            Dialog(
                content = {

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(mRoundCorner))
                            .background(Color.White)
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                    ) {


                        CommonSpacer.spacerHeight10()

                        // title
                        commonText(
                            textValue = title
                        )


                        CommonSpacer.spacerHeight20()

                        // message
                        commonText(
                            textValue = message,
                            fontSize = 18
                        )


                        CommonSpacer.spacerHeight20()



                        Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)) {

                            if (enableOneButton.not()) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(heightSize.dp)
                                        .clip(RoundedCornerShape(buttonRadius.dp))
                                        .weight(1f)
                                        .background(color = Color.Blue),
                                    contentAlignment = Alignment.Center
                                ) {

                                    commonBottom(textValue = negativeText) {
                                        onCancel(false)

                                    }

                                }
                                CommonSpacer.spacerWidth20(10)
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(heightSize.dp)
                                    .clip(RoundedCornerShape(buttonRadius.dp))
                                    .weight(1f)
                                    .background(color = Color.Blue)
                                    .clickable {
                                        Log.e("TAG", "Hello click")


                                    }, contentAlignment = Alignment.Center
                            ) {

                                commonBottom(textValue = positiveText) {
                                    onAccept(false)
                                }
                            }


                        }

                    }
                },
                onDismissRequest = { onDismissClick() }
            )
        }
    }

}



@Composable
private fun alert() {

}