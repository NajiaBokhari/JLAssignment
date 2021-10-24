package com.nb.jlcodingchallengeandroid.data

class ItemToSell {
    var id = 0
    var name: String? = null
    var price: Double? = null
    var quantity: Int? = null
    var type: Int = 2

    constructor() {}
    constructor(id: Int, name: String?, price: Double?, quantity: Int, type: Int) {
        this.id = id
        this.name = name
        this.price = price
        this.quantity = quantity
        this.type = type
    }

    companion object {
        const val TABLE_NAME = "ItemToSell"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_PRICE = "price"
        const val COLUMN_QUANTITY = "quantity"
        const val COLUMN_TYPE = "type"

        const val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_PRICE + " DOUBLE,"
                + COLUMN_QUANTITY + " INTEGER,"
                + COLUMN_TYPE + " INTEGER"
                + ")")

    }
}


