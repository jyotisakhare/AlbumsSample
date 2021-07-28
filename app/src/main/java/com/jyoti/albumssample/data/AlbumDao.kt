package com.jyoti.albumssample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {
    @Query("SELECT * FROM album ORDER BY title")
    suspend fun getAlbums(): List<Album>

    @Query("SELECT * FROM album WHERE id = :id")
    fun getAlbumsByItemId(id:Int): Album

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<Album>)
}