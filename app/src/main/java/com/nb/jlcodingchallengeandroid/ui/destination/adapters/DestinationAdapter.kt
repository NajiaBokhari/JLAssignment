package com.nb.jlcodingchallengeandroid.ui.destination.adapters

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import com.nb.jlcodingchallengeandroid.R
import com.nb.jlcodingchallengeandroid.databinding.ItemCallBinding
import com.nb.jlcodingchallengeandroid.network.ItemsListResponseDTO
import com.nb.jlcodingchallengeandroid.ui.destination.adapters.viewholders.DestinationItemViewHolder
import com.nb.jlcodingchallengeandroid.utils.DestinationSelectionType


class DestinationAdapter(
    private val list:  MutableList<ItemsListResponseDTO>, val destinationSelectionType
    : MutableLiveData<DestinationSelectionType>
) : BaseBindingRecyclerAdapter<ItemsListResponseDTO, DestinationItemViewHolder>(
    list
) {
    override fun getLayoutIdForViewType(viewType: Int): Int = R.layout.item_call

    override fun onCreateViewHolder(binding: ViewDataBinding): DestinationItemViewHolder {
        return DestinationItemViewHolder(
            binding as ItemCallBinding
        )
    }

    override fun onBindViewHolder(holder: DestinationItemViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        destinationSelectionType.value?.let { holder.onBind(list[position], position, it) }
    }
}
