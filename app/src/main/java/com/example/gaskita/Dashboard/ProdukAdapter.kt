package com.example.gaskita.Dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.R

// --- PERBAIKAN DI SINI ---
// 1. Gabungkan semua parameter ke dalam satu konstruktor.
// 2. Pastikan nama variabel konsisten.
class ProdukAdapter(
    private val produkList: List<ProdukGas>,
    private val onAddToCartClick: (ProdukGas) -> Unit,
    private val onBuyNowClick: (ProdukGas) -> Unit
) : RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() { // Tambahkan () setelah ViewHolder

    // ViewHolder Anda sudah benar, namun saya ganti nama view agar lebih jelas
    class ProdukViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduk: ImageView = itemView.findViewById(R.id.imgProduk)
        val txtNamaProduk: TextView = itemView.findViewById(R.id.txtNamaProduk)
        val txtHargaProduk: TextView = itemView.findViewById(R.id.txtHargaProduk)
        val txtStokProduk: TextView = itemView.findViewById(R.id.txtStokProduk)
        val btnBeliSekarang: Button = itemView.findViewById(R.id.btnBeliSekarang)
        val btnKeranjang: Button = itemView.findViewById(R.id.btnKeranjang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        // Menggunakan nama variabel 'view' (huruf kecil) agar konsisten
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ProdukViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val produk = produkList[position]

        holder.imgProduk.setImageResource(produk.gambar)
        holder.txtNamaProduk.text = produk.nama
        // Mengubah harga (Int) menjadi String dengan format yang lebih baik
        holder.txtHargaProduk.text = "Rp ${produk.harga}"
        holder.txtStokProduk.text = produk.stok

        // 3. Sesuaikan nama fungsi yang dipanggil agar sama dengan yang dideklarasikan di konstruktor.
        holder.btnKeranjang.setOnClickListener {
            onAddToCartClick(produk)
        }
        holder.btnBeliSekarang.setOnClickListener {
            onBuyNowClick(produk)
        }
    }

    override fun getItemCount(): Int {
        return produkList.size
    }
}
