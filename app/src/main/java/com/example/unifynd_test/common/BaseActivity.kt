package com.example.unifynd_test.common

import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.unifynd_test.R


open class BaseActivity : AppCompatActivity(), BaseView, NetworkHelper {

    fun getBaseApp(): BaseApplication? {
        return application as BaseApplication
    }

    open fun setToolbar(
        toolbar: Toolbar?,
        title: String?
    ) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar!!.title = ""
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            val toolbarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
            toolbarTitle.text = title
        }
    }

    open fun overrideToolbarBackIcon(@DrawableRes resource: Int) {
        if (supportActionBar != null) {
            supportActionBar!!.setHomeAsUpIndicator(resource)
        }
    }
}


