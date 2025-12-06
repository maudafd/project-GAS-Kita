package com.example.gaskita.Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Dashboard.Pengumuman
import com.example.gaskita.Login.LoginActivity
import com.example.gaskita.Dashboard.ProdukAdapter
import com.example.gaskita.Dashboard.ProdukGas
import com.example.gaskita.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // ambil intent dari activity
        val email = requireActivity().intent.getStringExtra(LoginActivity.KEY_USERNAME) ?: ""
        // ambil TextView dari layout fragment
        val textViewHeader2 = view.findViewById<TextView>(R.id.textViewHeader2)
        textViewHeader2.text = "Hello $email"

        val DaftarProduk: RecyclerView = view.findViewById(R.id.DaftarProduk)
        val DaftarPengumuman: RecyclerView = view.findViewById(R.id.DaftarPengumuman)

        //data dummy
        val dataPengumuman = listOf(
            Pengumuman("!!STOK ELPIGI 3 KG DATANG!!", "Mohon bersabar...", "25 Oktober 2025"),
            Pengumuman("!!JADWAL LIBUR!!", "Pangkalan libur 3 hari...", "10 Maret 2025")
        )

        val dataProduk = listOf(
            ProdukGas(
                "Elpiji 3 Kg",
                21000,
                "Stok: Tersedia",
                R.drawable.lpg3kg
            ), // ganti ic_gas sesuai gambar kamu
            ProdukGas("Elpiji 6 Kg", 60000, "Stok: Habis", R.drawable.lpg6kg),
            ProdukGas("Elpiji 12 Kg", 120000, "Stok: Tersedia", R.drawable.lpg12kg)
        )
        //Pasang Adapter Pengumuman
        val pengumumanAdapter = PengumumanAdapter(dataPengumuman)
        DaftarPengumuman.layoutManager = LinearLayoutManager(context)
        DaftarPengumuman.adapter = pengumumanAdapter

        // 4. Pasang Adapter Produk dgn aksi navigasi
        val produkAdapter = ProdukAdapter(dataProduk,
            // 1. Nama parameter harus 'onAddToCartClick' (sesuai definisi di adapter)
            // 2. Variabel di dalam lambda adalah 'produk' (mewakili satu item), bukan 'produkList'
            onAddToCartClick = { produk ->
                // Navigasi ke KeranjangFragment
                findNavController().navigate(R.id.action_homeFragment_to_keranjangFragment)
            },
            // 3. Nama variabel di dalam lambda juga diganti menjadi 'produk'
            onBuyNowClick = { produk ->
                // Navigasi ke CheckoutFragment
                findNavController().navigate(R.id.action_homeFragment_to_checkoutFragment)
            }
        )
        DaftarProduk.layoutManager = LinearLayoutManager(context)
        DaftarProduk.adapter = produkAdapter
        return view

    }
}
