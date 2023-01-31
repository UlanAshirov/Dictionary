package com.uli.domain.usecase

import com.uli.domain.repository.WordsRepository

class GetDetailWordUseCase(private val repository: WordsRepository) {
    operator fun invoke(id: Int) = repository.getWordDetail(id)
}