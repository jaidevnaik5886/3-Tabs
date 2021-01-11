package com.example.unifynd_test.ui.homescreen

import com.example.unifynd_test.common.BasePresenter
import com.example.unifynd_test.common.BaseView
import com.example.unifynd_test.model.Country

interface HomeContract {

    interface View : BaseView {
    }

    abstract class Presenter protected constructor(view: BaseView) : BasePresenter(view) {


    }
}