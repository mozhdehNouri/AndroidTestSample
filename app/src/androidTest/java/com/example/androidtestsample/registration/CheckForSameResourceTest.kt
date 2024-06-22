package com.example.androidtestsample.registration

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.androidtestsample.R
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


class CheckForSameResourceTest {

    private lateinit var resourceChecker: CheckForSameResource
    private lateinit var context: Context

    @Before
    fun setup() {
        resourceChecker = CheckForSameResource()
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checkResourceIfSame_ReturnTrue() {
        val result = resourceChecker.checkSameResource(
            context,
            R.string.app_name,
            "AndroidTestSAmple"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun checkResourceIfNotSame_ReturnFalse() {
        val result = resourceChecker.checkSameResource(
            context,
            R.string.app_name,
            "SomeName"
        )
        assertThat(result).isFalse()
    }

}