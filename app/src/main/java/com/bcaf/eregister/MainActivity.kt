package com.bcaf.eregister

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the WebView
        val webView: WebView = findViewById(R.id.webview)

        // Enable JavaScript (needed for Angular apps)
        webView.settings.javaScriptEnabled = true

        // Set WebViewClient to make sure URLs open in the WebView, not in an external browser
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                // Handle URL redirection within WebView
                return false
            }
        }

        // Load the Angular application URL
        // Use "http://10.0.2.2:4200" for Android Emulator to access localhost
        webView.loadUrl("https://1d50-114-79-7-110.ngrok-free.app")  // Replace with the actual URL if deployed online
    }

    // Handle back button press to navigate within WebView instead of exiting the app
    override fun onBackPressed() {
        val webView: WebView = findViewById(R.id.webview)
        if (webView.canGoBack()) {
            webView.goBack()  // Navigate back in WebView history
        } else {
            super.onBackPressed()  // Exit the app if no history left in WebView
        }
    }
}

