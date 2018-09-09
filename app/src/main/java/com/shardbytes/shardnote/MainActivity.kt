package com.shardbytes.shardnote

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_notes -> switchFragment(NotesFragment())
            R.id.navigation_complete -> switchFragment(CompleteFragment())
            R.id.navigation_settings -> toast("settings")
            
            else -> return@OnNavigationItemSelectedListener false
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        switchFragment(NotesFragment())
    }
    
    fun switchFragment(f: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, f)
                .commit()
    }
}
