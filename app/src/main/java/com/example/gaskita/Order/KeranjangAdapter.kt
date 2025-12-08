package com.example.gaskita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Order.KeranjangModel

// Adapter ini bertugas mengatur daftar belanjaan kamu
class KeranjangAdapter(private val listData: List<KeranjangModel>) :
    RecyclerView.Adapter<KeranjangAdapter.ViewHolder>() {

    // Bagian ini memegang komponen tampilan (Gambar, Teks Nama, Teks Harga)
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProduk: ImageView = view.findViewById(R.id.imageView1)
        val namaProduk: TextView = view.findViewById(R.id.productNameKeranjang)
        val hargaProduk: TextView = view.findViewById(R.id.productPriceKeranjang)
    }

    // Bagian ini membuat tampilan layout dari item_keranjang.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_keranjang, parent, false)
        return ViewHolder(view)
    }

    // Bagian ini mengisi data (teks/gambar) ke dalam layout yang sudah dibuat tadi
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        holder.namaProduk.text = item.nama
        holder.hargaProduk.text = item.harga
        // Kita pakai gambar dummy android dulu biar tidak error
        holder.imgProduk.setImageResource(item.gambar)
    }

    // Memberitahu ada berapa banyak item yang harus ditampilkan
    override fun getItemCount(): Int {
        return listData.size
    }
}
