package com.uli.domain.repository

import androidx.paging.PagingData
import com.uli.common.either.Either
import com.uli.domain.model.WordsModel
import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    fun getWords(): Flow<PagingData<WordsModel>>
    fun getWordDetail(id: Int): Flow<Either<String, WordsModel>>
    fun getLocalWords(): Flow<List<WordsModel>>
    fun addWordLocalDB(model: WordsModel)
    fun getLocalWordDetail(id: Int): Flow<WordsModel>
    fun addNewWord(model: WordsModel): Flow<Either<String, WordsModel>>
}