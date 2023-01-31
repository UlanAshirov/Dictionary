package com.uli.main.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.uli.main.presentation.ui.fragments.main.MainFlowFragment
import com.uli.main.presentation.ui.fragments.main.favorite.FavoriteFragment
import com.uli.main.presentation.ui.fragments.main.word.WordsFragment

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WordsFragment()
            1 -> FavoriteFragment()
            else -> WordsFragment()
        }
    }
}