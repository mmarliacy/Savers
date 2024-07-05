package com.example.affirmation.nav

sealed class AffirmationRoute (val route : String) {
    data object AffirmationBox : AffirmationRoute(route = "box")
    data object AffirmationsList : AffirmationRoute(route = "list")
}