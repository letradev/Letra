package com.athul.letra.utils.ext

import java.util.*

/**
 *  on 13-04-2018.
 */

fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}


fun Any?.getSaltString(length:Int): String {
    val SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    val salt = StringBuilder()
    val rnd = Random()
    while (salt.length < length) { // length of the random string.
        val index = (rnd.nextFloat() * SALTCHARS.length)
        salt.append(SALTCHARS[index.toInt()])
    }
    return salt.toString()

}