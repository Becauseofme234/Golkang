package com.startup.androiddev.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val idProduk: Int = 0,
    @ColumnInfo(name = "produk")
    val produk: String,
    @ColumnInfo(name = "harga")
    val harga: Int
)