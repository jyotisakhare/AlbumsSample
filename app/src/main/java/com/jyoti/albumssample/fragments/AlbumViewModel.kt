package com.jyoti.albumssample.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jyoti.albumssample.data.Album
import com.jyoti.albumssample.data.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {
    var albums: MutableLiveData<List<Album>> = MutableLiveData<List<Album>>()

    fun loadAlbums() {
        CoroutineScope(Dispatchers.IO).launch {
            val alumbs = repository.getAlbums();
            albums?.postValue(alumbs)
        }
    }
}