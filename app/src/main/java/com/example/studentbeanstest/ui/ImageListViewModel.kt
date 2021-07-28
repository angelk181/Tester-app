package com.example.studentbeanstest.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentbeanstest.data.ImageResults
import com.example.studentbeanstest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * view model that has buisness logic, converts into mutable data
 */
@HiltViewModel
class ImageListViewModel @Inject constructor(
private val repository: Repository
): ViewModel() {

    val images = MutableLiveData<List<ImageResults>>()



    init {
        getImages()
    }

     private fun getImages() = viewModelScope.launch {
        repository.getImages().let { response ->
            if (response.isSuccessful) {
                images.postValue(response.body())

            } else {

                Log.d("Tag","getImages Error Response: ${response.message()}")

            }
        }
    }
}

