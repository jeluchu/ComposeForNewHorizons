package com.jeluchu.composefornewhorizons.features.villagers.repository

import com.jeluchu.composefornewhorizons.core.network.NetworkHandler
import com.jeluchu.composefornewhorizons.features.villagers.models.VillagerItem
import com.jeluchu.jchucomponentscompose.core.exception.Failure
import com.jeluchu.jchucomponentscompose.utils.network.models.Resource
import com.jeluchu.jchucomponentscompose.utils.network.networkResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface VillagersRepository {

    fun getVillagers(): Flow<Resource<Failure, List<VillagerItem>>>

    class VillagersRepositoryImpl @Inject constructor(
        private val api: VillagersService,
        private val networkHandler: NetworkHandler
    ) : VillagersRepository {

        override fun getVillagers() =
            networkResource(
                fetch = { api.getVillagers().map { it.toVillagerItem() } },
                shouldFetch = { networkHandler.isNetworkAvailable() }
            )

    }

}