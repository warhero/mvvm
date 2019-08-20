package com.ani.mvvmapp.Persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ani.mvvmapp.Persistance.dao.InfoDao
import com.ani.mvvmapp.Persistance.dao.ResponseDao
import com.ani.mvvmapp.ui.model.ApiResponse.ApiResponse
import com.ani.mvvmapp.ui.model.ApiResponse.PageInfo

@Database(
    entities = [PageInfo::class, ApiResponse::class],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract fun placesDao(): ResponseDao
    abstract fun infoDao(): InfoDao

    companion object {
        @Volatile
        private var INSTANCE: RickAndMortyDatabase? = null

        fun getDatabase(context: Context): RickAndMortyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RickAndMortyDatabase::class.java,
                    "rick_and_morty_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
