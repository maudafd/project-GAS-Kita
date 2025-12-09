package com.example.gaskita.Order

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.Dashboard.HomeActivity
import com.example.gaskita.KeranjangAdapter
import com.example.gaskita.R

class PaymentCashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_cash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPesananSelesai = view.findViewById<View>(R.id.btnPesananSelesai)
        btnPesananSelesai.setOnClickListener {
            //niat pulang
            val intent = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(intent)
            //hapus history
            requireActivity().finish()
        }
    }
}