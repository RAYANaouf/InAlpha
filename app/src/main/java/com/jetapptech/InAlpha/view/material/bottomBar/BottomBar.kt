package com.jetapptech.InAlpha.view.material.bottomBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetapptech.InAlpha.model.sealed.BottomBarItem
import com.jetapptech.InAlpha.model.variables.bottomBarItems
import com.jetapptech.InAlpha.ui.theme.customWhite2
import com.jetapptech.InAlpha.ui.theme.customWhite3

@Composable
fun BottomBar(
    selectedItem : String = BottomBarItem.Home().name,
    onClick      : (String)->Unit = {},
    modifier     : Modifier = Modifier
) {

    Surface(
        color = Color.White,
        shadowElevation = 4.dp,
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Color.White)
            .drawBehind {
                drawLine(
                    color = customWhite3,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 1.5.dp.toPx()
                )
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {

            bottomBarItems.forEach {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable {
                            onClick(
                                it.name
                            )
                        }
                ){
                    Image(
                        painter = painterResource(id = if (selectedItem == it.name) it.selectedImg else it.unselectedImg  ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(if (selectedItem == it.name) 30.dp else 25.dp)
                    )
                }
            }


        }
    }

}


@Preview
@Composable
fun BottomBar_preview() {
    BottomBar()
}