package com.georgi.gymlad.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Option(@DrawableRes val imageId: Int, @StringRes val textId: Int,val value:Any)