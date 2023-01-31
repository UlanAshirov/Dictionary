package com.uli.main.presentation.ui.fragments.addword

import com.uli.core.base.BaseViewModel
import com.uli.domain.usecase.AddNewWordUseCase
import com.uli.main.presentation.model.WordsUI
import com.uli.main.presentation.model.toDomain
import com.uli.main.presentation.model.toUI
import kotlinx.coroutines.flow.asStateFlow

class AddWordViewModel(
    private val addNewWordUseCase: AddNewWordUseCase
) : BaseViewModel() {

    private val _state = mutableUiStateFlow<WordsUI>()
    val state = _state.asStateFlow()

    fun addNewWord(model: WordsUI) =
        addNewWordUseCase(model.toDomain()).gatherRequest(_state) { it.toUI() }
}