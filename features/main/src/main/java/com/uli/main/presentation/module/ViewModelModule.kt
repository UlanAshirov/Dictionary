package com.uli.main.presentation.module

import com.uli.main.presentation.ui.fragments.addword.AddWordViewModel
import com.uli.main.presentation.ui.fragments.main.favorite.FavoriteViewModel
import com.uli.main.presentation.ui.fragments.main.word.WordsViewModel
import com.uli.main.presentation.ui.fragments.main.word.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WordsViewModel(get()) }
    viewModel { DetailViewModel(get(), get(), get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { AddWordViewModel(get()) }
}