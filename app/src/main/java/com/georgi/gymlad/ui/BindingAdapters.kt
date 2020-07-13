package com.georgi.gymlad.ui

import android.content.res.Resources
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("android:text")
fun setText(view: TextView, @StringRes id: Int) {
    view.apply {
        try {
            text = resources.getString(id)
        } catch (exception: Resources.NotFoundException) {
            Log.d("resource", "Not found")
        }
    }
}

@BindingAdapter("android:src")
fun setImage(view: ImageView, @DrawableRes id: Int) {
    view.apply {
        view.setImageResource(id)
    }
}