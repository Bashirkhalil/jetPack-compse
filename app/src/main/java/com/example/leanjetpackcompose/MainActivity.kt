package com.example.leanjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.leanjetpackcompose.ui.theme.LeanJetPackComposeTheme
import kotlinx.coroutines.CoroutineScope

val mTAG: String = MainActivity::class.java.simpleName

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            buildUI()
        }
    }


}

fun getModifier(): Modifier = Modifier.padding(12.dp)

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


//@Preview(showBackground = true, backgroundColor = 0xCFFF95, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview
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

        //createCircleImage()

        createCustomButton()

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createCustomButton() {

    Box(modifier = Modifier
        .fillMaxWidth()
     ) {

        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(15.dp)) {

             buildCard()

            CommonSpacer.spacerHeight10()

            commonEditText(inputType = InputType.Text, hintText = "User Name  ")

            CommonSpacer.spacerHeight10()

            commonEditText(inputType = InputType.Text, hintText = "User Name  ")

            CommonSpacer.spacerHeight10()

            commonEditText(
                maxLength = 10, inputType = InputType.Phone, hintText = "Phone Number "
            )

            CommonSpacer.spacerHeight10()


            commonEditText(
                inputType = InputType.EmailAddress, hintText = "Email Address "
            )

            CommonSpacer.spacerHeight10()

            commonEditText(inputType = InputType.PasswordText, hintText = "Password Text ")

            CommonSpacer.spacerHeight10()

            commonEditText(inputType = InputType.PasswordNumber, hintText = "Password  ")

            CommonSpacer.spacerHeight10()


            /*
            alert with one bottom
             */
            var openDialog by remember { mutableStateOf(false) }
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                commonBottom(textValue = "Show Dialog with tow Button ") {
                    openDialog = true
                }
            }
            CommonSpacer.spacerHeight10()
            if(openDialog){
                CommonDialog(
                    message = "Are you sure you want to delete this file ? ",
                    positiveText = "Confirm",
                    onDismissClick = {},
                    onCancel = {
                        openDialog =  false
                    },
                    onAccept = {
                        openDialog =  false

                    },
                )
            }

            /*
                      alert with tow bottom
                       */

            var openDialogEx by remember { mutableStateOf(false) }
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                commonBottom(textValue = "Show Dialog with one Button ") {
                    openDialogEx = true
                }
            }
            CommonSpacer.spacerHeight10()
            if(openDialogEx){
                CommonDialog(
                    message = "File has been deleted successfully ? ",
                    positiveText = "Okay",
                    enableOneButton = true ,
                    onDismissClick = {},
                    onCancel = {
                        openDialogEx =  false
                    } ,
                    onAccept = {
                        openDialogEx =  false

                    }
                )
            }




            /*
          tow bottom in row
           */

            CommonSpacer.spacerHeight10()
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    commonBottom(textValue = "Yes") {
                    }
                }
                CommonSpacer.spacerWidth5()
                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    commonBottom(textValue = "No") {

                    }
                }
            }



            /*
    

            Box(modifier = Modifier
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
    
                Box(modifier = Modifier
                    .height(heightSize.dp)
                    .weight(1f)
                    .clip(RoundedCornerShape(buttonRadius.dp))
                    .background(color = Color.Blue)
                    .clickable {
    
    
    //                            val scaffoldState = rememberBottomSheetScaffoldState()
    //                            val scope = rememberCoroutineScope()
    //                            scope.launch {
    //                                scaffoldState.bottomSheetState.expand()
    //                            }
    
    
                    }, contentAlignment = Alignment.Center) {
                    Text("Login Test", color = Color.White, overflow = TextOverflow.Ellipsis)
                }
    
    
    
            }
    
             */


        }


        /*
        show bottom sheet dialog
         */
        CommonSpacer.spacerHeight10()
        var openBottomSheetDialog by remember { mutableStateOf(false) }

        Box(
            Modifier.fillMaxWidth()
        ) {
            commonBottom(textValue = "Show Bottom sheet dialog ") {
                openBottomSheetDialog = !openBottomSheetDialog
            }
        }


        if(openBottomSheetDialog){

            commonBottomSheet(
                enableOneBottomSheet = false,
                onReject = {
                    openBottomSheetDialog = !openBottomSheetDialog
                },
                onConfirm = {
                    openBottomSheetDialog = !openBottomSheetDialog
                }

            )

        }


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showList(scope: CoroutineScope, m: BottomSheetScaffoldState) {


//       ModalBottomSheet(
//        windowInsets = WindowInsets.displayCutout,
//        dragHandle =  { BottomSheetDefaults.DragHandle()},
//        sheetState = mModelState ,
//        onDismissRequest = {
//            onDismiss()
//        },
//        ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 10.dp, horizontal = 20.dp)
//        ) {
//            Text(
//                text = "flag",
//                modifier = Modifier.padding(end = 20.dp)
//            )
//            Text(text = "country")
//
//            CommonSpacer.spacerHeight10()
//
//            commonBottomText(
//                enableLeadingIcon = false ,
//                textValue = "Close") {
//                onDismiss()
//            }
//        }
//    }


}


@Composable
fun buildCard() {

    return Card(

        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {


        Column {


            Row(modifier = Modifier) {

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






