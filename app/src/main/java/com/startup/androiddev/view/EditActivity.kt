package com.startup.androiddev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.startup.androiddev.AndroidViewModel
import com.startup.androiddev.R
import kotlinx.android.synthetic.main.activity_edit.*


class EditActivity : AppCompatActivity() {

    lateinit var vm: AndroidViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        vm = ViewModelProvider(this).get(AndroidViewModel::class.java)
        name.setText(intent.getStringExtra("name"))
        edit.setOnClickListener {
            vm.upodateUser(name.text.toString(), intent.getIntExtra("id", 0))
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}