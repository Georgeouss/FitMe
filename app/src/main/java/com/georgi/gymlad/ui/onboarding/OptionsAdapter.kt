package com.georgi.gymlad.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.georgi.gymlad.data.OnOnboardingOptionClick
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.databinding.LayoutOnboardingOptionBinding
import com.georgi.gymlad.viewmodel.onboarding.ItemOptionViewModel

class OptionsAdapter(
    private val options: List<Option>,
    private val onOnboardingOptionClick: OnOnboardingOptionClick,
    private val lifecycleOwner: LifecycleOwner
) :
    RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OptionsAdapter.OptionViewHolder {

        val viewModel = ItemOptionViewModel(onOnboardingOptionClick)

        val binding = LayoutOnboardingOptionBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return OptionViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: OptionsAdapter.OptionViewHolder, position: Int) {
        holder.onBind(options[position])
    }

    inner class OptionViewHolder(
        private val binding: LayoutOnboardingOptionBinding,
        private val viewModel: ItemOptionViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = viewModel
            binding.lifecycleOwner = lifecycleOwner
        }

        fun onBind(option: Option) {
            viewModel.onBind(option)
            binding.executePendingBindings()
        }
    }
}