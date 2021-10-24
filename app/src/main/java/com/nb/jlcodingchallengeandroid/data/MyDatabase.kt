package com.nb.jlcodingchallengeandroid.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import java.util.*


class MyDatabase(context: Context?) :
    SQLiteAssetHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    var mutableSellingItemsList = MutableLiveData<List<ItemToSell>>()
    val sellingList = ArrayList<ItemToSell>()

    companion object {
        private const val DATABASE_NAME = "jl-demo-db.db"
        private const val DATABASE_VERSION = 1
    }

    @SuppressLint("Range")
    fun getAllItems(): MutableLiveData<List<ItemToSell>> {
        val selectQuery = "SELECT  * FROM " + "ItemToSell" + " ORDER BY " +
                ItemToSell.COLUMN_ID.toString() + " DESC"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val itemToSell = ItemToSell()
                itemToSell.id = cursor.getInt(cursor.getColumnIndex(ItemToSell.COLUMN_ID))
                itemToSell.name = cursor.getString(cursor.getColumnIndex(ItemToSell.COLUMN_NAME))
                itemToSell.price = cursor.getDouble(cursor.getColumnIndex(ItemToSell.COLUMN_PRICE))
                itemToSell.quantity =
                    cursor.getInt(cursor.getColumnIndex(ItemToSell.COLUMN_QUANTITY))
                itemToSell.type = cursor.getInt(cursor.getColumnIndex(ItemToSell.COLUMN_TYPE))

                sellingList.add(itemToSell)
            } while (cursor.moveToNext())
        }
        mutableSellingItemsList.value = sellingList

        db.close()

        return mutableSellingItemsList
    }
}