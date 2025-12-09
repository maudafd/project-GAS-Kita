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
import com.example.gaskita.Dashboard.ProdukGas
import com.example.gaskita.KeranjangAdapter
import com.example.gaskita.R


class KeranjangFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_keranjang, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.daftarKeranjang)

        // 3. Siapkan data dummy
        val dataKeranjang = listOf(
            KeranjangModel("Gas Elpiji 3kg", "Rp 20.000", R.drawable.lpg3kg),
            KeranjangModel("Gas Elpiji 6kg", "Rp 65.000", R.drawable.lpg6kg)
        )

        // 4. Pasang Adapter ke RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = KeranjangAdapter(dataKeranjang)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonGoToCheckout = view.findViewById<Button>(R.id.buttonGoToCheckout)
        buttonGoToCheckout.setOnClickListener {
            findNavController().navigate(R.id.action_keranjangFragment_to_checkoutFragment)
        }
    }
}