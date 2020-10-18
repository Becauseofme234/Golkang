package com.startup.androiddev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import com.startup.androiddev.view.adapter.AdapterProduk
import com.startup.androiddev.view.adapter.deleteProduk
import com.startup.androiddev.data.entity.Product
import kotlinx.android.synthetic.main.activity_product.*

class  ProductActivity : AppCompatActivity() {

    lateinit var vm: AndroidViewModel
    lateinit var adapters: AdapterProduk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)

        datakosong.setOnClickListener {
            startActivity(Intent(this, AddProduk::class.java))
        }

        vm.getDataProduk().observe(this, Observer {
            if (it.isEmpty()) {
                datakosong.visibility = View.VISIBLE
            } else {
                datakosong.visibility = View.GONE
            }

            adapters = AdapterProduk(it, this)

            listdata.apply {
                layoutManager = LinearLayoutManager(this@ProductActivity)
                adapter = adapters
            }

            search.setOnClickListener {
                startActivity(Intent(this, SearchActivity::class.java))
            }

            adapters.deletedatax(object : deleteProduk {
                override fun deleteproduk(produk: Product) {
                    vm.deleteProduk(produk)
                }

            })

        })

    }
}