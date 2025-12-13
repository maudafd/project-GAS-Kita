package com.example.gaskita.Dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Login.LoginActivity
import com.example.gaskita.R
import com.example.gaskita.Order.OrderActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Ambil intent dari activity
        val email = requireActivity().intent.getStringExtra(LoginActivity.KEY_USERNAME) ?: ""
        val textViewHeader2 = view.findViewById<TextView>(R.id.textViewHeader2)
        textViewHeader2.text = "Hello $email"

        val DaftarProduk: RecyclerView = view.findViewById(R.id.DaftarProduk)
        val DaftarPengumuman: RecyclerView = view.findViewById(R.id.DaftarPengumuman)

        // Data dummy pengumuman
        val dataPengumuman = listOf(
            Pengumuman("!!STOK ELPIGI 3 KG DATANG!!", "Mohon bersabar...", "25 Oktober 2025"),
            Pengumuman("!!JADWAL LIBUR!!", "Pangkalan libur 3 hari...", "10 Maret 2025")
        )

        // Data produk gas
        val dataProduk = listOf(
            ProdukGas("Elpiji 3 Kg", 21000, "Stok: Tersedia", R.drawable.lpg3kg),
            ProdukGas("Elpiji 6 Kg", 60000, "Stok: Habis", R.drawable.lpg6kg),
            ProdukGas("Elpiji 12 Kg", 120000, "Stok: Tersedia", R.drawable.lpg12kg)
        )

        // Pasang adapter Pengumuman
        val pengumumanAdapter = PengumumanAdapter(dataPengumuman)
        DaftarPengumuman.layoutManager = LinearLayoutManager(context)
        DaftarPengumuman.adapter = pengumumanAdapter

        // Tombol ikon keranjang di header
        val imageButtonKeranjang = view.findViewById<ImageButton>(R.id.imageButtonKeranjang)
        imageButtonKeranjang.setOnClickListener {
            val intent = Intent(requireContext(), OrderActivity::class.java)
            startActivity(intent)
        }

        // Pasang adapter produk (sekarang tanpa callback!)
        val produkAdapter = ProdukAdapter(dataProduk)
        DaftarProduk.layoutManager = LinearLayoutManager(context)
        DaftarProduk.adapter = produkAdapter

        return view
    }
}
