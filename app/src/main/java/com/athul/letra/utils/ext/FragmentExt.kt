package com.athul.letra.utils.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.athul.letra.application.AppConstants

/**
 *  on 16-04-2018.
 */

inline fun Fragment.movetoActivity(activity: AppCompatActivity, classname: Class<out Activity>, bundle: Bundle) {
    val i = Intent(activity, classname)
    bundle?.let { i.putExtras(it) }
    startActivity(i)
}


fun Fragment.toast(string: String) {

    Toast.makeText(activity, string, Toast.LENGTH_SHORT).show()

}

fun Fragment.toastLong(string: String) {

    Toast.makeText(activity, string, Toast.LENGTH_LONG).show()

}


inline fun Fragment.putValue(key: String, value: Any): Boolean {

    val preferences = context!!.getSharedPreferences(
            AppConstants.SHARED_PREFS_FILE, Context.MODE_PRIVATE)
    val editor = preferences.edit()
    when (value) {

        is Int -> {
            editor.putInt(key, value)
        }
        is String -> {
            editor.putString(key, value)
        }
        is Boolean -> {
            editor.putBoolean(key, value)
        }
        is Long -> {
            editor.putLong(key, value)
        }
    }
    return editor.commit()
}

inline fun Fragment.getValue(key: String, default_Value: Any): Any {

    val preferences = context!!.getSharedPreferences(
            AppConstants.SHARED_PREFS_FILE, Context.MODE_PRIVATE)


    when (default_Value) {

        is Int -> {
            return preferences.getInt(key, default_Value)
        }
        is String -> {
            return preferences.getString(key, default_Value)
        }
        is Boolean -> {
            return preferences.getBoolean(key, default_Value)
        }
        is Long -> {
            return preferences.getLong(key, default_Value)
        }
    }
    return default_Value
}

