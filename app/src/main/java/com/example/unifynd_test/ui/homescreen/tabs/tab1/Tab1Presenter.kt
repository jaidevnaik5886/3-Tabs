package com.example.unifynd_test.ui.homescreen.tabs.tab1

import com.example.unifynd_test.model.Country
import com.example.unifynd_test.utils.AppConstants
import org.json.JSONArray
import org.json.JSONObject

class Tab1Presenter(private val view: Tab1Contract.View) : Tab1Contract.Presenter(view) {

    private val countryList = mutableListOf<Country>()

    override fun onViewCreated(jsonString: String) {
        view.loadCountries(addItemsFromJSON(jsonString))
    }

    private fun addItemsFromJSON(jsonDataString: String): MutableList<Country> {
        try {
            val jsoObj = JSONObject(jsonDataString)
            val result = jsoObj.getString(AppConstants.RESULT)
            val jsonArray = JSONArray(result)
            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val countryName = itemObj.getString(AppConstants.COUNTRY_NAME)
                val capitalName = itemObj.getString(AppConstants.COUNTRY_CAPITAL)
                val country = Country(countryName, capitalName)
                countryList.add(country)
            }
        } catch (e: Exception) {

        }
        return countryList
    }

}