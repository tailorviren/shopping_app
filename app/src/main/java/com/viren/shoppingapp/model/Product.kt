package com.viren.shoppingapp.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Product(
    val brand: String,
    val id: String,
    val name: String,
    val offerPrice: String,
    val price: String,
    val productDesc: String,
    val productUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(offerPrice)
        parcel.writeString(price)
        parcel.writeString(productDesc)
        parcel.writeString(productUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}