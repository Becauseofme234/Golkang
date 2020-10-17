package com.startup.androiddev.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import com.startup.androiddev.view.adapter.AdapterRecycler
import com.startup.androiddev.view.adapter.deletedata
import com.startup.androiddev.data.entity.UserName
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var vm: AndroidViewModel
    lateinit var adapters: AdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)

        datakosong.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }

        products.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
        }

        vm.getDataUser().observe(this, Observer {
            adapters = AdapterRecycler(it, this)

            if (it.isEmpty()) {
                datakosong.visibility = View.VISIBLE
            } else {
                datakosong.visibility = View.GONE
            }


            listdata.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = adapters
            }


            adapters.delete(object : deletedata {
                override fun delete(n: UserName) {
                    vm.deleteUser(UserName(id = n.id, name = n.name))
                }

            })
        })


    }
}

