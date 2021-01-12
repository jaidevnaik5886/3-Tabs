package com.example.unifynd_test.ui.homescreen.tabs.tab3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.unifynd_test.R
import kotlinx.android.synthetic.main.fragment_tab3.*

class Tab3Fragment : Fragment(R.layout.fragment_tab3), Tab3Contract.View {

    private val presenter: Tab3Presenter by lazy { Tab3Presenter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        btn_done.setOnClickListener {
            presenter.onDoneClicked(edt_number.text.toString())
        }
    }

    override fun showEnterNumberMsg() {
        Toast.makeText(requireContext(),"Please enter a number",Toast.LENGTH_SHORT).show()
    }

    override fun showAnswer(secondLargest: Int) {
        txt_answer.visibility = View.VISIBLE
        txt_answer.text = "$secondLargest"
        txt_ques.visibility = View.VISIBLE
        txt_ques.text = "is the the second largest number from ${edt_number.text}"
    }

    override fun showError() {
        Toast.makeText(requireContext(),"Please enter atleast 2 numbers to find the second largest number",Toast.LENGTH_SHORT).show()
    }

    override fun showAllNumbersAreSame() {
        txt_answer.visibility = View.GONE
        txt_ques.visibility = View.GONE
        Toast.makeText(requireContext(),"All numbers are same",Toast.LENGTH_SHORT).show()
    }
}








