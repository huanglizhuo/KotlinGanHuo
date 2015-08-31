package com.lizhuo.kotlinlearning.FuLi

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.facebook.drawee.view.SimpleDraweeView
import com.lizhuo.kotlinlearning.R
import com.squareup.picasso.Picasso
import uk.co.senab.photoview.PhotoViewAttacher

/**
 * Created by lizhuo on 15-8-28.
 */

public class FuLiDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuli_detail)
        var toolbar = findViewById(R.id.backtoolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar().setDisplayShowTitleEnabled(false)
        val actionbar = getSupportActionBar()
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha)
        var fuli_image = findViewById(R.id.fuli_image) as ImageView
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(fuli_image)
        var mAttach = PhotoViewAttacher(fuli_image)
    }
}