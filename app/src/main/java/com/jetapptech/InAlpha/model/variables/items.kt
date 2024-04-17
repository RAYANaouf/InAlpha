package com.jetapptech.InAlpha.model.variables

import com.jetapptech.InAlpha.R
import com.jetapptech.InAlpha.model.dataClasses.BottomBarItem
import com.jetapptech.InAlpha.model.objects.bottomBarItem.bottomBarItem

val bottomBarItems = arrayListOf(
    BottomBarItem(name = bottomBarItem.home       , selectedImg = R.drawable.selected_home       , unselectedImg = R.drawable.unselected_home),
    BottomBarItem(name = bottomBarItem.reels      , selectedImg = R.drawable.selected_reels      , unselectedImg = R.drawable.unselected_reels),
    BottomBarItem(name = bottomBarItem.creativity , selectedImg = R.drawable.selected_creativity , unselectedImg = R.drawable.unselected_creativity),
    BottomBarItem(name = bottomBarItem.basket     , selectedImg = R.drawable.selected_basket     , unselectedImg = R.drawable.unselected_basket)
)
