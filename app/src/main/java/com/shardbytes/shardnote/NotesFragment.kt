package com.shardbytes.shardnote


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_notes.*
import org.jetbrains.anko.support.v4.toast

class NotesFragment : Fragment()  {

    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = (activity as MainActivity) // throws ex when not under MainActivity
        Log.i("Core", "notes attached to activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isResumed) { // if fragment is in resumed state ( so no nullpointer )
            if (isVisibleToUser) {
                
            } else {
                
            }
        }
    }

}