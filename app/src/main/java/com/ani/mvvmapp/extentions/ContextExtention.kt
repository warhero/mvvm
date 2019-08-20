package com.ani.mvvmapp.extentions

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.string(@StringRes resId: Int) = resources.getString(resId)

fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
