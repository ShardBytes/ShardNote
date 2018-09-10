package com.shardbytes.shardnote

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    
    private lateinit var viewPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup navigation listener
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
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
    
    // --- adapters
    
    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = when(position) {
            0 -> NotesFragment()
            1 -> CompleteFragment()
            2 -> SettingsFragment()
            
            else -> NotesFragment()
        }

        // COUNT OF ALL PAGES !
        override fun getCount() = 3
        
    }
}
