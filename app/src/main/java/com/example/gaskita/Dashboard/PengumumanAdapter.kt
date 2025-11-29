// In file: D:/project_AS/GasKita/app/src/main/java/com/example/gaskita/Dashboard/PengumumanAdapter.kt

package com.example.gaskita.Dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.R

class PengumumanAdapter(private val listPengumuman: List<Pengumuman>) : RecyclerView.Adapter<PengumumanAdapter.PengumumanViewHolder>() {

    // This class holds the views for each item in the list
    class PengumumanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewJudulPengumuman: TextView = itemView.findViewById(R.id.txtJudulPengumuman)
        val textViewIsiPengumuman: TextView = itemView.findViewById(R.id.txtIsiPengumuman)
        val textViewTanggalPengumuman: TextView = itemView.findViewById(R.id.txtTanggalPengumuman)
    }

    // Called when RecyclerView needs a new ViewHolder (a new item layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengumumanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengumuman, parent, false)
        return PengumumanViewHolder(view)
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int {
        return listPengumuman.size
    }

    // Called to display the data at a specific position
    override fun onBindViewHolder(holder: PengumumanViewHolder, position: Int) {
        val pengumuman = listPengumuman[position]
        holder.textViewJudulPengumuman.text = pengumuman.judul
        holder.textViewIsiPengumuman.text = pengumuman.deskripsi
        holder.textViewTanggalPengumuman.text = pengumuman.tanggal
    }
}
