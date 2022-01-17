package com.t4zb.roomdbtest.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.t4zb.roomdbtest.model.CountryModel

@Dao
interface CountryDao {

    @Insert
    suspend fun insertAll(vararg countries: CountryModel):List<Long>

    @Query("Select * from CountryModel")
    suspend fun getAllCountries():List<CountryModel>

    @Query("Select * from CountryModel where uuid==:pw_id")
    suspend fun getCountry(pw_id: Int): CountryModel


}