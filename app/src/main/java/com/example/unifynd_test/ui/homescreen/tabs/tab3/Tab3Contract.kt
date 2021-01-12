package com.example.unifynd_test.ui.homescreen.tabs.tab3

import com.example.unifynd_test.common.BasePresenter
import com.example.unifynd_test.common.BaseView
import com.example.unifynd_test.model.Country

interface Tab3Contract{

    interface View : BaseView {
        fun showEnterNumberMsg()
        fun showAnswer(secondLargest: Int)
        fun showError()
        fun showAllNumbersAreSame()
    }

    abstract class Presenter protected constructor(view: BaseView) : BasePresenter(view) {
        abstract fun onDoneClicked(numbers: String)


    }
}