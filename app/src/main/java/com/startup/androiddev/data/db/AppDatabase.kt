package com.startup.androiddev.data.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.startup.androiddev.data.dao.Dao
import com.startup.androiddev.data.entity.Product
import com.startup.androiddev.data.entity.UserName

@Database(entities = [UserName::class, Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun nameDao(): Dao

    companion object {
        @Volatile
        private var database: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (database == null) {
                synchronized(this) {
                    if (database == null) {
                        database = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "name_database"
                        ).fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return database
        }
    }
}