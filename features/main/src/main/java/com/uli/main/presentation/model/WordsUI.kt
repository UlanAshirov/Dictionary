package com.uli.main.presentation.model

import android.os.Parcelable
import com.uli.core.base.BaseDiffModel
import com.uli.domain.model.WordsModel

data class WordsUI(
    val description: String,
    override val id: Int,
    val isNewWord: Boolean,
    val title: String
) : BaseDiffModel<Int>

fun WordsModel.toUI() = WordsUI(
    description = description,
    id = id,
    isNewWord = isNewWord,
    title = title
)

fun WordsUI.toDomain() = WordsModel(
    description = description,
    id = id,
    isNewWord = isNewWord,
    title = title
)
