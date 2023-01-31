package com.uli.main.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.uli.core.base.BaseDiffUtil
import com.uli.main.databinding.ItemWordsBinding
import com.uli.main.presentation.model.WordsUI

class WordsAdapter(
    private val listener: OpenDetailListener
) : PagingDataAdapter<WordsUI, WordsAdapter.WordsViewHolder>(BaseDiffUtil()) {

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val model = getItem(position)
        model?.let { holder.onBind(it) }
        holder.itemView.setOnClickListener {
            model?.id?.let { it1 -> listener.openDetail(it1, false) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordsViewHolder(
        ItemWordsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    inner class WordsViewHolder(private val binding: ItemWordsBinding) : ViewHolder(binding.root) {
        fun onBind(item: WordsUI) {
            binding.itemTvTitle.text = item.title

        }
    }

    interface OpenDetailListener {
        fun openDetail(id: Int, isLocal: Boolean)
    }
}