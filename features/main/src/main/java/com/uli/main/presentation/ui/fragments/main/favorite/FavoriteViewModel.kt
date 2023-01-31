package com.uli.main.presentation.ui.fragments.main.favorite

import androidx.lifecycle.viewModelScope
import com.uli.core.base.BaseViewModel
import com.uli.domain.usecase.GetDetailLocalWordUseCase
import com.uli.domain.usecase.GetLocalWordsUseCase
import com.uli.main.presentation.model.WordsUI
import com.uli.main.presentation.model.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getLocalWordsUseCase: GetLocalWordsUseCase,
) : BaseViewModel() {

    private val _localState = MutableStateFlow<List<WordsUI>>(emptyList())
    val localState = _localState.asStateFlow()

    fun getLocalWord() =
        viewModelScope.launch {
            getLocalWordsUseCase().collectLatest {
                _localState.value = it.map { wordsModel -> wordsModel.toUI() }
            }
        }
}