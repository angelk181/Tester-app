package com.example.studentbeanstest.api

import com.example.studentbeanstest.data.ImageResults
import retrofit2.Response
import retrofit2.http.GET

/**
 * for http GET request which grabs the images
 */
interface ImageApi {

    @GET("/photos")
    suspend fun getImages(
    ): Response<List<ImageResults>>
}