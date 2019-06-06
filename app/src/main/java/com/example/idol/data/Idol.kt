package com.example.idol.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "idols")
data class Idol (
    @ColumnInfo(name="nombre") var nombre:String,
    @ColumnInfo(name="compañia") var compañia:String,
    @ColumnInfo(name="estatura") var estatura:String
) {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int=0
}