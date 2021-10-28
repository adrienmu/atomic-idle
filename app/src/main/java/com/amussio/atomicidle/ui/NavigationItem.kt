package com.amussio.atomicidle.ui

import com.amussio.atomicidle.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object MyWorld : NavigationItem("home", R.drawable.ic_nature, "My world")
    object Build : NavigationItem("music", R.drawable.ic_construction, "Build")
    object Improve : NavigationItem("movies", R.drawable.ic_baseline_star_24, "Improve")
    object Scientists : NavigationItem("books", R.drawable.ic_baseline_science_24, "Scientists")
    object Dashboard : NavigationItem("profile", R.drawable.ic_baseline_dashboard_24, "Dashboard")
}