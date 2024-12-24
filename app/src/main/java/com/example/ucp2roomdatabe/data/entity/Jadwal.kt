package com.example.ucp2roomdatabe.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jadwal")
data class Jadwal(
    @PrimaryKey
    val id: String,
    val namaDokter: String,
    val namaPasien: String,
    val noHP: String,
    val tanggalKonsultasi: String,
    val status: String,
)