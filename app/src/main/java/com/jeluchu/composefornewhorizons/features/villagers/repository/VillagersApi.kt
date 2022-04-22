package com.jeluchu.composefornewhorizons.features.villagers.repository

import com.jeluchu.composefornewhorizons.features.villagers.models.VillagerEntity
import retrofit2.http.GET

internal interface VillagersApi {

    @GET("villagers")
    suspend fun getVillagers(): VillagerEntity

}