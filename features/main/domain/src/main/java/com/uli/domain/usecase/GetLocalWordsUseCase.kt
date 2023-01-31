package com.uli.domain.usecase

import com.uli.domain.model.WordsModel
import com.uli.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow

class GetLocalWordsUseCase(private val repository: WordsRepository) {
    operator fun invoke(): Flow<List<WordsModel>> = repository.getLocalWords()
}