package com.moeiny.reza.ninetest.core

import android.webkit.WebView
import androidx.databinding.BindingAdapter

/**
 * An object to handle loading a url onto an WebView  on XML file by using Binding
 */

object WebViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("webViewUrl")
    fun WebView.updateUrl(url: String?) {
        url?.let {
            loadUrl(url)
        }
    }
}