package com.jeluchu.composefornewhorizons.features.bugdetails.repository

import com.jeluchu.composefornewhorizons.core.network.NetworkHandler
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.jchucomponents.core.exception.Failure
import com.jeluchu.jchucomponents.utils.network.models.Resource
import com.jeluchu.jchucomponents.utils.network.networkResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface BugDetailRepository {

    fun getBug(id: String): Flow<Resource<Failure, BugsItem>>

    class BugDetailRepositoryImpl @Inject constructor(
        private val api: BugDetailService,
        private val networkHandler: NetworkHandler
    ) : BugDetailRepository {

        override fun getBug(id: String) =
            networkResource(
                fetch = { api.getBug(id).toBugsItem() },
                shouldFetch = { networkHandler.isNetworkAvailable() }
            )

    }

}