package com.example.demoapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.demoapp.entity.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkDao {

    /**
     * Getting all words ordered alphabetically
     */

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizeWords(): Flow<List<Word>>

    /**
     * Inserting a word
     */
    /**
     * The selected onConflict strategy ignores a new word
     * if it's exactly the same as one already in the list.
     */

//    @Insert(onConflict = onConflictStrategy.IGNORE)
//    suspend fun insert(word: Word)


    /**
     * Deleting all words
     */
    
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
    abstract fun insert(word: Word)


}