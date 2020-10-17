package com.startup.androiddev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import kotlinx.android.synthetic.main.activity_edit_produk.*

class EditProduk : AppCompatActivity() {

    lateinit var vm: AndroidViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_produk)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)

        nama.setText(intent.getStringExtra("name"))
        harga.setText(intent.getIntExtra("harga", 0).toString())

        edit.setOnClickListener {
            vm.upodateProduk(
                nama.text.toString(),
                harga.text.toString().toInt(),
                intent.getIntExtra("id", 0)
            )

            startActivity(Intent(this, ProductActivity::class.java))
        }

    }
}