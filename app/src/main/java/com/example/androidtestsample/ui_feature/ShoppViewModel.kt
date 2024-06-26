package com.example.androidtestsample.ui_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtestsample.api.ShoppRepository
import com.example.androidtestsample.api.UserNetworkResponse
import com.example.androidtestsample.roomdatabase.ShoppEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppViewModel @Inject constructor(
    private val repository: ShoppRepository
) : ViewModel() {

    val shoppItems = repository.observeAllShoppItem()
    val totalPrice = repository.observeTotalPrice()


    fun addShoppItemIntoDB(shoppItem: ShoppEntity) =
        viewModelScope.launch {
            repository.addShoppItem(shoppItem)
        }


    fun addShoppItem(
        name: String,
        amount: Int,
        price: Float,
        imageUrl: String
    ): Boolean {
        return when {
            name.isBlank() || amount < 0 || price < 0f -> false
            else -> true
        }


    }

    fun searchForUser(query: String): List<UserNetworkResponse>? {
        return if (query.isBlank()) emptyList()
        else repository.searchShoppItem()
    }
}