package com.jeluchu.composefornewhorizons.features.bugdetails.repository

import com.jeluchu.composefornewhorizons.features.bugs.models.BugsEntity
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItemEntity
import retrofit2.http.GET
import retrofit2.http.Path

internal interface BugDetailApi {

    @GET("bugs/{id}")
    suspend fun getBug(@Path("id") id: String): BugsItemEntity

}