package com.t4zb.roomdbtest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryModel(
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "region")
    val region: String?,
    @ColumnInfo(name = "capital")
    val capital: String?,
    @ColumnInfo(name = "currency")
    val currency: String?,
    @ColumnInfo(name = "language")
    val language: String?,
    @ColumnInfo(name = "imgUrl")
    val imgUrl: String
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}