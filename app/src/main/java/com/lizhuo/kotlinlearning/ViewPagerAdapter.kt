package com.lizhuo.kotlinlearning

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*

/**
 * Created by lizhuo on 15-8-26.
 */

public class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var framents = ArrayList<Fragment>()
    private var fragmentTitle = ArrayList<String>()

    public fun addFragment(fragment: Fragment,title: String){
        framents.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getItem(position: Int): Fragment? {
        return framents.get(position)
    }

    override fun getCount(): Int {
        return framents.size()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle.get(position)
    }
}