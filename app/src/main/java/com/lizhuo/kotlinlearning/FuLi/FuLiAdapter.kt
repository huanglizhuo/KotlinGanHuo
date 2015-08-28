package com.lizhuo.kotlinlearning.FuLi

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.lizhuo.kotlinlearning.Model.GanHuo
import com.lizhuo.kotlinlearning.R

/**
 * Created by lizhuo on 15-8-27.
 */

public class FuLiAdapter(private val context: Context,private val ganHuo: GanHuo): RecyclerView.Adapter<FuLiAdapter.FuliViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuliViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.with_pic_data_item, parent, false)
        val nvh = FuliViewHolder(v)
        return nvh
    }

    override fun onBindViewHolder(holder: FuliViewHolder, i: Int) {
        holder.fuliImage?.setAspectRatio(1.0f);
        holder.fuliImage?.setImageURI(Uri.parse(ganHuo.getResults().get(i).getUrl()))
        holder.fuliImage?.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(context, javaClass<FuLiDetailActivity>())
                intent.putExtra("url",ganHuo.getResults().get(i).getUrl())
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
        });

        holder.editerName?.setText(ganHuo.getResults().get(i).getWho())
        holder.publish_time?.setText(ganHuo.getResults().get(i).getPublishedAt().subSequence(0,10))
        var url = Uri.parse("")
        when (ganHuo.getResults().get(i).getWho()) {
            "张涵宇" -> url = Uri.parse("http://gank.io/images/avatars/xiaobei.jpg")
            "鲍永章" -> url = Uri.parse("http://gank.io/images/avatars/baoyongzhang.jpg")
            "jk2K" -> url = Uri.parse("http://gank.io/images/avatars/jk2K.jpg")
            "CallMeWhy" -> url = Uri.parse("http://gank.io/images/avatars/wanghai.jpg")
            "Andrew Liu" -> url = Uri.parse("http://gank.io/images/avatars/andrew_liu.jpg")
            "Huan" -> url = Uri.parse("http://gank.io/images/avatars/huan.jpg")
            "有时放纵" -> url = Uri.parse("http://gank.io/images/avatars/fangzong.jpg")
            "李明亮" -> url = Uri.parse("http://gank.io/images/avatars/liangliang.jpg")
            "狄加怡" -> url = Uri.parse("http://gank.io/images/avatars/dijiayi.jpg")
            "Tiime" -> url = Uri.parse("http://gank.io/images/avatars/tiime.jpg")
            "代码家","daimajia"-> url = Uri.parse("http://gank.io/images/avatars/daimajia.jpg")
            "V." -> url = Uri.parse("http://gank.io/images/avatars/v.jpg")
            "Jason" -> url = Uri.parse("http://gank.io/images/avatars/jason.jpg")
            "只怪手速不够快" -> url = Uri.parse("http://gank.io/images/avatars/shousu.jpg")
            "大城小黄" -> url = Uri.parse("http://gank.io/images/avatars/dachengxiaohuang.jpg")
            "andyiac" -> url = Uri.parse("http://gank.io/images/avatars/andyiac.jpg")
            "瞎了狗眼的牛肉" -> url = Uri.parse("http://gank.io/images/avatars/niurou.jpg")
            "小曹" -> url = Uri.parse("http://gank.io/images/avatars/xiaocao.jpg")
            "LHF" -> url = Uri.parse("http://gank.io/images/avatars/LHF.jpg")
            "lxxself" -> url = Uri.parse("http://gank.io/images/avatars/lxxself.jpg")
            else -> url = null
        }
        if (url != null){
            holder.editerAvter?.setImageURI(url)
        }else{

        }

    }

    override fun getItemCount(): Int {
        return ganHuo.getResults().size()
    }

    class FuliViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        var fuliImage: SimpleDraweeView ?= null
        var editerAvter: SimpleDraweeView ?=null
        var editerName: TextView ?= null
        var publish_time: TextView ?=null
        init {
            fuliImage = itemview.findViewById(R.id.fuli_image) as SimpleDraweeView
            editerAvter = itemview.findViewById(R.id.editer_avter) as SimpleDraweeView
            editerName = itemview.findViewById(R.id.editer_name) as TextView
            publish_time = itemview.findViewById(R.id.publish_time) as TextView
        }
    }
}