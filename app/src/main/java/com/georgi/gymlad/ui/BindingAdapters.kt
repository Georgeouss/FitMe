package com.georgi.gymlad.ui

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("android:text")
fun setText(view: TextView, @StringRes id: Int) {
    view.apply {
        text = resources.getString(id)
    }
}