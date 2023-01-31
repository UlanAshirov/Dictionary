package com.uli.data.remote.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.uli.data.utils.DataMapper
import com.uli.domain.model.WordsModel

@Entity
data class WordsDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("is_new")
    val isNewWord: Boolean,
    @SerializedName("title")
    val title: String
) : DataMapper<WordsModel> {

    override fun toDomain() = WordsModel(
        description = description,
        id = id,
        isNewWord = isNewWord,
        title = title
    )
}

fun WordsModel.toData() = WordsDto(
    description = description,
    id = id,
    isNewWord = isNewWord,
    title = title
)