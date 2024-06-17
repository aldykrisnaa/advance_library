package com.advancelibrary.navigation

    sealed class Screen(val route: String){
        data object Login : Screen("login")
        data object Beranda : Screen ("beranda")

        data object Search : Screen ("search")
        data object Akun : Screen ("akun")
        data object DetailBookFiksi : Screen ("detail_book_fiksi")
        data object DetailBookNonFiksi : Screen ("detail_book_nonfiksi")
        data object Alarm: Screen("alarm")

    }



