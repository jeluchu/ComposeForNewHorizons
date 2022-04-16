package com.jeluchu.composefornewhorizons.features.bugs.repository

import com.jeluchu.composefornewhorizons.features.bugs.models.BugsEntity
import com.jeluchu.inook.features.art.models.art.ArtsEntity
import com.jeluchu.inook.features.art.models.artdetails.ArtDetailEntity
import retrofit2.http.GET
import retrofit2.http.Path

internal interface BugsApi {

    @GET("arts.json")
    suspend fun getArts(): BugsEntity


}