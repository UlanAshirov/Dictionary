package com.uli.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uli.data.remote.dtos.WordsDto

@Database(entities = [WordsDto::class], version = 1, exportSchema = false)
abstract class WordsDatabase : RoomDatabase() {
    abstract fun wordsDao(): WordsDao
}