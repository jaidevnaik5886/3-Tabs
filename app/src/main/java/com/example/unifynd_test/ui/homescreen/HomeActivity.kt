package com.example.unifynd_test.ui.homescreen

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.unifynd_test.R
import com.example.unifynd_test.common.BaseActivity
import com.example.unifynd_test.utils.AppConstants
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.generic_toolbar.*

class HomeActivity : BaseActivity(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setToolbar(toolbar, AppConstants.HomeScreen)
        initView()
    }

    private fun initView() {
        resources.openRawResource(R.raw.dummy)
        bottomNavigationView.setupWithNavController(homeNavHostFragment.findNavController())
    }
}