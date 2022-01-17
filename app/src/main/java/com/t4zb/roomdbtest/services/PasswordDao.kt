package com.t4zb.roomdbtest.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.t4zb.roomdbtest.model.PasswordModel

@Dao
interface PasswordDao {

    @Insert
    suspend fun insertAll(vararg passwordModel: PasswordModel):List<Long>

    @Query("select * from PasswordModel")
    suspend fun getAllPasswords():List<PasswordModel>

   @Query("select * from PasswordModel where uuid ==:pw_id")
   suspend fun getPassword(pw_id: Int): PasswordModel
}