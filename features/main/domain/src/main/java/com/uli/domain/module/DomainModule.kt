package com.uli.domain.module

import com.uli.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {
    factory { GetWordsUseCase(get()) }
    factory { GetDetailWordUseCase(get()) }
    factory { GetLocalWordsUseCase(get()) }
    factory { AddWordLocalDBUseCase(get()) }
    factory { GetDetailLocalWordUseCase(get()) }
    factory { AddNewWordUseCase(get()) }
}