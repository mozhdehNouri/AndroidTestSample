package com.example.androidtestsample.api

import com.example.androidtestsample.roomdatabase.ShoppDao
import com.example.androidtestsample.roomdatabase.ShoppEntity
import com.example.androidtestsample.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShoppRepositoryImpl @Inject constructor(
    private val dao: ShoppDao,
    private val api: ShoppApi
) : ShoppRepository {
    override suspend fun addShoppItem(item: ShoppEntity) {
        dao.addShoppItem(item)
    }

    override suspend fun deleteShoppItem(item: ShoppEntity) {
        dao.deleteShoppItem(item)
    }

    override fun observeAllShoppItem(): Flow<List<ShoppEntity>> =
        dao.getAllShopItem()


    override fun observeTotalPrice(): Flow<Float> =
        dao.observeTotalPrice()

    override suspend fun getShoppFromNetwork(id: Int): Resource<List<UserNetworkResponse>> {
        return try {
            val response = api.getUser()
            if (response.isSuccessful) {
                Resource.success(response.body())
            } else {
                Resource.error(response.message(), null)
            }
        } catch (e: Exception) {
            Resource.error(
                msg = "Error check your internet connection",
                null
            )
        }

    }


}

interface ShoppRepository {

    suspend fun addShoppItem(item: ShoppEntity)
    suspend fun deleteShoppItem(item: ShoppEntity)
    fun observeAllShoppItem(): Flow<List<ShoppEntity>>
    fun observeTotalPrice(): Flow<Float>
    suspend fun getShoppFromNetwork(id: Int): Resource<List<UserNetworkResponse>>
}