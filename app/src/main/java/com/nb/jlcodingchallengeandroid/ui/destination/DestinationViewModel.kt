package com.nb.jlcodingchallengeandroid.ui.destination

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nb.jlcodingchallengeandroid.data.DatabaseHelper
import com.nb.jlcodingchallengeandroid.data.Repository
import com.nb.jlcodingchallengeandroid.network.ItemsListResponseDTO
import com.nb.jlcodingchallengeandroid.network.ResponseResult
import com.nb.jlcodingchallengeandroid.ui.destination.adapters.DestinationAdapter
import com.nb.jlcodingchallengeandroid.utils.DestinationSelectionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var calllingNumbersList = MutableLiveData<List<ItemsListResponseDTO>>()
    var destinationSelectionScreenType = MutableLiveData<DestinationSelectionType>()
    var callAdapter: DestinationAdapter =
        DestinationAdapter(mutableListOf(), destinationSelectionScreenType)
//    var contentList: ObservableArrayList<ItemsListResponseDTO> = ObservableArrayList()

    fun getCallingList() {
        uiScope.launch {
            when (val result = repository.getCallingList()) {
                is ResponseResult.Success -> {
                    result.data
                    calllingNumbersList.value = result.data
//                    mutableList = result.data
                    calllingNumbersList.value?.let { callAdapter?.setList(it) }

                }
                is ResponseResult.Error -> null
            }
        }
    }

    fun getBuyingItemsList() {
        uiScope.launch {
            when (val result = repository.getBuyList()) {
                is ResponseResult.Success -> {
                    result.data
                    calllingNumbersList.value = result.data
//                    mutableList = result.data
                    calllingNumbersList.value?.let { callAdapter?.setList(it) }
                }
                is ResponseResult.Error -> null
            }
        }
    }

    fun getSellingItemsList() {
        uiScope.launch {

//            mutableList = repository.getSellingItemsDataFromAssests()
            calllingNumbersList.value = repository.getSellingItemsDataFromAssests()
            calllingNumbersList.value?.let { callAdapter?.setList(it) }
        }
    }
}