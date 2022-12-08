package com.example.myapp

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(this)
        webView!!.settings.javaScriptEnabled = true
        val activity: Activity = this
        webView!!.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java", ReplaceWith(
                "Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()",
                "android.widget.Toast",
                "android.widget.Toast"
            )
            )
            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
            }

            @TargetApi(Build.VERSION_CODES.M)
            override fun onReceivedError(
                view: WebView,
                req: WebResourceRequest,
                rerr: WebResourceError
            ) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                req.url.toString()
                Toast.makeText(
                    activity, rerr.description.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        webView!!.loadUrl("https://2ch.hk/")
        setContentView(webView)
    }
}