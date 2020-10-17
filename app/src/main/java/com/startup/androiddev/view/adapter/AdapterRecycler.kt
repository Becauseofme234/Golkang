package com.startup.androiddev.view.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.startup.androiddev.view.AddActivity
import com.startup.androiddev.view.EditActivity
import com.startup.androiddev.R
import com.startup.androiddev.data.entity.UserName
import kotlinx.android.synthetic.main.item_data.view.*
import java.util.*

class AdapterRecycler(val data: List<UserName>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    lateinit var deletedata: deletedata

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datax = data[position]

        holder.nama.text = "${datax.name}"
        holder.abjad.text = datax.name[0].toString()
        holder.abjad.setBackgroundColor(getRandomColor())
        holder.bg.setBackgroundColor(getRandomColor())

        holder.itemView.tambah.setOnClickListener {
            context.startActivity(Intent(context, AddActivity::class.java))
        }

        holder.itemView.delete.setOnClickListener {
            deletedata.delete(datax)
        }

        holder.itemView.edit.setOnClickListener {
            val intent = Intent(context, EditActivity::class.java)
            intent.putExtra("name", datax.name)
            intent.putExtra("id", datax.id)
            context.startActivity(intent)

        }

    }

    fun delete(deletedata: deletedata) {
        this.deletedata = deletedata
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nama: TextView = itemView.findViewById(R.id.name)
    val abjad: TextView = itemView.findViewById(R.id.pertama)
    val bg: LinearLayout = itemView.findViewById(R.id.bg)

}

fun getRandomColor(): Int {
    val rnd = Random()
    return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
}


interface deletedata {
    fun delete(n: UserName)
}