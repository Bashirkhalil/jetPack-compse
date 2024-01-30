package com.example.leanjetpackcompose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun commonBottomSheet(
    sheetSwipeEnabled: Boolean = false,
    message: String = "Default message ",
    title:String = "Confirm message ",
    hideToggle: Boolean = true,
    hideTitle: Boolean = false,
    enableOneBottomSheet: Boolean = true,
    backgroundColor: Color = Color.White,
    onConfirm: () -> Unit,
    onReject: (() -> Unit)? = null,
    onBottomSheetOpen: ((Boolean) -> Unit)? = null,
    onBottomSheetClose: ((Boolean) -> Unit)? = null
) {

    //Lets define bottomSheetScaffoldState which will hold the state of Scaffold
    val bottomSheetScaffoldState =
        rememberBottomSheetScaffoldState(bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Expanded,
            skipHiddenState = true,
            confirmValueChange = {
                when (it) {
                    SheetValue.PartiallyExpanded -> {
                        if (onBottomSheetClose != null) {
                            onBottomSheetClose(true)
                        }
                    }

                    SheetValue.Expanded -> {
                        if (onBottomSheetOpen != null) {
                            onBottomSheetOpen(true)
                        }

                    }

                    SheetValue.Hidden -> {

                    }

                    else -> {}
                }
                true
            }

        ))

    Box(modifier = Modifier
        .safeDrawingPadding()
        .clickable(enabled = false) {}
        .background(Color.Black.copy(alpha = 0.4f))
        .onGloballyPositioned {

            if (bottomSheetScaffoldState.bottomSheetState.hasExpandedState && (onBottomSheetOpen != null)) {
                onBottomSheetOpen(true)
            }

            print("State -> ${bottomSheetScaffoldState.bottomSheetState.hasExpandedState}")
            Log.e(
                "TestC",
                "State 1-> ${bottomSheetScaffoldState.bottomSheetState.hasExpandedState}"
            )
            Log.e("TestC", "State 2-> ${bottomSheetScaffoldState.bottomSheetState.isVisible}")
            Log.e(
                "TestC",
                "State 3-> ${bottomSheetScaffoldState.bottomSheetState.hasPartiallyExpandedState}"
            )
            Log.e("TestC", "State 4-> ${bottomSheetScaffoldState.bottomSheetState}")

        }
        .fillMaxSize()) {


        BottomSheetScaffold(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue),
             scaffoldState = bottomSheetScaffoldState,
             sheetShape = BottomSheetDefaults.ExpandedShape,
            sheetShadowElevation = 15.dp,
            sheetDragHandle = isAllowToHideToggle(hideToggle),
            //  sheetDragHandle = { BottomSheetDefaults.DragHandle() } ,
            sheetContainerColor = backgroundColor,
            sheetPeekHeight = 0.dp,
            sheetSwipeEnabled = sheetSwipeEnabled,
            content = {},
            sheetContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp, horizontal = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {


                    // title
                    if (!hideTitle) {
                        commonText(textValue = title, fontSize = 14)
                    }

                    CommonSpacer.spacerHeight20()


                    //  message
                    commonText(
                        textAlign = TextAlign.Start ,
                        textValue = message, fontSize = 18
                    )

                    CommonSpacer.spacerHeight20()
                    CommonSpacer.spacerHeight5()


                    // close
                    if (enableOneBottomSheet) {
                        commonBottom(
                            textValue = "Close"
                        ) {
                            onConfirm()
                        }
                    }


                    // enable tow Bottom
                    if (enableOneBottomSheet.not()) {

                        Row {

                            Box(modifier = Modifier.weight(1f)) {

                                commonBottom(
                                    textValue = "Reject"
                                ) {
                                    if (onReject != null) {
                                        onReject()
                                    }
                                }

                            }

                            CommonSpacer.spacerWidth10()


                            Box(modifier = Modifier.weight(1f)) {

                                commonBottom(
                                    textValue = "Confirm"
                                ) {
                                    onConfirm()
                                }

                            }

                        }


                    }


                }

            })

    }


}


/*
ModalBottomSheet(
    windowInsets = BottomSheetDefaults.windowInsets,
    sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = {
            when (it) {
                SheetValue.PartiallyExpanded -> {
                    if (onBottomSheetClose != null) {
                        onBottomSheetClose(true)
                    }
                }

                SheetValue.Expanded -> {
                    if (onBottomSheetOpen != null) {
                        onBottomSheetOpen(true)
                    }

                }

                SheetValue.Hidden -> {

                }

                else -> {}
            }
            true
        }),
    dragHandle = isAllowToHideToggle(hideToggle),
    shape = BottomSheetDefaults.ExpandedShape,
    onDismissRequest = { onConfirm() }) {

    // app content
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        // title
        commonText(textValue = "Confirm message ", fontSize = 14)

        CommonSpacer.spacerHeight20()

        //  message
        commonText(textValue = "Are you sure you want to delete this ? ", fontSize = 18)

        CommonSpacer.spacerHeight20()
        CommonSpacer.spacerHeight5()


        // close
        if (enableOneBottomSheet) {
            commonBottom(
                textValue = "Close"
            ) {
                onConfirm()
            }
        }


        // enable tow Bottom
        if (enableOneBottomSheet.not()) {
            Row {

                Box(modifier = Modifier.weight(1f)) {

                    commonBottom(
                        textValue = "Reject"
                    ) {
                        if (onReject != null) {
                            onReject()
                        }
                    }

                }

                CommonSpacer.spacerWidth10()


                Box(modifier = Modifier.weight(1f)) {

                    commonBottom(
                        textValue = "Confirm"
                    ) {
                        onConfirm()
                    }

                }

            }
        }

    }
}

*/


// Popup(onDismissRequest = onConfirm, properties = PopupProperties(focusable = true),) {




@OptIn(ExperimentalMaterial3Api::class)
private fun isAllowToHideToggle(hideToggle: Boolean): @Composable() (() -> Unit)? =
    if (hideToggle) {
        { BottomSheetDefaults.HiddenShape }
    } else {
        { BottomSheetDefaults.DragHandle() }

    }



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

