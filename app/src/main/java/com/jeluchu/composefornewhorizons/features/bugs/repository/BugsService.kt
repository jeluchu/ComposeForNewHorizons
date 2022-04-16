package com.jeluchu.composefornewhorizons.features.bugs.repository

import com.jeluchu.inook.features.art.models.art.ArtsEntity
import com.jeluchu.inook.features.art.models.artdetails.ArtDetailEntity
import retrofit2.Retrofit
import javax.inject.Inject

class BugsService @Inject constructor(
    retrofit: Retrofit
) : ArtsApi {

    private val serviceApi by lazy { retrofit.create(ArtsApi::class.java) }

    override suspend fun getArts(): ArtsEntity = serviceApi.getArts()
    override suspend fun getArtDetails(id: String): ArtDetailEntity = serviceApi.getArtDetails(id)

}