package com.example.androidtestsample.api

import com.example.androidtestsample.roomdatabase.ShoppEntity
import com.example.androidtestsample.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update


class FakeShoppRepository : ShoppRepository {

    private var shoppItem = mutableListOf<ShoppEntity>()
    private var allShoppItem = MutableStateFlow(shoppItem)
    private var allPrice = MutableStateFlow<Float>(0f)
    private val isNetworkError = false

    private fun refreshData() {
        allShoppItem.update { shoppItem }
    }


    override suspend fun addShoppItem(item: ShoppEntity) {
        shoppItem.add(item)
        refreshData()
    }

    override suspend fun deleteShoppItem(item: ShoppEntity) {
        shoppItem.remove(item)
        refreshData()
    }

    override fun observeAllShoppItem(): Flow<List<ShoppEntity>> {
        return allShoppItem
    }

    override fun observeTotalPrice(): Flow<Float> {
        return allPrice
    }

    override suspend fun getShoppFromNetwork(id: Int): Resource<List<UserNetworkResponse>> {
        return if (isNetworkError) {
            Resource.error("Network error", null)
        } else {
            Resource.success(listOf())
        }


    }
}