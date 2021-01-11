package com.example.unifynd_test.ui.homescreen.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.unifynd_test.R

class Tab2Fragment : Fragment(R.layout.fragment_tab2) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

    }
}