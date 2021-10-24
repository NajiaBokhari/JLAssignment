package com.nb.jlcodingchallengeandroid.data

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(ItemToSell.CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    // Select All Selling items Query
    @SuppressLint("Range")
    fun getsellingItemsList(): ArrayList<ItemToSell> {
        val sellingItemsMutableList = ArrayList<ItemToSell>()
        val selectQuery = "SELECT  * FROM " + "ItemToSell" + " ORDER BY " +
                ItemToSell.COLUMN_ID.toString() + " DESC"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val itemToSell = ItemToSell()
                itemToSell.id = cursor.getInt(cursor.getColumnIndex(ItemToSell.COLUMN_ID))
                itemToSell.name =
                    cursor.getString(cursor.getColumnIndex(ItemToSell.COLUMN_NAME))
                itemToSell.price =
                    cursor.getDouble(cursor.getColumnIndex(ItemToSell.COLUMN_PRICE))
                itemToSell.quantity =
                    cursor.getInt(cursor.getColumnIndex(ItemToSell.COLUMN_QUANTITY))
                itemToSell.type = cursor.getInt(cursor.getColumnIndex(ItemToSell.COLUMN_TYPE))
                sellingItemsMutableList.add(itemToSell)
            } while (cursor.moveToNext())
        }
        db.close()
        return sellingItemsMutableList
    }


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "jl-demo-db.db"
    }
}

