package com.jeluchu.composefornewhorizons.features.villagers.repository

import com.jeluchu.composefornewhorizons.features.villagers.models.VillagerEntity
import retrofit2.Retrofit
import javax.inject.Inject

class VillagersService @Inject constructor(
    retrofit: Retrofit
) : VillagersApi {

    private val serviceApi by lazy { retrofit.create(VillagersApi::class.java) }

    override suspend fun getVillagers(): VillagerEntity = serviceApi.getVillagers()

}