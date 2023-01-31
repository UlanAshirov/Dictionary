package com.uli.main.presentation.ui.fragments.addword

import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.uli.core.base.BaseFragment
import com.uli.main.R
import com.uli.main.databinding.FragmentAddWordBinding
import com.uli.main.presentation.model.WordsUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddWordFragment :
    BaseFragment<FragmentAddWordBinding, AddWordViewModel>(R.layout.fragment_add_word) {
    override val binding by viewBinding(FragmentAddWordBinding::bind)
    override val viewModel: AddWordViewModel by viewModel()

    override fun launchObservers() {
        binding.btnAddNewWord.setOnClickListener {
            val title = binding.etNewTitle.text.toString()
            val des = binding.etNewDes.text.toString()
            val model = WordsUI(
                title = title,
                description = des,
                isNewWord = true,
                id = 0
            )
            viewModel.addNewWord(model)

            val dialog = MaterialAlertDialogBuilder(requireContext(), R.style.RoundedMaterialDialog)
                .setView(R.layout.item_dialog)
                .show()

            dialog.findViewById<View>(R.id.btn_ok)?.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}