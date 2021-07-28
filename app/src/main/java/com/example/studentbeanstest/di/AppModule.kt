package com.example.studentbeanstest.di

import com.example.studentbeanstest.api.Constants
import com.example.studentbeanstest.api.Constants.Base_Url
import com.example.studentbeanstest.api.ImageApi
import com.example.studentbeanstest.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * we declare modules to give a manual on dependances/services
 * we want to provide
 * context needed and dagger knows context
 * singleton makes sure it takes the same instance over again
 **/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * to construct repository we need api to be provided to it
     */

    @Singleton
    @Provides
    fun provideRepository(
        api: ImageApi
    ) = Repository(api)


    /** injection to api service for url
     * String in constructor
     */
    @Provides
    @Singleton
    fun provideRetrofitInstance() : ImageApi =
        Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageApi::class.java)


}