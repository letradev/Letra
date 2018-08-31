package com.athul.letra.features.ui.home.adaptor

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList

class FragmentAdaptor constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private lateinit var mfragmentmanager: FragmentManager

    private val fragments = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment {

        return fragments.get(position)

    }


    override fun getCount(): Int {
        return if (fragments != null)
            fragments.size
        else
            0

    }


    fun AddFragment(fragment: Fragment) {
        if (fragments != null)
            fragments.add(fragment)
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return "Page $position"
    }


}