package com.uli.domain.usecase

import com.uli.domain.repository.WordsRepository

class GetDetailLocalWordUseCase(private val repository: WordsRepository) {
    operator fun invoke(id: Int) = repository.getLocalWordDetail(id)
}