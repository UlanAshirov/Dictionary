package com.uli.domain.usecase

import com.uli.domain.model.WordsModel
import com.uli.domain.repository.WordsRepository

class AddWordLocalDBUseCase(private val repository: WordsRepository) {
    operator fun invoke(model: WordsModel) = repository.addWordLocalDB(model)
}