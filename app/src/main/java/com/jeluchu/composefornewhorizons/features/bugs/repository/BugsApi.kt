package com.jeluchu.composefornewhorizons.features.bugs.repository

import com.jeluchu.composefornewhorizons.features.bugs.models.BugsEntity
import retrofit2.http.GET

internal interface BugsApi {

    @GET("bugs")
    suspend fun getBugs(): BugsEntity

}