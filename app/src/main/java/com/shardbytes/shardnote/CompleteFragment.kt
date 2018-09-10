package com.shardbytes.shardnote

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class CompleteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_complete, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isResumed) { // if fragment is in resumed state ( so no nullpointer )
            if (isVisibleToUser) {
                Toast.makeText(activity, "YES", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "NO", Toast.LENGTH_SHORT).show()
            }
        }
    }
}