package com.nb.jlcodingchallengeandroid.ui.destination.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.nb.jlcodingchallengeandroid.databinding.ItemCallBinding
import com.nb.jlcodingchallengeandroid.network.ItemsListResponseDTO
import com.nb.jlcodingchallengeandroid.utils.DestinationSelectionType

class DestinationItemViewHolder(
    private val itemCallBinding: ItemCallBinding
) :
    RecyclerView.ViewHolder(itemCallBinding.root) {
    fun onBind(
        itemsListResponseDTO: ItemsListResponseDTO,
        position: Int,
        destinationSelectionType: DestinationSelectionType
    ) {
        itemCallBinding.viewModel =
            DestinationItemViewModel(itemsListResponseDTO , destinationSelectionType.name)
        itemCallBinding.executePendingBindings()
    }
}
