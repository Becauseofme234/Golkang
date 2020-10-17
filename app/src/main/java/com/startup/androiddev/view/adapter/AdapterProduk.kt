package com.startup.androiddev.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.startup.androiddev.view.AddProduk
import com.startup.androiddev.view.EditProduk
import com.startup.androiddev.R
import com.startup.androiddev.data.entity.Product
import kotlinx.android.synthetic.main.item_product.view.*

class AdapterProduk(val data: List<Product>, val context: Context) :
    RecyclerView.Adapter<ViewHolders>() {

    lateinit var deletedataproduk: deleteProduk

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent,
                false
            )
        return ViewHolders(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        val datax = data[position]

        holder.namaproduk.text = datax.produk
        holder.price.text = "Harga : ${datax.harga.toString()}"

        holder.itemView.delete.setOnClickListener {
            deletedataproduk.deleteproduk(datax)
        }

        holder.itemView.tambah.setOnClickListener {
            context.startActivity(Intent(context, AddProduk::class.java))
        }

        holder.itemView.edit.setOnClickListener {
            val intent = Intent(context, EditProduk::class.java)
            intent.putExtra("name", datax.produk)
            intent.putExtra("id", datax.idProduk)
            intent.putExtra("harga", datax.harga)
            context.startActivity(intent)
        }

    }

    fun deletedatax(deletedata: deleteProduk) {
        this.deletedataproduk = deletedata
    }
}

class ViewHolders(view: View) : RecyclerView.ViewHolder(view) {
    val namaproduk: TextView = itemView.findViewById(R.id.nameproduk)
    val price: TextView = itemView.findViewById(R.id.price)

}

interface deleteProduk {
    fun deleteproduk(produk: Product)
}