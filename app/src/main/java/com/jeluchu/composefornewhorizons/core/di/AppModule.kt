package com.jeluchu.composefornewhorizons.core.di

import androidx.multidex.BuildConfig
import com.jeluchu.composefornewhorizons.ComposeForNewHorizons
import com.jeluchu.composefornewhorizons.core.network.Environments
import com.jeluchu.composefornewhorizons.features.bugdetails.repository.BugDetailRepository
import com.jeluchu.composefornewhorizons.features.bugs.repository.BugsRepository
import com.jeluchu.composefornewhorizons.features.villagers.repository.VillagersRepository
import com.jeluchu.jchucomponents.utils.network.RetrofitClient
import com.jeluchu.jchucomponents.utils.network.interceptors.Interceptor
import com.jeluchu.jchucomponents.utils.network.interceptors.InterceptorHeaders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitClient.buildRetrofit(
        Environments.acnhApi,
        GsonConverterFactory.create(),
        ComposeForNewHorizons.getContext(),
        Interceptor(
            InterceptorHeaders(
                userAgent = InterceptorHeaders.UserAgent(
                    appName = "ComposeForNewHorizons",
                    versionName = BuildConfig.VERSION_NAME,
                    versionCode = BuildConfig.VERSION_CODE
                ),
                client = "ComposeForNewHorizons"
            )
        ),
        BuildConfig.DEBUG
    )

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): RetrofitClient = RetrofitClient

    @Provides
    fun provideBugsRepository(
        dataSource: BugsRepository.BugsRepositoryImpl
    ): BugsRepository = dataSource

    @Provides
    fun provideBugDetailsRepository(
        dataSource: BugDetailRepository.BugDetailRepositoryImpl
    ): BugDetailRepository = dataSource

    @Provides
    fun provideVillagersDetailsRepository(
        dataSource: VillagersRepository.VillagersRepositoryImpl
    ): VillagersRepository = dataSource

}