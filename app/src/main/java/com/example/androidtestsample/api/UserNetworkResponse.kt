package com.example.androidtestsample.api

import kotlinx.serialization.Serializable


@Serializable
data class UserNetworkResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
