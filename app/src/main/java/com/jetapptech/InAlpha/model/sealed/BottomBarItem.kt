package com.jetapptech.InAlpha.model.sealed

import com.jetapptech.InAlpha.model.objects.bottomBarItem.bottomBarItem

sealed class BottomBarItem (val name : String ) {

    class Home       : BottomBarItem(name = bottomBarItem.home)
    class Basket     : BottomBarItem(name = bottomBarItem.basket)
    class Creativity : BottomBarItem(name = bottomBarItem.creativity)
    class Reels      : BottomBarItem(name = bottomBarItem.reels)

}
