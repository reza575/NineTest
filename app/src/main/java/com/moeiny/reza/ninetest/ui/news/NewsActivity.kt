package com.moeiny.reza.ninetest.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moeiny.reza.ninetest.AndroidApplication
import com.moeiny.reza.ninetest.R
import com.moeiny.reza.ninetest.adapter.NewsAdapter
import com.moeiny.reza.ninetest.core.viewmodel.MyViewModelFactory
import com.moeiny.reza.ninetest.databinding.ActivityMainBinding
import com.moeiny.reza.ninetest.ui.web.WebActivity


class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    lateinit var mBinding: ActivityMainBinding

    private val adapter:NewsAdapter by lazy {
        NewsAdapter(viewModel::onCardClicked)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * function setUpParameter: Assign parameters and values
         */
        setUpView()
        /**
         * function setupLiveData:fetch Data from repository and post to UI Activity
         */
        setupLiveData()

        mBinding.updatTextView.setOnClickListener {
            if (mBinding.updatTextView.text.toString().equals("Login"))
                mBinding.updatTextView.setText("Welcome to Nine News")
            else if (mBinding.updatTextView.text.toString().equals("Welcome to Nine News"))
                mBinding.updatTextView.setText("Login")
        }
    }



    private fun setUpView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MyViewModelFactory( application as AndroidApplication)).get(
            NewsViewModel::class.java )
        mBinding.recyclerView.adapter = adapter
    }

    private fun setupLiveData(){
        viewModel.newsLiveData.observe(this, Observer {showAssetList->
            mBinding.loadingPanel.visibility = if(showAssetList.isNotEmpty()) View.GONE else View.VISIBLE
            adapter.assetModelList = showAssetList
        })

        viewModel.loadingLiveData.observe(this, Observer {
            mBinding.loadingPanel.visibility = if(it) View.VISIBLE else View.GONE
        })

        viewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this,"error on loading Data",Toast.LENGTH_SHORT).show()
        })

        viewModel.showNewsLiveData.observe(this, Observer { url ->
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("Url", url)
            this.startActivity(intent)
        })
    }
}
