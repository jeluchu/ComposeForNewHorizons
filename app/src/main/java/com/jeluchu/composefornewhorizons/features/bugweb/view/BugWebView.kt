package com.jeluchu.composefornewhorizons.features.bugweb.view

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.theme.cream

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BugWebView(
    navigate: Navigate,
    bugName: String,
    bugId: String
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(bugName) },
                navigationIcon = {
                    IconButton(onClick = { navigate.goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.DarkGray
                        )
                    }
                },
                backgroundColor = cream,
                elevation = 0.dp
            )
        }
    ) {
        // AndroidView() is a Composable that can be used to add
        // Android Views inside of a @Composable function,
        // for example a WebView
        AndroidView(factory = {
            WebView(it).apply {
                webViewClient = WebViewClient()
                loadUrl("https://nookipedia.com/wiki/$bugId")
            }
        })
    }
}

