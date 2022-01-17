package com.t4zb.roomdbtest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PasswordModel(
    @ColumnInfo(name = "category")
    val category: String?,
    @ColumnInfo(name = "username")
    val username: String?,
    @ColumnInfo(name = "password")
    val password: String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}
