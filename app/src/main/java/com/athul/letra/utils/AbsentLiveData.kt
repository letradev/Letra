package com.athul.letra.utils

import android.arch.lifecycle.LiveData

/**
 *  on 10-04-2018.
 */
class AbsentLiveData<T> private constructor() : LiveData<T>() {
    init {
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}
