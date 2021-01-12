package com.example.unifynd_test.ui.homescreen.tabs.tab2

import com.example.unifynd_test.common.BasePresenter
import com.example.unifynd_test.common.BaseView
import com.example.unifynd_test.model.Country

interface Tab2Contract{

    interface View : BaseView {
        fun loadCountries(countries: MutableList<Country>)
    }

    abstract class Presenter protected constructor(view: BaseView) : BasePresenter(view) {
        abstract fun onViewCreated(jsonString: String)


    }
}