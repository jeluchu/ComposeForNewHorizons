package com.jeluchu.composefornewhorizons.features.bugs.repository

import com.jeluchu.composefornewhorizons.core.network.NetworkHandler
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.jchucomponents.core.exception.Failure
import com.jeluchu.jchucomponents.utils.network.models.Resource
import com.jeluchu.jchucomponents.utils.network.networkResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface BugsRepository {

    fun getBugs(): Flow<Resource<Failure, List<BugsItem>>>

    class BugsRepositoryImpl @Inject constructor(
        private val api: BugsService,
        private val networkHandler: NetworkHandler
    ) : BugsRepository {

        override fun getBugs() =
            networkResource(
                fetch = { api.getBugs().map { it.toBugsItem() } },
                shouldFetch = { networkHandler.isNetworkAvailable() }
            )

    }

}