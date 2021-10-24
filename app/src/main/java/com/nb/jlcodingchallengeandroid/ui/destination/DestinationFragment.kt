package com.nb.jlcodingchallengeandroid.ui.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nb.jlcodingchallengeandroid.R
import com.nb.jlcodingchallengeandroid.databinding.FragmentDestinationBinding
import com.nb.jlcodingchallengeandroid.utils.DestinationSelectionType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DestinationFragment : Fragment() {

    private lateinit var binding: FragmentDestinationBinding
    private val viewModel: DestinationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_destination, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        viewModel.destinationSelectionScreenType.value =
            DestinationFragmentArgs.fromBundle(requireArguments()).destinationSelectionScreenType
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        getDataList()
        viewModel.getSellingItemsList()

    }

    fun getDataList() {
        when (viewModel.destinationSelectionScreenType.value) {
            DestinationSelectionType.CALL -> viewModel.getCallingList()
            DestinationSelectionType.BUY -> viewModel.getBuyingItemsList()
            DestinationSelectionType.SELL -> viewModel.getSellingItemsList()

        }
    }
}