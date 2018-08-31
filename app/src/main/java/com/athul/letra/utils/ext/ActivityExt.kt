package com.athul.letra.utils.ext

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.Window
import android.view.WindowManager

inline fun Activity.moveToActivity(destinationClass: Class<*>, isFinish: Boolean) {
    val intent = Intent(this, destinationClass)
    startActivity(intent)
    if (isFinish) finish()
}
inline fun Activity.setfullscreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

}

inline fun FragmentActivity.setFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    val manager = supportFragmentManager
    val fragment = manager?.findFragmentById(containerViewId)
    fragment?.let { return it }
    return f().apply { manager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}


