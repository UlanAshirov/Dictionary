package com.uli.main.presentation.ui.fragments.main.word.detail

import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.uli.core.base.BaseBottomSheetDialogFragment
import com.uli.main.databinding.FragmentDetailWordBinding
import com.uli.main.presentation.model.WordsUI
import com.uli.main.presentation.model.toDomain
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailWordBottomSheetFragment :
    BaseBottomSheetDialogFragment<FragmentDetailWordBinding, DetailViewModel>(
        FragmentDetailWordBinding::inflate
    ) {
    override val viewModel: DetailViewModel by viewModel()
    private val args by navArgs<DetailWordBottomSheetFragmentArgs>()


    override fun launchObservers() {
        if (!args.isLocal) {
            viewModel.getWords(args.wordId)
            viewModel.state.spectateUiState(success = { word ->
                binding.tvDetailTitle.text = word.title
                binding.tvItemDes.text = word.description

                safeWordLocalDb(word)
            })
        } else {
            viewModel.getLocalWordDetail(args.wordId)
            viewModel.localSingleWordDetail.spectateUiState(
                success = { localWord ->
                    binding.tvDetailTitle.text = localWord?.title
                    binding.tvItemDes.text = localWord?.description
                })
        }
    }

    private fun safeWordLocalDb(word: WordsUI) {
        binding.btnFavoriteChoose.setOnClickListener {
            viewModel.addWordToLocalDb(word.toDomain())
            Toast.makeText(requireContext(), "Ураа", Toast.LENGTH_LONG).show()
        }
    }
}
