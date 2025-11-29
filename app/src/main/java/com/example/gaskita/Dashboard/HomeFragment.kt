package com.example.gaskita.Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gaskita.Login.LoginActivity
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

        return view
    }
}
