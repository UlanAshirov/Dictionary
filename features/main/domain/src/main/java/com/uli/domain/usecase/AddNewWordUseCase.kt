package com.uli.domain.usecase

import com.uli.domain.model.WordsModel
import com.uli.domain.repository.WordsRepository

class AddNewWordUseCase(private val repository: WordsRepository) {
    operator fun invoke(model: WordsModel) = repository.addNewWord(model)
}