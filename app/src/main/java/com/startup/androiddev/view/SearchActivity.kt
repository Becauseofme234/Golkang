package com.startup.androiddev.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import com.startup.androiddev.view.adapter.AdapterProduk
import com.startup.androiddev.view.adapter.deleteProduk
import com.startup.androiddev.data.entity.Product
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    lateinit var vm: AndroidViewModel
    lateinit var adapters: AdapterProduk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)

        search.setOnClickListener {
            if (produkname.text.toString().isNotEmpty() && harga.text.toString().isNotEmpty()) {
                vm.searched(produkname.text.toString(), harga.text.toString().toInt()).observe(this,
                    Observer {
                        if (it.isNullOrEmpty()) {
                            Toast.makeText(this, "Data Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            adapters = AdapterProduk(it, this)

                            dataRV.apply {
                                layoutManager = LinearLayoutManager(this@SearchActivity)
                                adapter = adapters
                            }


                            adapters.deletedatax(object : deleteProduk {
                                override fun deleteproduk(produk: Product) {
                                    vm.deleteProduk(produk)
                                }

                            })
                        }
                    })


            } else {
                Toast.makeText(this, "edittable Kosong", Toast.LENGTH_SHORT).show()
            }
        }

    }
}