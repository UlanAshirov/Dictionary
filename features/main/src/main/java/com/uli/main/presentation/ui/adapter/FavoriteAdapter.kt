package com.uli.main.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.uli.main.databinding.ItemLocalWordsBinding
import com.uli.main.presentation.model.WordsUI

class FavoriteAdapter(
    private val onItemClick: (id: Int, isLocal: Boolean) -> Unit
) : Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    private var localWords = listOf<WordsUI>()

    fun setList(localWords: List<WordsUI>) {
        this.localWords = localWords
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteViewHolder(
            ItemLocalWordsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.onBind(localWords[position])
        holder.itemView.setOnClickListener {
            onItemClick(localWords[position].id, true)
        }
    }

    override fun getItemCount() = localWords.size

    class FavoriteViewHolder(private val binding: ItemLocalWordsBinding) :
        ViewHolder(binding.root) {
        fun onBind(wordsUI: WordsUI) {
            binding.itemTvLocalTitle.text = wordsUI.title
        }
    }
}