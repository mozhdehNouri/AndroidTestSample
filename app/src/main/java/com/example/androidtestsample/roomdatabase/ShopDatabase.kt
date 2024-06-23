package com.example.androidtestsample.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ShoppEntity::class], version = 1)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun shoppDao(): ShoppDao
}