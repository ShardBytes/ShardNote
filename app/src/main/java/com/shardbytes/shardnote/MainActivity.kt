package com.shardbytes.shardnote

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    
    private val VIEWPAGER_PAGECOUNT = 3
    private lateinit var viewPagerAdapter: PagerAdapter

    // activity
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // setup viewpager
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        viewPager.addOnPageChangeListener(onPageChangeListener)

        // setup navigation listener
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Core", "activity resumed")
    }
    
    // --- specific
    
    // --- listeners
    
    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_notes -> viewPager.currentItem = 0
            R.id.navigation_complete-> viewPager.currentItem = 1
            R.id.navigation_settings -> viewPager.currentItem = 2
        }
        true
    }
    
    private val onPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            if (position < VIEWPAGER_PAGECOUNT) {
                navigation.menu.getItem(position).isChecked = true
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}

    }
    
    // --- adapters
    
    private inner class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = when(position) {
            0 -> NotesFragment()
            1 -> CompleteFragment()
            2 -> SettingsFragment()
            
            else -> NotesFragment()
        }

        // COUNT OF ALL PAGES !
        override fun getCount() = VIEWPAGER_PAGECOUNT
        
    }
}
