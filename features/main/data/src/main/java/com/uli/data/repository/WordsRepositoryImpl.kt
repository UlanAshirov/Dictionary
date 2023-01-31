package com.uli.data.repository

import com.uli.data.base.makeNetworkRequest
import com.uli.data.base.makePagingRequest
import com.uli.data.local.WordsDao
import com.uli.data.remote.apiservice.WordsApiService
import com.uli.data.remote.dtos.toData
import com.uli.data.remote.source.WordsPagingSource
import com.uli.domain.model.WordsModel
import com.uli.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WordsRepositoryImpl(
    private val wordsApiService: WordsApiService,
    private val wordDao: WordsDao
) : WordsRepository {

    override fun getWords() = makePagingRequest(
        WordsPagingSource(
            wordsApiService
        )
    )

    override fun getWordDetail(id: Int) = makeNetworkRequest {
        wordsApiService.getWordDetail(id).toDomain()
    }

    override fun getLocalWords() = wordDao.getLocalWords().map { wordsDto ->
        wordsDto.map { it.toDomain() }
    }

    override fun addWordLocalDB(model: WordsModel) {
        return wordDao.addWordLocalDb(model.toData())
    }

    override fun getLocalWordDetail(id: Int): Flow<WordsModel> =
        wordDao.getLocalWordDetail(id).map { it.toDomain() }

    override fun addNewWord(model: WordsModel) = makeNetworkRequest {
        wordsApiService.addNewWord(model.toData()).toDomain()
    }
}