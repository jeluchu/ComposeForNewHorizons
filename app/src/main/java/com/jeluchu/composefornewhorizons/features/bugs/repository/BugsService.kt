package com.jeluchu.composefornewhorizons.features.bugs.repository

import com.jeluchu.composefornewhorizons.features.bugs.models.BugsEntity
import retrofit2.Retrofit
import javax.inject.Inject

class BugsService @Inject constructor(
    retrofit: Retrofit
) : BugsApi {

    private val serviceApi by lazy { retrofit.create(BugsApi::class.java) }

    override suspend fun getBugs(): BugsEntity = serviceApi.getBugs()

}