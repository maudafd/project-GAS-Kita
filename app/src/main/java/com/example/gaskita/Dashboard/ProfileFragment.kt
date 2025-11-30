package com.example.gaskita.Dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.gaskita.Login.LoginActivity
import com.example.gaskita.R

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonHelp = view.findViewById<Button>(R.id.buttonHelp)
        buttonHelp.setOnClickListener {
            val phoneNumber = "62895367321131"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            startActivity(intent)
        }

        val buttonLogout = view.findViewById<Button>(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            // Membersihkan back stack agar pengguna tidak bisa kembali ke halaman profil setelah logout
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
