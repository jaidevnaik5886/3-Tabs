package com.example.unifynd_test.ui.homescreen.tabs.tab3

class Tab3Presenter(private val view: Tab3Contract.View) : Tab3Contract.Presenter(view) {

    override fun onDoneClicked(numbers: String) {
        if (numbers.isNotEmpty()) {
            when (numbers.length) {
                1 -> {
                    view.showError()
                }
                else -> { getSecondLargest(convertIntToIntArr(numbers.toLong())) }
            }
        } else {
            view.showEnterNumberMsg()
        }
    }

    private fun convertIntToIntArr(number: Long): IntArray {
        var num = number
        var i = 0
        val length = num.toString().length
        val arr = IntArray(length)
        while (num != 0L) {
            arr[length - i - 1] = (num % 10L).toInt()
            num /= 10
            i++
        }
        return arr
    }

    private fun getSecondLargest(num: IntArray) {
        val sortedArr = num.sortedArray()
        val max = num.max()
        val withoutMaxArr =sortedArr.filter { it < max!! }
        if (withoutMaxArr.isNotEmpty()){
            view.showAnswer(withoutMaxArr.last())
        }else{
            view.showAllNumbersAreSame()
        }
    }
}