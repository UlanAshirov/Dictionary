package com.uli.data.remote.apiservice

import com.uli.data.base.BaseMainResponse
import com.uli.data.remote.dtos.WordsDto
import retrofit2.http.*

interface WordsApiService {

    @GET("words/")
    suspend fun getWords(
        @Query("offset") offset: Int
    ): BaseMainResponse<WordsDto>

    @GET("words/{id}")
    suspend fun getWordDetail(@Path("id") id: Int): WordsDto

    @POST("words/")
    suspend fun addNewWord(
        @Body model: WordsDto
        ): WordsDto
}