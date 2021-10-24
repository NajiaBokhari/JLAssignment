package com.nb.jlcodingchallengeandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.nb.jlcodingchallengeandroid.R
import com.nb.jlcodingchallengeandroid.databinding.FragmentHomeBinding
import com.nb.jlcodingchallengeandroid.utils.DestinationSelectionType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var navController: NavController

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.buttonCall.setOnClickListener { loadDestinationScreen(DestinationSelectionType.CALL) }
        binding.buttonBuy.setOnClickListener { loadDestinationScreen(DestinationSelectionType.BUY) }
        binding.buttonSell.setOnClickListener { loadDestinationScreen(DestinationSelectionType.SELL) }
    }

    fun loadDestinationScreen(destinationSelectionType: DestinationSelectionType) {
        navController?.navigate(
            HomeFragmentDirections.actionHomeFragmentToDestinationFragment(
                destinationSelectionType
            )
        )
    }
}