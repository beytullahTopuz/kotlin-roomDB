package com.t4zb.roomdbtest.services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.t4zb.roomdbtest.model.CountryModel

@Database(entities = arrayOf(CountryModel::class), version = 1)
abstract class CountryDatabase: RoomDatabase() {

    abstract fun CountryDao(): CountryDao

    //singleton
    companion object {
        @Volatile
        private var instane: CountryDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instane ?: synchronized(lock) {
            instane ?: makeDatabase(context).also {
                instane = it
            }
        }

        private fun makeDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CountryDatabase::class.java,
                "countrydatabase"
            ).build()
    }


}