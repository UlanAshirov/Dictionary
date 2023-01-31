package com.uli.data.remote.source

import com.uli.data.base.BasePagingSource
import com.uli.data.remote.apiservice.WordsApiService
import com.uli.data.remote.dtos.WordsDto
import com.uli.domain.model.WordsModel

class WordsPagingSource(
    private val wordsApiService: WordsApiService
) : BasePagingSource<WordsDto, WordsModel>({
    wordsApiService.getWords(it)
})