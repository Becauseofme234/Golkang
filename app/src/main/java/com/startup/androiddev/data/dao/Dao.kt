package com.startup.androiddev.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.startup.androiddev.data.entity.Product
import com.startup.androiddev.data.entity.UserName


@Dao
interface Dao {

    @Query("select * from UserName")
    fun getDAtaUser(): LiveData<List<UserName>>

    @Insert
    fun insertDataUser(name: UserName)

    @Delete
    fun deleteDataUser(name: UserName)

    @Query("update UserName set nama=:nama where  id =:idu")
    fun update(nama: String, idu: Int)

    @Query("select * from Product")
    fun getDAtaProduk(): LiveData<List<Product>>

    @Insert
    fun insertDataProduk(name: Product)

    @Delete
    fun deleteDataProduk(name: Product)

    @Query("update Product set produk=:produk , harga = :harga where  idProduk =:idu")
    fun updateProduk(produk: String, harga: Int, idu: Int)

    @Query("select * from Product where produk like :name and harga < :harga ")
    fun searching(name: String, harga: Int) : LiveData<List<Product>>
}