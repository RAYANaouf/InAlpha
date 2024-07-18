package com.jetapptech.InAlpha.model.variables

import com.jetapptech.InAlpha.R
import com.jetapptech.InAlpha.model.dataClasses.BottomBarItem
import com.jetapptech.InAlpha.model.objects.screens.screens

val bottomBarItems = arrayListOf(
    BottomBarItem(name = screens.home       , selectedImg = R.drawable.selected_home       , unselectedImg = R.drawable.unselected_home),
    BottomBarItem(name = screens.reels      , selectedImg = R.drawable.selected_reels      , unselectedImg = R.drawable.unselected_reels),
    BottomBarItem(name = screens.creativity , selectedImg = R.drawable.selected_creativity , unselectedImg = R.drawable.unselected_creativity),
    BottomBarItem(name = screens.basket     , selectedImg = R.drawable.selected_basket     , unselectedImg = R.drawable.unselected_basket)
)
