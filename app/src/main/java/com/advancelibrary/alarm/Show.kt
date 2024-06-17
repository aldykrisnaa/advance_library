package com.advancelibrary.alarm

import com.advancelibrary.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Beranda.route,
        Screen.Search.route,
        Screen.Akun.route,

    )
}