package com.soobinpark.webviewexample

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var etAddressEdit: EditText
    lateinit var btnGo: Button
    lateinit var wviewMain: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etAddressEdit = findViewById(R.id.et_address_edit)
        btnGo = findViewById(R.id.btn_go)
        wviewMain = findViewById(R.id.wview_main)

        // webview
        val webSettings = wviewMain.settings
        webSettings.javaScriptEnabled = true
        wviewMain.webViewClient = WebViewClient()
    }

    fun onClick(view: View) {
        var address = etAddressEdit.text.toString()
        if(!address.startsWith("http://"))
            address = "http://$address"
        wviewMain.loadUrl(address)
    }
}
