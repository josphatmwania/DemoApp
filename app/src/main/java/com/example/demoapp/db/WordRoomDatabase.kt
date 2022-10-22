package com.example.demoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoapp.dao.WorkDao
import com.example.demoapp.entity.Word


/**
 * // Annotates class to be a Room Database with a table (entity)
 * of the Word class
 */
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)


public abstract class WordRoomDatabase : RoomDatabase() {
    abstract  fun wordDao() : WorkDao

    companion object {
        /**
         * Singleton prevents multiple instances
         * of DB opening at the same time
         */

        @Volatile
        private var INSTANCE : WordRoomDatabase? = null

        fun getDatabase(context:Context) : WordRoomDatabase {
            /**
             * if the instance is not null, then return it
             * if it is, then create the database
             */
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance

                instance
            }
        }

    }

}