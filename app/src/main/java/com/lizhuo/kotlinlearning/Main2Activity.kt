package com.lizhuo.kotlinlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

public class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val hh = findViewById(R.id.hhhh) as TextView
        hh.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val i = Intent(getApplicationContext(), javaClass<GanHuoDetailActivity>())
                i.putExtra("url", "asdfasd")
                startActivity(i)
            }
        })
    }


}
