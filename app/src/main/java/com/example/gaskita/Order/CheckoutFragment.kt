package com.example.gaskita.Order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gaskita.KeranjangAdapter
import com.example.gaskita.R

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.daftarCheckout)

        // Siapkan data dummy (Data Pura-pura)
        val dataBelanjaan = listOf(
            KeranjangModel("Gas Elpiji 3kg", "Rp 20.000", R.drawable.lpg3kg),
            KeranjangModel("Gas Elpiji 6kg", "Rp 65.000", R.drawable.lpg6kg)
        )

        // Pasang Adapter ke RecyclerView
        val adapterSaya = KeranjangAdapter(dataBelanjaan)
        recyclerView.adapter = adapterSaya
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonGoToPayment = view.findViewById<Button>(R.id.buttonGoToPayment)

        buttonGoToPayment.setOnClickListener {
            findNavController().navigate(R.id.action_checkoutFragment_to_paymentCashFragment)
        }
    }


}


