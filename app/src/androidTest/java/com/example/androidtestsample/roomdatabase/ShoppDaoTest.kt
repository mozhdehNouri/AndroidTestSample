package com.example.androidtestsample.roomdatabase

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppDaoTest {

    private lateinit var shoppRoomDatabase: ShopDatabase
    private lateinit var dao: ShoppDao
    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        shoppRoomDatabase = Room.inMemoryDatabaseBuilder(
            context,
            ShopDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = shoppRoomDatabase.shoppDao()
    }

    @After
    fun end() {
        shoppRoomDatabase.close()
    }

    @Test
    fun insertShoppItemInDataBase() = runTest {
        val shoppItem = ShoppEntity(
            name = "food",
            amount = 2,
            price = 2f,
            imageUrl = "",
            id = 2
        )
        dao.addShoppItem(shoppItem)
        val getAllItem =
            dao.getAllShopItem().first { it.contains(shoppItem) }
        assertThat(getAllItem).isNotEmpty()
    }

}