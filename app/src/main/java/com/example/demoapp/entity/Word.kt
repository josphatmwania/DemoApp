package com.example.demoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Creating an association between the class and the database using Kotlin annotations.

 */
@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)



