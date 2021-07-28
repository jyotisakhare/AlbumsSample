package com.jyoti.albumssample.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import api.APIService
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(private val albumDao: AlbumDao, private val service: APIService) {

    suspend fun getAlbums(): List<Album> {
        var albums: List<Album>
        try {
            albums = service.getAlbums()
            if (albums.isNotEmpty()) {
                albumDao.insertAll(albums)
            }
        } catch (e:Exception) {
            Timber.d("%s %s", e.message , e.javaClass.canonicalName)
            return albumDao.getAlbums();
        }
        return  albums
    }

}