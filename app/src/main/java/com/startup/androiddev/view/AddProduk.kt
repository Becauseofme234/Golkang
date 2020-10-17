package com.startup.androiddev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import com.startup.androiddev.data.entity.Product
import kotlinx.android.synthetic.main.activity_add_produk.*

class AddProduk : AppCompatActivity() {

    lateinit var vm: AndroidViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_produk)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)

        tambah.setOnClickListener {
            vm.insertDataProduk(
                Product(
                    produk = nama.text.toString(),
                    harga = harga.text.toString().toInt()
                )
            )

            startActivity(Intent(this, ProductActivity::class.java))
        }
    }
}