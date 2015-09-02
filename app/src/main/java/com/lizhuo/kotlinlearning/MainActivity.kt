package com.lizhuo.kotlinlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TableLayout
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.Gson
import com.lizhuo.kotlinlearning.FuLi.FuLiFragment
import com.lizhuo.kotlinlearning.GanHuo.GanHuoFragment
import com.lizhuo.kotlinlearning.Model.ConstantName
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import org.json.JSONObject
import java.io.IOException

public class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        Fresco.initialize(getApplicationContext())
        initView()
    }

    fun initView() {
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
//        getSupportActionBar().setDisplayShowTitleEnabled(false)

        val viewPageAdapter = ViewPagerAdapter(getSupportFragmentManager())

        viewPageAdapter.addFragment(GanHuoFragment(ConstantName.ANDROID),"android")
        viewPageAdapter.addFragment(GanHuoFragment(ConstantName.IOS),"ios")
        viewPageAdapter.addFragment(GanHuoFragment(ConstantName.FRONT_END),"前端")
        viewPageAdapter.addFragment(GanHuoFragment(ConstantName.EXTANTION_RESUSE),"扩展资源")
        viewPageAdapter.addFragment(FuLiFragment(),"福利")
//        viewPageAdapter.addFragment(GanHuoFragment(ConstantName.REST_VIDEO),"休息视频")
        var viewPager = findViewById(R.id.viewpager) as ViewPager
        viewPager.setAdapter(viewPageAdapter)

        var tablayout = findViewById(R.id.tabs) as TabLayout
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE)
        tablayout.setupWithViewPager(viewPager)
    }

}

