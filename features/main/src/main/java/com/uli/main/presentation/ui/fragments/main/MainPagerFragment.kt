package com.uli.main.presentation.ui.fragments.main

import androidx.core.view.isGone
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.uli.core.base.BaseFragmentWithoutViewModel
import com.uli.main.R
import com.uli.main.databinding.FragmentMainPagerBinding
import com.uli.main.presentation.ui.adapter.PagerAdapter

class MainPagerFragment :
    BaseFragmentWithoutViewModel<FragmentMainPagerBinding>(R.layout.fragment_main_pager) {
    override val binding by viewBinding(FragmentMainPagerBinding::bind)

    override fun initialize() {
        binding.pager.adapter = PagerAdapter(this)
        val fragmentsName = listOf(
            "Список", "Избранное"
        )
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = fragmentsName[position]
        }.attach()

        if (binding.pager.currentItem == 0) {
            binding.btnDelete.isGone = true
        } else if (binding.pager.currentItem == 1) {
            binding.btnDelete.isVisible = true
        }
    }
}