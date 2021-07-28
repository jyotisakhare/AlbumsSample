package com.jyoti.albumssample

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jyoti.albumssample.data.Album
import com.jyoti.albumssample.data.AlbumDao
import com.jyoti.albumssample.data.AppDatabase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AlbumEntityReadWriteTest {
    private lateinit var albumDao: AlbumDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
                context, AppDatabase::class.java).build()
        albumDao = db.albumDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val albumList =  ArrayList<Album>()
        albumList.add(Album(1,1,"test title"))
        albumList.add(Album(1,2,"test title2"))

        albumDao.insertAll(albumList)
        val album = albumDao.getAlbumsByItemId(1)
        assertThat(album, equalTo(albumList.get(0)))
    }
}