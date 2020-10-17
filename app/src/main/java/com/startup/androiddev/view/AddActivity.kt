package com.startup.androiddev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import com.startup.androiddev.data.entity.UserName
import kotlinx.android.synthetic.main.item_data.*

class AddActivity : AppCompatActivity() {

    lateinit var vm: AndroidViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)

        tambah.setOnClickListener {
            if (name.text.toString().isNotEmpty()) {
                vm.insertDataUser(UserName(name = name.text.toString()))
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Isi Dulu !", Toast.LENGTH_SHORT).show()
            }

        }


    }
}