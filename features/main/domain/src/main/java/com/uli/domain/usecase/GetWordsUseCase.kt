package com.uli.domain.usecase

import androidx.paging.PagingData
import com.uli.domain.model.WordsModel
import com.uli.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow

class GetWordsUseCase(private val repository: WordsRepository) {

    operator fun invoke(): Flow<PagingData<WordsModel>> =
        repository.getWords()
}
