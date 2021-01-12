package com.example.unifynd_test.ui.homescreen.tabs.tab2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unifynd_test.R
import com.example.unifynd_test.adapters.CountryAdapter
import com.example.unifynd_test.model.Country
import com.example.unifynd_test.utils.Utilities
import kotlinx.android.synthetic.main.fragment_tab2.*

class Tab2Fragment : Fragment(R.layout.fragment_tab2), Tab2Contract.View {

    lateinit var countryAdapter: CountryAdapter
    private val presenter: Tab2Presenter by lazy { Tab2Presenter(this) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        countryAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("country", it)
            }
            findNavController().navigate(
                R.id.action_tab1Fragment_to_viewFragment,
                bundle
            )
        }
    }


    private fun init() {
        countryAdapter = CountryAdapter()
        rv_grid.apply {
            adapter = countryAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
        rv_headers.apply {
            adapter = countryAdapter
            layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
        presenter.onViewCreated(Utilities.readJSONDataFromFile(requireContext()))
    }


    override fun loadCountries(countries: MutableList<Country>) {
        countryAdapter.differ.submitList(countries)
    }

}
