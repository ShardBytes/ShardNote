package com.shardbytes.shardnote


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.support.v4.toast

class NotesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onResume() {
        super.onResume()
        toast("notes resumed")
    }

    override fun onPause() {
        toast("notes paused")
        super.onPause()
    }

}