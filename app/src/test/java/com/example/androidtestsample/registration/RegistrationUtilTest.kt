package com.example.androidtestsample.registration

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationUtilTest {

    @Test
    fun `empty userName return false`() {
        val result =
            RegistrationUtil.validationRegister("", "123456", "123456")
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtil.validationRegister("lucy", "", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `password dose not match with repeatable version return false`() {
        val result = RegistrationUtil.validationRegister(
            "lucy",
            "123456",
            "654321"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username is not empty same as password and repeatable password`() {
        val result = RegistrationUtil.validationRegister(
            "lucy",
            "123456",
            "123456"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `if password is empty repeatable password couldn't type`() {
        val result =
            RegistrationUtil.validationRegister("lucy", "", "123456")
        assertThat(result).isFalse()
    }

}