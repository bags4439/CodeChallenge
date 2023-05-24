package com.test.codechallenge.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test.codechallenge.ui.personal_details.PersonDetailsFragment
import okhttp3.internal.immutableListOf

class HomeAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val ARG_OBJECT = "item"

    private val fragments = immutableListOf(Fragment(),PersonDetailsFragment(),Fragment())

    override fun getCount(): Int  = fragments.size

    override fun getItem(i: Int): Fragment {
        val fragment = fragments[i]
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, i + 1)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        var pageNumber = ""

        when(position){
            0-> pageNumber = "one"
            1-> pageNumber = "two"
            2-> pageNumber = "three"
        }

        return "Item $pageNumber"
    }
}
