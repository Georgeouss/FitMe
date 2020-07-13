package com.georgi.gymlad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    internal val binding: T?
        get() {
            return view?.let {
                DataBindingUtil.findBinding(it)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return createBinding(inflater, container).root
    }

    protected abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            onViewCreated(it, savedInstanceState)
        }
    }

    abstract fun onViewCreated(binding: T, savedInstanceState: Bundle?)
}