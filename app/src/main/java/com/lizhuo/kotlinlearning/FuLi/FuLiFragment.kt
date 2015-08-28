package com.lizhuo.kotlinlearning.FuLi

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.google.gson.Gson
import com.lizhuo.kotlinlearning.Model.ConstantName
import com.lizhuo.kotlinlearning.Model.GanHuo
import com.lizhuo.kotlinlearning.R
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import java.io.IOException

/**
 * Created by lizhuo on 15-8-27.
 */

public class FuLiFragment: Fragment() {
    private var ganhuo = GanHuo()
    private var recy: RecyclerView ?=null
    private var handler: Handler ?=null
    private var refresh: SwipeRefreshLayout ?=null
    private var progressbar: ProgressBar ?=null

    init {
        handler = object: Handler(){
            override fun handleMessage(msg: Message) {
                when (msg.what){
                    1 -> {
                        var adapter = FuLiAdapter(getActivity().getApplicationContext(),ganhuo)
                        recy?.setAdapter(adapter)
                        recy?.setVisibility(View.VISIBLE)
                        progressbar?.setVisibility(View.GONE)
                        refresh?.setRefreshing(false)
                    }
                    2 -> {
                        Toast.makeText(getActivity().getApplicationContext(),"网络有些问题:( 稍后试试", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        };
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_ganhuo,container,false)
        recy = rootView.findViewById(R.id.ganhuo_recy) as RecyclerView
        refresh = rootView.findViewById(R.id.swip_refresh) as SwipeRefreshLayout
        progressbar = rootView.findViewById(R.id.progressbar) as ProgressBar
        return rootView
    }

    override fun onStart() {
        super.onStart()
        refresh?.setRefreshing(true)
        GetFuLi()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(getActivity())
        refresh?.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                GetFuLi()
            }
        });
        refresh?.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        recy?.setLayoutManager(layoutManager)
    }

    fun GetFuLi() {
        var url = "http://gank.avosapps.com/api/data/福利/1000/1"
        val gson = Gson()
        var client = OkHttpClient();
        val request = Request.Builder().url(url).build()

        client.clone().newCall(request).enqueue(object : Callback {
            override fun onResponse(response: Response) {
                var res = response.body().string()
                ganhuo = gson.fromJson(res, javaClass<GanHuo>())
                handler?.sendEmptyMessage(1)
            }
            override fun onFailure(request: Request?, e: IOException?) {
                handler?.sendEmptyMessage(2)
            }
        });
    }

}