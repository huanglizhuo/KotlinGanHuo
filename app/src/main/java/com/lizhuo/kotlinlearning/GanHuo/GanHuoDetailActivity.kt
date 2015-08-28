package com.lizhuo.kotlinlearning.GanHuo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import com.lizhuo.kotlinlearning.R

/**
 * Created by lizhuo on 15-8-27.
 */

public class GanHuoDetailActivity: AppCompatActivity() {

    private var ganhuoDetail: WebView?=null
    private var progressbar: ProgressBar?=null
//    private var handler = object: Handler() {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            when (msg.what){
//                1 -> {
//                    ganhuoDetail?.setVisibility(View.VISIBLE)
//                    }
//                }
//        }
//    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganhuo_detail)
        var toolbar = findViewById(R.id.backtoolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionbar = getSupportActionBar()
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha)

        ganhuoDetail = findViewById(R.id.ganhuo_detail) as WebView
        progressbar = findViewById(R.id.progressbar) as ProgressBar

        ganhuoDetail?.loadUrl(getIntent().getStringExtra("url"))
        ganhuoDetail?.setWebViewClient(WebViewClientWithoutTitle());
        ganhuoDetail?.setWebChromeClient(WithProgressClient())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    inner class WithProgressClient: WebChromeClient(){
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if (newProgress==100){
                progressbar?.setVisibility(View.GONE)
            }else{
                progressbar?.setProgress(newProgress)
            }
        }
    }

    inner  class WebViewClientWithoutTitle: WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true;
        }
    }
}