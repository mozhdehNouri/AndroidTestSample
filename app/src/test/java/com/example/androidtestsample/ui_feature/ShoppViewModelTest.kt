package com.example.androidtestsample.ui_feature

import com.example.androidtestsample.api.FakeShoppRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ShoppViewModelTest {

    private lateinit var shoppViewModel: ShoppViewModel

    @Before
    fun setup() {
        shoppViewModel = ShoppViewModel(FakeShoppRepository())

    }

    @Test
    fun `all field is empty return false`() {
        val result = shoppViewModel.addShoppItem("", 0, 0f, "")
        assertThat(result).isFalse()
    }

    @Test
    fun `if name just empty return false`() {
        val result = shoppViewModel.addShoppItem("", 5, 0.6f, "")
        assertThat(result).isFalse()
    }

    @Test
    fun `if price is empty return false`() {
        val result = shoppViewModel.addShoppItem("lucy", 6, 0f, "")
        assertThat(result).isFalse()
    }

    @Test
    fun `is amount is empty return false`() {
        val result = shoppViewModel.addShoppItem("lucy", 0, 5.7f, "")
        assertThat(result).isFalse()
    }

    @Test
    fun `if name more than 18 char`() {
        val stringName = buildString {
            (1..18).forEach {
                append(it)
            }
        }
        val result = shoppViewModel.addShoppItem(stringName, 8, 20.8f, "")
        assertThat((result)).isTrue()
    }

    @Test
    fun `all item is fill anf return true`() {
        val result = shoppViewModel.addShoppItem("lucy", 8, 20.8f, "")
        assertThat(result).isTrue()
    }


    @Test
    fun `is query param is empty return empty list`() = runTest {
        val item = shoppViewModel.searchForUser("")
        val allItem = shoppViewModel.shoppItems.first()
        assertThat(item).contains(allItem)
    }
}