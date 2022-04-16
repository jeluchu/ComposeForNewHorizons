package com.jeluchu.composefornewhorizons.features.bugs.repository

import androidx.room.withTransaction
import com.jeluchu.inook.core.database.db.CacheDatabase
import com.jeluchu.inook.core.platform.NetworkHandler
import com.jeluchu.inook.core.utils.LocalShared
import com.jeluchu.inook.features.art.models.art.Art
import com.jeluchu.inook.features.art.models.art.ArtEntity
import com.jeluchu.inook.features.art.models.artdetails.ArtDetail
import com.jeluchu.inook.features.art.models.artdetails.ArtDetailEntity
import com.jeluchu.jchucomponentscompose.core.exception.Failure
import com.jeluchu.jchucomponentscompose.core.extensions.sharedprefs.SharedPrefsHelpers
import com.jeluchu.jchucomponentscompose.core.extensions.time.isFetchTwentyDays
import com.jeluchu.jchucomponentscompose.utils.network.models.Resource
import com.jeluchu.jchucomponentscompose.utils.network.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface BugsRepository {

    fun getArts(): Flow<Resource<Failure, List<Art>>>
    fun getArtDetails(id: String): Flow<Resource<Failure, ArtDetail>>

    class ArtsRepositoryImpl @Inject constructor(
        private val api: ArtsService,
        private val db: CacheDatabase,
        private val networkHandler: NetworkHandler
    ) : BugsRepository {

        private val preferences by lazy { SharedPrefsHelpers() }
        private val local = db.artsDao()
        private val localDetails = db.artDetailsDao()

        override fun getArts() =
            networkBoundResource(
                query = { local.getArts() },
                fetch = { api.getArts().arts.map { it.toArt() } },
                saveFetchResult = { data ->
                    preferences.saveLong(LocalShared.arts, System.currentTimeMillis())
                    db.withTransaction {
                        local.deleteAll()
                        for (art in data) {
                            local.insertArts(
                                ArtEntity(
                                    buy = art.buy,
                                    filename = art.filename,
                                    image = art.image,
                                    name = art.name,
                                    type = art.type
                                )
                            )
                        }
                    }
                },
                shouldFetch = {
                    local.getArtsForServerQuery().isNullOrEmpty() ||
                            isFetchTwentyDays(preferences.getLong(LocalShared.arts, 0L)) &&
                            networkHandler.isNetworkAvailable()
                },
                dbTransform = { data -> data.map { it.toArt() } }
            )

        override fun getArtDetails(id: String) =
            networkBoundResource(
                query = { localDetails.getArtDetail(id) },
                fetch = { api.getArtDetails(id).toArtDetail() },
                saveFetchResult = { art ->
                    preferences.saveLong(id, System.currentTimeMillis())
                    db.withTransaction {
                        localDetails.deleteByFilename(id)
                        localDetails.insertArtDetail(
                            ArtDetailEntity(
                                description = art.description,
                                filename = art.filename,
                                real = art.real,
                                fake = art.fake,
                                name = art.name,
                                sell = art.sell,
                                buy = art.buy,
                                firstColor = art.firstColor,
                                secondColor = art.secondColor,
                                size = art.size,
                                artist = art.artist,
                                version = art.version,
                                hhaPoints = art.hhaPoints,
                                hhConcept1 = art.hhConcept1,
                                hhConcept2 = art.hhConcept2,
                                hhSeries = art.hhSeries,
                                hhSet = art.hhSet
                            )
                        )
                    }
                },
                shouldFetch = {
                    localDetails.getArtDetailForServerQuery(id) == null ||
                            isFetchTwentyDays(preferences.getLong(id, 0L)) &&
                            networkHandler.isNetworkAvailable()
                },
                dbTransform = { data -> data.toArtDetail() }
            )


    }

}