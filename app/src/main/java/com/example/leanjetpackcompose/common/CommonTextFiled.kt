package com.example.leanjetpackcompose.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun commonEditText(
    enableLeadingIcon: Boolean = true,
    maxLength: Int? = null,
    inputType: InputType = InputType.Text,
    hintTextType: HintTextType? = null,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    hintText: String = "",
) {


    val mRoundCircle = RoundedCornerShape(15.dp)
    val mHintTextType = hintTextType ?: HintTextType.PLACEHOLDER
    var isPasswordVisible by remember { mutableStateOf(false) }
    var mText by remember { mutableStateOf("") }


    OutlinedTextField(
        singleLine = singleLine,
        value = mText,
        readOnly = readOnly,
        visualTransformation = getPasswordVisualTransform(inputType, isPasswordVisible),
        keyboardOptions = getKeyboardType(inputType),
        leadingIcon = if (enableLeadingIcon) GetLeadingIcon(inputType = inputType) else null,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(mRoundCircle)
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF6b7786),
                ), shape = mRoundCircle
            ),
        onValueChange = {

            if (maxLength != null && mText.length == maxLength) {
               return@OutlinedTextField
            }

            mText = it

        },
        placeholder = {
            if (mHintTextType.name == HintTextType.PLACEHOLDER.name) {
                Text(text = hintText)
            }
        }, // inside
        label = getLabelHintValue(mHintTextType, hintText), // outside
        trailingIcon = {

            // execute this only if the icon is password
            if (inputType.name == InputType.PasswordNumber.name || inputType.name == InputType.PasswordText.name) {


                ifTheIconIsPassword(isPasswordVisible = isPasswordVisible,

                    onDelayOccur = {
                        isPasswordVisible = false
                    },

                    onClickOccur = {
                        isPasswordVisible = !isPasswordVisible
                    })


            }


            // execute this only if the icon is password
            if (inputType.name != InputType.PasswordNumber.name && inputType.name != InputType.PasswordText.name) {
                ClearIcon(mText) {
                    mText = ""
                }
            }


        }
    )

/*
    // TextField
    TextField(
        singleLine = singleLine,
        value = mText,
        readOnly = readOnly,
        label = getLabelHintValue(mHintTextType, hintText),
        visualTransformation = getPasswordVisualTransform(inputType, isPasswordVisible),
        keyboardOptions = getKeyboardType(inputType),
        leadingIcon = if (enableLeadingIcon) GetLeadingIcon(inputType = inputType) else null,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(mRoundCircle)
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF6b7786),
                ), shape = mRoundCircle
            ),
        onValueChange = {

            if (maxLength != null && mText.length == maxLength) {
                return@TextField
            }

            mText = it

        },
        placeholder = {
            if (mHintTextType.name == HintTextType.PLACEHOLDER.name) {
                Text(text = hintText)
            }
        },
        trailingIcon = {

            // execute this only if the icon is password
            if (inputType.name == InputType.PasswordNumber.name || inputType.name == InputType.PasswordText.name) {


                ifTheIconIsPassword(isPasswordVisible = isPasswordVisible,

                    onDelayOccur = {
                        isPasswordVisible = false
                    },

                    onClickOccur = {
                        isPasswordVisible = !isPasswordVisible
                    })


            }


            // execute this only if the icon is password
            if (inputType.name != InputType.PasswordNumber.name && inputType.name != InputType.PasswordText.name) {
                ClearIcon(mText) {
                    mText = ""
                }
            }


        })

 */

}



enum class HintTextType { PLACEHOLDER, LABEL  }

enum class InputType { PasswordNumber, PasswordText, EmailAddress, Number, Phone, Text, Decimal, Ascii  }


private fun returnToDefaultValueAfterXSecond(onTowMinuteDelay: () -> Unit) =
    CoroutineScope(Dispatchers.IO).launch {
        delay(1000)
        onTowMinuteDelay()
    }

private fun getPasswordVisualTransform(
    inputType: InputType, isPasswordVisible: Boolean
): VisualTransformation =
    if (!isPasswordVisible && (inputType.name == InputType.PasswordNumber.name || inputType.name == InputType.PasswordText.name)) PasswordVisualTransformation()
    else VisualTransformation.None

private fun getKeyboardType(inputType: InputType): KeyboardOptions = when (inputType) {
    InputType.Number -> KeyboardOptions(keyboardType = KeyboardType.Number)
    InputType.EmailAddress -> KeyboardOptions(keyboardType = KeyboardType.Email)
    InputType.Text -> KeyboardOptions(keyboardType = KeyboardType.Text)
    InputType.Phone -> KeyboardOptions(keyboardType = KeyboardType.Phone)
    InputType.Ascii -> KeyboardOptions(keyboardType = KeyboardType.Ascii)
    InputType.Decimal -> KeyboardOptions(keyboardType = KeyboardType.Decimal)
    InputType.PasswordText -> KeyboardOptions(keyboardType = KeyboardType.Password)
    InputType.PasswordNumber -> KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
}



@Composable
private fun getLabelHintValue(
    hintTextType: HintTextType, hintText: String
): @Composable() (() -> Unit)? = if (HintTextType.LABEL.name == hintTextType.name) {
    { Text(text = hintText) }
} else null

@Composable
private fun ifTheIconIsPassword(
    isPasswordVisible: Boolean, onDelayOccur: (Boolean) -> Unit, onClickOccur: (Boolean) -> Unit
) {

    IconButton(onClick = {
        onClickOccur(isPasswordVisible)
        returnToDefaultValueAfterXSecond {
            onDelayOccur(true)
        }

    }) {
        Icon(
            if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
            contentDescription = "User Icon",
            tint = Color(0xFF6b7786),
            modifier = Modifier.onFocusChanged {
                print("the current value = ${it.isFocused} - ${it.hasFocus} - ${it.isCaptured} - ${it}")
            },
        )
    }
}

@Composable
private fun GetLeadingIcon(inputType: InputType): @Composable (() -> Unit)? {

    var mIcon = when (inputType) {
        InputType.Phone -> Icons.Default.Phone
        InputType.EmailAddress -> Icons.Default.Email
        InputType.Phone -> Icons.Default.Person
        InputType.PasswordNumber -> Icons.Default.Security
        InputType.PasswordText -> Icons.Default.Security
        else -> {
            Icons.Default.Person
        }
    }

    return {
        Icon(
            imageVector = mIcon, contentDescription = "User Icon", tint = Color(0xFF6b7786)
        )
    }

}


@Composable
private fun ClearIcon(mText: String, onClearClick: () -> Unit) {
    IconButton(onClick = {
        onClearClick()
    }) {

        if (!mText.isNullOrEmpty()) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = "User Icon",
                tint = Color(0xFF6b7786),
                modifier = Modifier.onFocusChanged {
                    print("the current value = ${it.isFocused} - ${it.hasFocus} - ${it.isCaptured} - ${it}")
                },
            )
        }

    }
}

