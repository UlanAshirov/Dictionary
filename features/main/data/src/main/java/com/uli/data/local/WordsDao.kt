package com.uli.data.local

import androidx.room.*
import com.uli.data.remote.dtos.WordsDto
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Query("SELECT * FROM wordsdto")
    fun getLocalWords(): Flow<List<WordsDto>>

    @Query("SELECT * FROM wordsdto WHERE id = :id")
    fun getLocalWordDetail(id: Int): Flow<WordsDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWordLocalDb(model: WordsDto)

    @Delete
    fun deleteWordLocalDb(model: WordsDto)
}