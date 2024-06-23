package com.example.androidtestsample.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopp_table")
data class ShoppEntity(
    val name: String,
    val amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)