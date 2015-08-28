package com.lizhuo.kotlinlearning.FuLi

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    init {
        handler = object: Handler(){
            override fun handleMessage(msg: Message) {
                when (msg.what){
                    1 -> {
                        var adapter = FuLiAdapter(getActivity().getApplicationContext(),ganhuo)
                        recy?.setAdapter(adapter)
                    }

                }
            }
        };
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_ganhuo,container,false)
        recy = rootView.findViewById(R.id.ganhuo_recy) as RecyclerView
        return rootView
    }

    override fun onStart() {
        super.onStart()
        GetFuLi()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(getActivity())
        recy?.setLayoutManager(layoutManager)
    }

    fun GetFuLi() {
        var url = "http://gank.avosapps.com/api/data/福利/100/1"
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