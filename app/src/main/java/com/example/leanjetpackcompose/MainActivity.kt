package com.example.leanjetpackcompose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leanjetpackcompose.ui.theme.LeanJetPackComposeTheme
import com.example.leanjetpackcompose.ui.theme.buttonRadius
import com.example.leanjetpackcompose.ui.theme.heightSize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

val mTAG: String = MainActivity::class.java.simpleName

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            buildUI()
        }
    }


}

fun getModifier(): Modifier {
    return Modifier.padding(12.dp)
}


@Composable
fun UserCard() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .border(
                    width = 0.1.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp)
                )
                .padding(12.dp)

        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.bm),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .padding(horizontal = 5.dp)
            )
            Column {
                Text(
                    text = "Hello bo my name is bashir khalil from Sudan I  bo my name is bashir khalil from Sudan I " + "am lokking for  anew job as Software Engineer"
                )
                Text()
                Text()
            }
        }
    }
}


@Composable
fun Text() {
    val context = LocalContext.current

    Text(text = "Hello Bashir Your did ",
        color = colorResource(id = R.color.purple_200),
        fontFamily = FontFamily.Cursive,
        modifier = Modifier.clickable {
            Toast.makeText(context, "Hello Here ", Toast.LENGTH_LONG).show()
        })

}

//backgroundColor = 0xFFFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_NO

@Preview(
    showBackground = true, backgroundColor = 0xCFFF95, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun showThePage() {
//    Surface(
//        modifier =
//        Modifier.fillMaxWidth()
//    ) {
//        UserCard()
//    }
    buildUI()
}

@Composable
private fun buildUI() {
    LeanJetPackComposeTheme {
        //  UserCard()


        createCustomButton()

        //createCircleImage()

//        Row (
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//
//        ){
//            Text(text = "Hello ")
//            Text(text = "Hello ")
//            Text(text = "Hello ")
//            Text(text = "Hello ")
//        }

//        Column (
//            verticalArrangement = Arrangement.SpaceAround,
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//
//        ){
//            Text(text = "Hello ")
//            Text(text = "Hello ")
//            Text(text = "Hello ")
//            Text(text = "Hello ")
//        }
    }
}

@Composable
fun createCustomButton() {
    return Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp), contentAlignment = Alignment.BottomCenter
    ) {

        Column {

            buildCard()

            CommonSpacer.spacerHeight10()

            commonBottomText(textValue = "Click Me") {

            }

            CommonSpacer.spacerHeight10()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightSize.dp)
                    .clip(RoundedCornerShape(buttonRadius.dp))
                    .background(color = Color.Blue)
                    .clickable {
                        Log.e("TAG", "Hello click")
                    }, contentAlignment = Alignment.Center
            ) {

                Text("Login", color = Color.White, overflow = TextOverflow.Ellipsis)
            }

            CommonSpacer.spacerHeight10()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightSize.dp)
                    .clip(RoundedCornerShape(buttonRadius.dp))
                    .background(color = Color.Blue)
                    .clickable {
                        Log.e("TAG", "Hello click")
                    }, contentAlignment = Alignment.Center
            ) {

                Text(
                    "Login",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }


            CommonSpacer.spacerHeight10()

            Row(modifier = Modifier.fillMaxWidth()) {


                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    commonBottom(textValue = "Login") {

                    }
                }

                CommonSpacer.spacerWidth5()

                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    commonBottom(textValue = "Login") {

                    }
                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(Color.Transparent)
            ) {


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

                    Text("Login", color = Color.White, overflow = TextOverflow.Ellipsis)
                }

                CommonSpacer.spacerWidth10(10)

                Box(
                    modifier = Modifier
                        .height(heightSize.dp)
                        .weight(1f)
                        .clip(RoundedCornerShape(buttonRadius.dp))
                        .background(color = Color.Blue)
                        .clickable { }, contentAlignment = Alignment.Center

                ) {
                    Text("Login", color = Color.White, overflow = TextOverflow.Ellipsis)

                }


            }

        }


    }
}

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


@Composable
fun commonText(
    disableRipple: Boolean = false,
    textValue: String,
    textLineSize: Int = Int.MAX_VALUE,
    textColor: Color = Color.DarkGray,
    fontSize: Int = 18,
    onTextClick: (() -> Unit)? = null
) {

    Text(
        modifier = Modifier
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
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Medium,
        overflow = TextOverflow.Ellipsis,
        maxLines = textLineSize
    )

}


class NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}

@Composable
fun buildCard() {

    return Card(

        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .padding(vertical = 10.dp)
        ,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {


        Column {


            Row(
                modifier = Modifier

            ) {

                Box(modifier = Modifier.padding(10.dp)) {
                    commonImage(
                        imageResourceId = R.drawable.bm,
                        imageSize = 60,
                        imageHeight = 130,
                        imageWidth = 130
                    ) {

                    }

                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp)

                ) {

                    CommonSpacer.spacerHeight10()

                    commonText(textValue = "Eng. Bashir Khalil")

                    CommonSpacer.spacerHeight10(8)

                    commonText(textValue = "Mobile Application Developer ", fontSize = 15)

                    CommonSpacer.spacerHeight10(8)

                    var mTextLineSize by remember {
                        mutableStateOf(false)
                    }

                    commonText(
                        disableRipple = true,
                        textLineSize = if (mTextLineSize) Int.MAX_VALUE else 2,
                        onTextClick = {
                            mTextLineSize = !mTextLineSize
                        },
                        textValue = "Hi Iam Bashir Khalil Mobile Application Developer with 5+ years of experience in designing,\n" + "developing, and maintaining cutting-edge mobile applications for the Android platform.\n" + "Proficient in Java, Kotlin, flutter and Android SDK and Payment infrastructure integration ,\n" + "with a strong background in software engineering and computer science principles. Adept at\n" + "collaborating with cross-functional teams to analyze user requirements and deliver high\u0002quality, user-friendly applications.",
                        fontSize = 15
                    )

                    CommonSpacer.spacerHeight10(8)

                }

            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun commonBottomSheet(onDismiss: () -> Unit) {

    var showSheet by remember { mutableStateOf(false) }

    ModalBottomSheet(onDismissRequest = { onDismiss() }) {

    }

}


@Composable
fun createCircleImage() {

    return Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)

                .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                .background(Color.Green)
        ) {


        }

    }

}

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

        Text(textValue, color = Color.White, overflow = TextOverflow.Ellipsis)

    }


}


@Composable
fun commonBottomText(
    textValue: String, backgroundColor: Color = Color.Blue, onButtonClick: () -> Unit
) {

    Button(modifier = Modifier.fillMaxWidth(), onClick = {
        onButtonClick()
    }) {

        Icon(modifier = Modifier
            .height(30.dp), painter = painterResource(id = R.drawable.no_wifi),
            contentDescription = null ,
            )


        commonText(textValue = textValue , textColor = Color.White)
    }
}



