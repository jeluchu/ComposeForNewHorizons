package com.jeluchu.composefornewhorizons.features.bugdetails.repository

import com.jeluchu.composefornewhorizons.features.bugs.models.BugsEntity
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItemEntity
import retrofit2.Retrofit
import javax.inject.Inject

class BugDetailService @Inject constructor(
    retrofit: Retrofit
) : BugDetailApi {

    private val serviceApi by lazy { retrofit.create(BugDetailApi::class.java) }

    override suspend fun getBug(id: String): BugsItemEntity = serviceApi.getBug(id)

}