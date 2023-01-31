package com.uli.main.presentation.ui.fragments.main.word.detail

import com.uli.core.base.BaseViewModel
import com.uli.domain.model.WordsModel
import com.uli.domain.usecase.AddWordLocalDBUseCase
import com.uli.domain.usecase.GetDetailLocalWordUseCase
import com.uli.domain.usecase.GetDetailWordUseCase
import com.uli.main.presentation.model.WordsUI
import com.uli.main.presentation.model.toUI
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(
    private val getDetailWordUseCase: GetDetailWordUseCase,
    private val addWordLocalDBUseCase: AddWordLocalDBUseCase,
    private val getDetailLocalWordUseCase: GetDetailLocalWordUseCase

) : BaseViewModel() {
    private val _state = mutableUiStateFlow<WordsUI>()
    val state = _state.asStateFlow()

    private val _localDetailState = mutableUiStateFlow<WordsUI?>()
    val localSingleWordDetail = _localDetailState.asStateFlow()

    fun getWords(id: Int) =
        getDetailWordUseCase.invoke(id).gatherRequest(_state) { it.toUI() }

    fun addWordToLocalDb(model: WordsModel) {
        addWordLocalDBUseCase.invoke(model)
    }

    fun getLocalWordDetail(id: Int) =
        getDetailLocalWordUseCase.invoke(id)
}
