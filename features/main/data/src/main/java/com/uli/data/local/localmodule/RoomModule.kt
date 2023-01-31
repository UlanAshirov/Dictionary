package com.uli.data.local.localmodule

import androidx.room.Room
import com.uli.data.local.WordsDao
import com.uli.data.local.WordsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            WordsDatabase::class.java,
            "WORDS_DB"
        ).allowMainThreadQueries()
            .build()
    }
    single<WordsDao> {
        val database = get<WordsDatabase>()
        database.wordsDao()
    }
}