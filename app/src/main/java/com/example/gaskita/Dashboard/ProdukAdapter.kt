package com.example.gaskita.Dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Dashboard.ProdukGas
import com.example.gaskita.R

class ProdukAdapter(private val produkList: List<ProdukGas>) :
    RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>(){
    class ProdukViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgProduk: ImageView = itemView.findViewById(R.id.imgProduk)
        val txtNamaProduk: TextView = itemView.findViewById(R.id.txtNamaProduk)
        val txtHargaProduk: TextView = itemView.findViewById(R.id.txtHargaProduk)
        val txtStokProduk: TextView = itemView.findViewById(R.id.txtStokProduk)
        val buttonDetail: Button = itemView.findViewById(R.id.buttonDetail)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ProdukViewHolder(View)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val produk = produkList[position]

        holder.imgProduk.setImageResource(produk.gambar)
        holder.txtNamaProduk.text = produk.nama
        holder.txtHargaProduk.text = produk.harga.toString()
        holder.txtStokProduk.text = produk.stok
        holder.buttonDetail.setOnClickListener {
            // Tambahkan logika untuk membuka halaman detail produk di sini
        }
    }

    override fun getItemCount(): Int {
        return produkList.size
    }
}