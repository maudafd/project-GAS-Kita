package com.example.gaskita.Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.R

class RiwayatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_riwayat, container, false)

        val spinnerFilter = view.findViewById<Spinner>(R.id.spinnerFilter)
        val recyclerView = view.findViewById<RecyclerView>(R.id.RiwayatPemesanan)

        val items = listOf(
            "Minggu ini",
            "Bulan ini",
            "3 Bulan"
        )

        val listRiwayat = listOf(
            RiwayatPemesanan("#P001234", "23 November 2023", "Dalam Perjalanan", "GAS Elpiji 3kg", 21000),
            RiwayatPemesanan("#P003444", "23 Oktober 2023", "Selesai", "GAS Elpiji 12kg", 230000),
            RiwayatPemesanan("#P001224", "23 September 2023", "Selesai", "GAS Elpiji 3kg", 21000),
            RiwayatPemesanan("#P001876", "23 Agustus 2023", "Selesai", "GAS Elpiji 12kg", 230000),
            RiwayatPemesanan("#P001921", "12 Agustus 2023", "Selesai", "GAS Elpiji 3kg", 21000),
            RiwayatPemesanan("#P001543", "28 Juli 2023", "Selesai", "GAS Elpiji 3kg", 21000),
            RiwayatPemesanan("#P002001", "05 Juli 2023", "Selesai", "GAS Elpiji 12kg", 230000),
            RiwayatPemesanan("#P002143", "20 Juni 2023", "Selesai", "GAS Elpiji 3kg", 21000),
            RiwayatPemesanan("#P002344", "03 Juni 2023", "Selesai", "GAS Elpiji 12kg", 230000),
            RiwayatPemesanan("#P002555", "14 Mei 2023", "Selesai", "GAS Elpiji 3kg", 21000)
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RiwayatAdapter(listRiwayat)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            items
        )
        spinnerFilter.adapter = adapter
        spinnerFilter.setSelection(items.indexOf("Bulan ini"))

        return view
    }
}
