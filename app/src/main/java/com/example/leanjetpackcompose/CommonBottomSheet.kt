package com.example.leanjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.BottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun commonBottomSheet(onDismiss: () -> Unit) {

    var showSheet by remember { mutableStateOf(false) }

//    ModalBottomSheet(
//        dragHandle = { BottomSheetDefaults.ExpandedShape },
//        shape = BottomSheetDefaults.ExpandedShape,
//        onDismissRequest = { onDismiss() }) {
//
//        // app content
//        Column(
//
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//
//
//
//            commonBottomText(
//                enableLeadingIcon = false ,
//                textValue = "Click Me") {
//                onDismiss()
//            }
//        }
//
//    }

    //Lets define bottomSheetScaffoldState which will hold the state of Scaffold
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState()
    )


    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue),
        sheetContainerColor = Color.White ,
        sheetPeekHeight = 128.dp,
        sheetSwipeEnabled =  false ,
        sheetShape = BottomSheetDefaults.ExpandedShape,
        content = {


            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    .background(Color.Yellow),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {



                commonBottomText(
                    enableLeadingIcon = false ,
                    textValue = "Click Medsdffsdfsdfs") {
                    onDismiss()
                }
            }
        } ,
      //  sheetDragHandle = {},
        sheetContent = {
            // app content
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    .background(Color.Yellow),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {



                commonBottomText(
                    enableLeadingIcon = false ,
                    textValue = "Click Me") {
                    onDismiss()
                }
            }

        })

}


//var isBottomSheetVisible by remember { mutableStateOf(false) }

/*
        ModalBottomSheetLayout(
    sheetContent = {
        // Content of the bottom sheet
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Bottom Sheet Content")
        }
    },
    sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        isGestureEnabled = false // Disable expand gesture
    ),
    content = {
        // Content of the main screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(onClick = { isBottomSheetVisible = true }) {
                Text("Show Bottom Sheet")
            }
        }
    }
)

 */

