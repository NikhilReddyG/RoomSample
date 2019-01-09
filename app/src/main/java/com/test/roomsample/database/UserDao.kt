package com.test.roomsample.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.test.roomsample.model.User

@Dao
interface UserDao {

    @get:Query("Select * from UserDataBase")
    val allUserDetails: LiveData<List<User>>

    @Delete
    fun deleteUserDetails(userDetails: User)

    @Insert(onConflict = REPLACE)
    fun insertNewUser(userDetail: User)
}