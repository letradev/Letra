package com.athul.letra.utils.ext

import android.util.Log
import com.athul.letra.application.AppConstants
import timber.log.Timber

/**
 * Created by   developer on 10-04-2018.
 */

inline fun Any?.infolog(message: String) {
    Timber.tag(AppConstants.APPLICATION_TAG).i(message)
}


fun Log.pr(message: String) {

}