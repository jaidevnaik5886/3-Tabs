package com.example.unifynd_test.ui.homescreen.tabs.tab1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unifynd_test.R
import com.example.unifynd_test.adapters.CountryAdapter
import com.example.unifynd_test.model.Country
import com.example.unifynd_test.utils.Utilities
import kotlinx.android.synthetic.main.fragment_tab1.*


class Tab1Fragment : Fragment(R.layout.fragment_tab1), Tab1Contract.View {

    lateinit var countryAdapter: CountryAdapter
    private val presenter: Tab1Presenter by lazy { Tab1Presenter(this) }


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
        rv_countries.apply {
            adapter = countryAdapter
            layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
        presenter.onViewCreated(Utilities.readJSONDataFromFile(requireContext(), R.raw.dummy))
    }

    override fun loadCountries(countries: MutableList<Country>) {
        countryAdapter.differ.submitList(countries)
    }
}