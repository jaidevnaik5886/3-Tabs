package com.example.unifynd_test.ui.viewscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.unifynd_test.R
import kotlinx.android.synthetic.main.fragment_view.*


class ViewFragment : Fragment(R.layout.fragment_view) {

    val args: ViewFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val country = args.country
        txt_label.text = "The capital of ${country.countryName} is ${country.capitalName}"
    }
}