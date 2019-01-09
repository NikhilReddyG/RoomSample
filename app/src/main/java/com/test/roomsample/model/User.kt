package com.test.roomsample.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "UserDataBase")
class User(@field:ColumnInfo(name = "content")
           var content: String?,
           @field:PrimaryKey(autoGenerate = true)
           var id: Int = 0) {
}