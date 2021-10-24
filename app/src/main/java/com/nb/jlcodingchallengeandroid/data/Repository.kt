package com.nb.jlcodingchallengeandroid.data

import android.content.Context
import com.nb.jlcodingchallengeandroid.network.ItemsListResponseDTO
import com.nb.jlcodingchallengeandroid.network.JLDemoApiService
import com.nb.jlcodingchallengeandroid.network.ResponseResult
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiService: JLDemoApiService
) {
    suspend fun getCallingList(): ResponseResult<ArrayList<ItemsListResponseDTO>> {
        return withContext(Dispatchers.IO) {
            try {
                val callingList = apiService.getCallingList()
                Timber.d("success: $callingList")
                ResponseResult.Success(callingList)

            } catch (exception: IOException) {
                Timber.d("error: $exception")
                ResponseResult.Error(exception)
            } catch (exception: HttpException) {
                Timber.d("error: $exception")
                ResponseResult.Error(exception)
            }
        }
    }

    suspend fun getBuyList(): ResponseResult<ArrayList<ItemsListResponseDTO>> {
        return withContext(Dispatchers.IO) {
            try {
                val shoppingList = apiService.getBuyList()
                Timber.d("success: $shoppingList")
                ResponseResult.Success(shoppingList)

            } catch (exception: IOException) {
                Timber.d("error: $exception")
                ResponseResult.Error(exception)
            } catch (exception: HttpException) {
                Timber.d("error: $exception")
                ResponseResult.Error(exception)
            }
        }
    }

    fun getSellingItemsDataFromAssests(): MutableList<ItemsListResponseDTO> {
        var mutableList = mutableListOf<ItemsListResponseDTO>()
        var db = MyDatabase(context)
        val itemsList = db.getAllItems()
        for (item in itemsList.value!!) {
            val itemsListResponseDTO = ItemsListResponseDTO(
                id = item.id,
                name = item.name,
                number = null,
                quantity = item.quantity,
                price = item.price,
                type = item.type
            )
            mutableList.add(itemsListResponseDTO)
        }
        return mutableList
    }
}