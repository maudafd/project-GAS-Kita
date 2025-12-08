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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PaymentCashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaymentCashFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_cash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        class RincianPesananFragment : Fragment() {

            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                val view = inflater.inflate(R.layout.fragment_payment_cash, container, false)

                val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewCash)

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PaymentCashFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PaymentCashFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}