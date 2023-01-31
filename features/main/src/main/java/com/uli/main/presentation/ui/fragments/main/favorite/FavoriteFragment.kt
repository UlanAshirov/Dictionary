package com.uli.main.presentation.ui.fragments.main.favorite

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uli.core.base.BaseFragment
import com.uli.main.R
import com.uli.main.databinding.FragmentFavoriteBinding
import com.uli.main.presentation.ui.adapter.FavoriteAdapter
import com.uli.main.presentation.ui.fragments.main.MainPagerFragmentDirections
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment :
    BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>(R.layout.fragment_favorite) {
    override val binding by viewBinding(FragmentFavoriteBinding::bind)
    override val viewModel: FavoriteViewModel by viewModel()
    private val adapter by lazy {
        FavoriteAdapter(this::onItemClick)
    }

    override fun initialize() {
        binding.rvLocalWords.adapter = adapter
        viewModel.getLocalWord()
    }

    override fun launchObservers() {
        safeFlowGather {
            viewModel.localState.collectLatest {
                adapter.setList(it)
            }
        }
    }

    private fun onItemClick(id: Int, isLocal: Boolean) {
        findNavController().navigate(
            MainPagerFragmentDirections.actionMainPagerFragment2ToDetailWordBottomSheetFragment(
                id, isLocal
            )
        )
    }
}