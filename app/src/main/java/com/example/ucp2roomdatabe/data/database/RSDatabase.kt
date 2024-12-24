package com.example.ucp2roomdatabe.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2roomdatabe.data.dao.DokterDao
import com.example.ucp2roomdatabe.data.dao.JadwalDao
import com.example.ucp2roomdatabe.data.entity.Dokter


@Database(entities = [Dokter::class], version = 1, exportSchema = false)
abstract class RSDatabase : RoomDatabase() {
    abstract fun dokterDao(): DokterDao
    abstract fun jadwalDao(): JadwalDao

    companion object{
        @Volatile
        private var Instance:RSDatabase? = null

        fun getDatabase(context: Context): RSDatabase {
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    RSDatabase::class.java,
                    "RSDatabase"
                )
                    .build().also { Instance = it }
            })
        }
    }
}