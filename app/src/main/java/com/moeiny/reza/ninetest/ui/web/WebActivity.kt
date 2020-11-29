package com.moeiny.reza.ninetest.ui.web

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.moeiny.reza.ninetest.R
import com.moeiny.reza.ninetest.databinding.ActivityShowBinding
import com.moeiny.reza.ninetest.data.model.uimodel.ShowUrlModel


class WebActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityShowBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_show)

        val bundle = intent.extras
        var url = bundle?.getString("Url")
        if (url!=null && url!="") {
            val showUrl =
                ShowUrlModel(url)
            mBinding.showUrl=showUrl
            }
        }
    }







