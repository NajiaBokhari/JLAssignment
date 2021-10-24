package com.nb.jlcodingchallengeandroid.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemsListResponseDTO(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("number")
    var number: String? = null,
    @SerializedName("price")
    var price: Double? = null,
    @SerializedName("quantity")
    var quantity: Int? = null,
    @SerializedName("type")
    var type: Int? = null
) : Parcelable