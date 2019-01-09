package com.test.roomsample.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.test.roomsample.database.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDetails(): UserDao

    companion object {

        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "User-database")
                        .allowMainThreadQueries()
                        .build()
            }
            return appDatabase as AppDatabase
        }

        fun destroyInstance() {
            appDatabase = null
        }
    }
}