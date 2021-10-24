package com.nb.jlcodingchallengeandroid.utils

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("recycleViewAdapter")

    fun setRecycleViewAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>?
    ) {
        if (null == adapter)
            return
        recyclerView.adapter = adapter
    }

    @BindingAdapter("concatenateTitle", "concatenateValue")
    @JvmStatic
    fun concatenateValuesWithTitle(
        textView: AppCompatTextView,
        concatenateTitle: String,
        concatenateValue: Any?
    ) {
        if (concatenateValue != null) {
            textView.text = concatenateTitle.plus(concatenateValue.toString())
        }
    }
}