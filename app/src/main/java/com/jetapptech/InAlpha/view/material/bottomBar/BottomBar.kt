package com.jetapptech.InAlpha.view.material.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetapptech.InAlpha.ui.theme.customWhite2
import com.jetapptech.InAlpha.ui.theme.customWhite3

@Composable
fun BottomBar(
    modifier : Modifier = Modifier
) {

    Surface(
        color = Color.White,
        shadowElevation = 4.dp,
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(Color.White)
            .drawBehind {
                drawLine(
                    color = customWhite3 ,
                    start = Offset(0f , 0f),
                    end   = Offset(size.width , 0f),
                    strokeWidth = 1.5.dp.toPx()
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }

}


@Preview
@Composable
fun BottomBar_preview() {
    BottomBar()
}