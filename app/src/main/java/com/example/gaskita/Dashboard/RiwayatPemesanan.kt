package com.example.gaskita.Dashboard

data class RiwayatPemesanan(
    val  idPemesanan: String,
    val tanggalPemesanan: String,
    val statusPemesanan: String,
    val namaPemesanan: String,
    val hargaPemesanan: Int
)