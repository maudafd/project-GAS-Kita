package com.example.gaskita.Dashboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Order.orderActivity
import com.example.gaskita.R
import kotlin.jvm.java

class ProdukAdapter(
    private val produkList: List<ProdukGas>
) : RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() {
    //kenalan
    class ProdukViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduk: ImageView = itemView.findViewById(R.id.imgProduk)
        val txtNamaProduk: TextView = itemView.findViewById(R.id.txtNamaProduk)
        val txtHargaProduk: TextView = itemView.findViewById(R.id.txtHargaProduk)
        val txtStokProduk: TextView = itemView.findViewById(R.id.txtStokProduk)

        // HANYA tombol BUY NOW yang dipakai
        val btnBeliSekarang: Button = itemView.findViewById(R.id.btnBeliSekarang)
    }

    //menghidupkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produk, parent, false)
        return ProdukViewHolder(view)
    }
    //ambil data
    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val produk = produkList[position]
        //tempelkan
        holder.imgProduk.setImageResource(produk.gambar)
        holder.txtNamaProduk.text = produk.nama
        holder.txtHargaProduk.text = "Rp ${produk.harga}"
        holder.txtStokProduk.text = produk.stok

        holder.btnBeliSekarang.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, orderActivity::class.java)

            // Kirim data ke orderActivity
            intent.putExtra("produkNama", produk.nama)
            intent.putExtra("produkHarga", produk.harga)
            intent.putExtra("produkStok", produk.stok)
            intent.putExtra("produkGambar", produk.gambar)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return produkList.size
    }
}
