package com.example.studentbeanstest.repository

import com.example.studentbeanstest.api.ImageApi
import javax.inject.Inject

/**
 * Here is implementation of api network request
 *
 */


class Repository @Inject constructor(
    private val api: ImageApi
) {
    suspend fun getImages()  = api.getImages()

}