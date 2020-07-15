package com.georgi.gymlad.viewmodel.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.georgi.gymlad.data.OnOnboardingOptionClick
import com.georgi.gymlad.data.Option
import com.snakydesign.livedataextensions.map

class ItemOptionViewModel(private val onOnboardingOptionClick: OnOnboardingOptionClick) :
    ViewModel() {

    private val option = MutableLiveData<Option>()

    fun onBind(option: Option) {
        this.option.value = option
    }

    fun onItemClick() {
        option.value?.let { onOnboardingOptionClick.onOptionClick(it) }
    }

    val icon = option.map {
        it.imageId
    }

    val text = option.map {
        it.textId
    }
}