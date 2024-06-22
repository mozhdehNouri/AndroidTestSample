package com.example.androidtestsample.registration

object RegistrationUtil {

    fun validationRegister(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) return false
        if (password != confirmPassword) return false
        if (password.isEmpty() && confirmPassword.isNotEmpty()) return false
        return true
    }
}