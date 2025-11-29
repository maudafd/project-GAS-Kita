package com.example.gaskita.Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.gaskita.R

class RiwayatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_riwayat, container, false)
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitleRiwayat)
        textViewTitle.text = "Riwayat Pemesanan"
        val spinnerFilter = view.findViewById<Spinner>(R.id.spinnerFilter)

        val items = listOf(
            "Minggu ini",
            "Bulan ini",
            "3 Bulan",
            "6 Bulan",
            "1 Tahun"
        )

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