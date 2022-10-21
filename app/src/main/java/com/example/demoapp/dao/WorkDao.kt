package com.example.demoapp.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.demoapp.entity.Word

interface WorkDao {

    /**
     * Getting all words ordered alphabetically
     */

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizeWords(): List<Word>

    /**
     * Inserting a word
     */

    @Insert(onConflict = onConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    /**
     * Deleting all words
     */
    
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()







}