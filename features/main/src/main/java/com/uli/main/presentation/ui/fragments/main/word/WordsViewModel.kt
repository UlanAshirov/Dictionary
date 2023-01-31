package com.uli.main.presentation.ui.fragments.main.word

import com.uli.core.base.BaseViewModel
import com.uli.domain.usecase.GetWordsUseCase
import com.uli.main.presentation.model.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WordsViewModel(
    private val getWordsUseCase: GetWordsUseCase,
) : BaseViewModel() {

    private val _wordsState = MutableStateFlow<String?>(null)
    val wordsState = _wordsState.asStateFlow()

    fun getWords() =
        getWordsUseCase().gatherPagingRequest { it.toUI() }

}