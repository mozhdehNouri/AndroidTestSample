package com.example.androidtestsample.registration

import android.content.Context

class CheckForSameResource {

    fun checkSameResource(
        context: Context,
        resourceId: Int,
        text: String
    ): Boolean {
        return context.getString(resourceId) == text
    }

}