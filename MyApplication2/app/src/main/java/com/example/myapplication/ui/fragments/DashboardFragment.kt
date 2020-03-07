package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.ui.teste.FragmentTab
import com.example.myapplication.viewmodel.DashboardViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class DashboardFragment : Fragment() {
    private val dashboardViewModel: DashboardViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.activity_fragment_one, container, false)
        //Toolbar toolbar = root.findViewById(R.id.toolbar);
        val tabLayout = root.findViewById<View>(R.id.tabLayout) as TabLayout
        val viewPager = root.findViewById<View>(R.id.viewpager) as ViewPager
        val mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        viewPager.adapter = PagerAdapter(fragmentManager, 3)
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        return root
    }

    inner class PagerAdapter(fm: FragmentManager?, var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm!!) {
        private val tabTitles = arrayOf("VÍDEOS", "ARTIGOS", "CITAÇÕES")
        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> FragmentTab()
                1 -> FragmentTab()
                2 -> FragmentTab()
                else -> FragmentTab()
            }
        }

        override fun getCount(): Int {
            return mNumOfTabs
        }

    }
}