package com.jyoti.albumssample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

@Entity(tableName = "album")
data class Album(
    @field:SerializedName("userId") val userId: Int,
    @PrimaryKey @ColumnInfo(name = "id")
    @field:SerializedName("id") val itemId: Int,
    @field:SerializedName("title") val title: String

)

