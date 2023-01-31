package com.uli.main.presentation.ui.fragments.main.word

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uli.core.base.BaseFragment
import com.uli.main.R
import com.uli.main.databinding.FragmentWordsBinding
import com.uli.main.presentation.ui.adapter.WordsAdapter
import com.uli.main.presentation.ui.fragments.main.MainPagerFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel


class WordsFragment(
) : BaseFragment<FragmentWordsBinding, WordsViewModel>(R.layout.fragment_words),
    WordsAdapter.OpenDetailListener {
    override val viewModel: WordsViewModel by viewModel()
    override val binding by viewBinding(FragmentWordsBinding::bind)
    private val adapter by lazy {
        WordsAdapter(this)
    }

    override fun initialize() {
        binding.rvWord.adapter = adapter
    }

    override fun launchObservers() {
        viewModel.getWords().spectatePaging { pagingData ->
            adapter.submitData(pagingData)
        }
    }

    override fun constructListeners() {
        binding.btnAddWord.setOnClickListener {
            findNavController().navigate(
                MainPagerFragmentDirections.actionMainPagerFragment2ToAddWordFragment()
            )
        }
        binding.rvWord.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    binding.btnAddWord.animate().translationY(500F).setDuration(300).start()
                } else if (dy < 0) {
                    binding.btnAddWord.animate().translationY(0F).setDuration(300).start()
                }
            }
        })
    }

    override fun openDetail(id: Int, isLocal: Boolean) {
        findNavController().navigate(
            MainPagerFragmentDirections.actionMainPagerFragment2ToDetailWordBottomSheetFragment(
                id,
                false
            )
        )
    }
    //рефлексия
    //service locator
    //koin vs hilt
    //анонимные функции

}