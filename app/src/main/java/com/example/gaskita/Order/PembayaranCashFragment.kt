package com.example.gaskita.Order

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Dashboard.HomeActivity
import com.example.gaskita.Dashboard.RiwayatAdapter
import com.example.gaskita.Dashboard.RiwayatPemesanan
import com.example.gaskita.KeranjangAdapter
import com.example.gaskita.R

class PembayaranCashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pembayaran_cash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        class RincianPesananFragment : Fragment() {

            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                val view = inflater.inflate(R.layout.fragment_pembayaran_cash, container, false)

                val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewRincianCash)

                // Data dari keranjang adapter
                val listKeranjang = listOf(
                    KeranjangModel("Gas 3kg", "Rp 21.000", R.drawable.lpg3kg),
                    KeranjangModel("Gas 12kg", "Rp 230.000", R.drawable.lpg6kg)
                )


                recycler.layoutManager = LinearLayoutManager(requireContext())
                recycler.adapter = KeranjangAdapter(listKeranjang) //menggunakan adapter yang sama
                return view
            }
        }


            val btnPesananSelesai = view.findViewById<View>(R.id.btnPesananSelesai)
        btnPesananSelesai.setOnClickListener {
            val intent = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}
