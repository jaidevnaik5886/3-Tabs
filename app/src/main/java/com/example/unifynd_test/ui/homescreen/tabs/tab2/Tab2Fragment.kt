package com.example.unifynd_test.ui.homescreen.tabs.tab2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unifynd_test.R
import com.example.unifynd_test.adapters.GridAdapter
import com.example.unifynd_test.adapters.HeaderAdapter
import com.example.unifynd_test.model.Country
import com.example.unifynd_test.utils.Utilities
import kotlinx.android.synthetic.main.fragment_tab2.*

class Tab2Fragment : Fragment(R.layout.fragment_tab2), Tab2Contract.View {

    lateinit var headerAdapter: HeaderAdapter
    lateinit var gridAdapter: GridAdapter
    private val presenter: Tab2Presenter by lazy { Tab2Presenter(this) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        headerAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("country", it)
            }
            findNavController().navigate(
                R.id.action_tab2Fragment_to_viewFragment,
                bundle
            )
        }
    }


    private fun init() {
        headerAdapter = HeaderAdapter()
        gridAdapter = GridAdapter()
        rv_grid.isNestedScrollingEnabled = false
        rv_grid.apply {
            adapter = gridAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
        rv_headers.apply {
            adapter = headerAdapter
            layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
        presenter.onHeaderViewCreated(Utilities.readJSONDataFromFile(requireContext(),R.raw.header))
        presenter.onGridViewCreated(Utilities.readJSONDataFromFile(requireContext(),R.raw.grid))
    }


    override fun loadHeaders(headerList: MutableList<Country>) {
        headerAdapter.differ.submitList(headerList)
    }

    override fun loadGridView(gridList: MutableList<Country>) {
        gridAdapter.differ.submitList(gridList)
    }
}
