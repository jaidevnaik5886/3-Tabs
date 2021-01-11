package com.example.unifynd_test.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.unifynd_test.R
import com.example.unifynd_test.model.Country
import kotlinx.android.synthetic.main.item_list_country.view.*

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.capitalName == newItem.capitalName
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_country,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Country) -> Unit)? = null

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = differ.currentList[position]
        holder.itemView.apply {
            txt_title.text = country.countryName
            txt_subtitle.text = country.capitalName
            setOnClickListener {
                onItemClickListener?.let { it(country) }
            }
        }
    }

    fun setOnItemClickListener(listener: (Country) -> Unit) {
        onItemClickListener = listener
    }
}