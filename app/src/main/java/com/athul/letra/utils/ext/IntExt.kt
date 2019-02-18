package com.athul.letra.utils.ext

import android.content.res.Resources

inline val Int.dp: Float
    get() = (this / Resources.getSystem().displayMetrics.density).toFloat()
inline val Int.px: Float
    get() = (this * Resources.getSystem().displayMetrics.density).toFloat()