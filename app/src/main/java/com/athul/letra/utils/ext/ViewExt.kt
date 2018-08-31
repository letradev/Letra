package com.athul.letra.utils.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 *  on 12-04-2018.
 */


fun EditText.onChanged(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            cb(s.toString())
        }
    })
}