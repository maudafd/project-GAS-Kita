package com.example.gaskita.Dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.R

class RiwayatAdapter(
    // List data riwayat pemesanan yang akan ditampilkan di RecyclerView
    private val list: List<RiwayatPemesanan>
) : RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {

    // Mengambil dan menyimpan semua TextView yang ada di layout item_riwayat
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtIdPemesanan: TextView = itemView.findViewById(R.id.txtIdPemesanan)
        val txtTanggalPemesanan: TextView = itemView.findViewById(R.id.txtTanggalPemesanan)
        val txtStatusPemesanan: TextView = itemView.findViewById(R.id.txtStatusPemesanan)
        val txtNamaPemesanan: TextView = itemView.findViewById(R.id.txtNamaPemesanan)
        val txtHargaPemesanan: TextView = itemView.findViewById(R.id.txtHargaPemesanan)
    }

//    mengubah item_riwayat menjadi ViewHolder dan mengembalikannya
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_riwayat, parent, false)
        return ViewHolder(view)
    }

//menampilkan data berdasarkan posisi list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val riwayat = list[position]

        holder.txtIdPemesanan.text = riwayat.idPemesanan
        holder.txtTanggalPemesanan.text = riwayat.tanggalPemesanan
        holder.txtStatusPemesanan.text = riwayat.statusPemesanan
        holder.txtNamaPemesanan.text = riwayat.namaPemesanan
        holder.txtHargaPemesanan.text = "Rp ${riwayat.hargaPemesanan}"
    }
//mengembalikan jumlah recycler view
    override fun getItemCount(): Int = list.size
}
