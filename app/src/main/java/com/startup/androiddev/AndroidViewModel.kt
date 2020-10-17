package com.startup.androiddev

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.startup.androiddev.data.db.AppDatabase
import com.startup.androiddev.data.entity.Product
import com.startup.androiddev.data.entity.UserName
import java.util.concurrent.Executors

class AndroidViewModel(application: Application) : AndroidViewModel(application) {

    val executor = Executors.newFixedThreadPool(2)

    val db = AppDatabase.getDatabase(application)?.nameDao()

    fun getDataUser(): LiveData<List<UserName>> = db!!.getDAtaUser()

    fun insertDataUser(name: UserName) {
        executor.execute {
            db!!.insertDataUser(name)
        }
    }

    fun deleteUser(name: UserName) {
        executor.execute {
            db!!.deleteDataUser(name)
        }
    }

    fun upodateUser(name: String, id: Int) {
        executor.execute {
            db!!.update(name, id)
        }
    }

    fun getDataProduk(): LiveData<List<Product>> = db!!.getDAtaProduk()

    fun insertDataProduk(produk: Product) {
        executor.execute {
            db!!.insertDataProduk(produk)
        }
    }

    fun deleteProduk(produk: Product) {
        executor.execute {
            db!!.deleteDataProduk(produk)
        }
    }

    fun upodateProduk(name: String, harga: Int, id: Int) {
        executor.execute {
            db!!.updateProduk(name, harga, id)
        }
    }

    fun searched(name: String, harga: Int): LiveData<List<Product>> = db!!.searching(name, harga)
}