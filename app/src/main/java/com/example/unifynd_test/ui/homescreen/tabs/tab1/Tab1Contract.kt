package com.example.unifynd_test.ui.homescreen.tabs.tab1

import com.example.unifynd_test.common.BasePresenter
import com.example.unifynd_test.common.BaseView
import com.example.unifynd_test.model.Country

interface Tab1Contract{

    interface View : BaseView {
        fun loadCountries(countries: MutableList<Country>)
    }

    abstract class Presenter protected constructor(view: BaseView) : BasePresenter(view) {
        abstract fun onViewCreated(jsonString: String)


    }
}