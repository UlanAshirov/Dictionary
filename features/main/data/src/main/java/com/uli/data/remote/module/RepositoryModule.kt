package com.uli.data.remote.module

import com.uli.data.repository.WordsRepositoryImpl
import com.uli.domain.repository.WordsRepository
import org.koin.dsl.module

val repoModule = module {
    single<WordsRepository> { WordsRepositoryImpl(get(), get()) }
}