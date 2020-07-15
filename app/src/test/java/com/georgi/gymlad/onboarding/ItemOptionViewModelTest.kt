package com.georgi.gymlad.onboarding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.georgi.gymlad.Gender
import com.georgi.gymlad.R
import com.georgi.gymlad.data.OnOnboardingOptionClick
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.viewmodel.onboarding.ItemOptionViewModel
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.quality.Strictness

class ItemOptionViewModelTest {

    lateinit var viewModel: ItemOptionViewModel

    private val option = Option(R.drawable.ic_male, R.string.male_label, Gender.MALE)

    @get:Rule
    var mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var onOnboardingOptionClick: OnOnboardingOptionClick

    @Mock
    private lateinit var intObserver: Observer<Int>

    @Before
    fun setUp() {
        viewModel = ItemOptionViewModel(onOnboardingOptionClick)
        viewModel.onBind(option)
    }

    @Test
    fun testItemIcon() {
        viewModel.icon.observeForever(intObserver)
        verify(intObserver).onChanged(R.drawable.ic_male)
    }

    @Test
    fun testItemText() {
        viewModel.text.observeForever(intObserver)
        verify(intObserver).onChanged(R.string.male_label)
    }

    @Test
    fun testOnItemClick() {
        viewModel.onItemClick()
        verify(onOnboardingOptionClick).onOptionClick(option)
    }
}