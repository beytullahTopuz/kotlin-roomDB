package com.t4zb.roomdbtest.services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.t4zb.roomdbtest.model.PasswordModel

@Database(entities = arrayOf(PasswordModel::class), version = 1)
abstract class PasswordDatabase : RoomDatabase() {

    //singleton
    abstract fun PasswordDao(): PasswordDao

    companion object {
        @Volatile
        private var instance: PasswordDatabase? = null

        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PasswordDatabase::class.java,
            "passworddatabase"
        ).build()
    }
}