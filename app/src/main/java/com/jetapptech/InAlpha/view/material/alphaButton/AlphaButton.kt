package com.jetapptech.InAlpha.view.material.alphaButton

import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bigsam.model.data.`object`.NormalTextStyles

@Composable
fun AlphaButton(
    modifier        : Modifier = Modifier,
    txt             : String,
    textColor       : Color = Color(parseColor("#FFFFFF")),
    shape           : Shape = RoundedCornerShape(12.dp),
    backgroundColor : Color = Color(parseColor("#1D71A0")),
    onClick         : ()->Unit ={}
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .clickable {
                onClick()
            }
            .padding(top = 8.dp , bottom = 8.dp , start = 14.dp , end = 14.dp )
    ) {
        Text(
            text = txt,
            style = NormalTextStyles.TextStyleSZ6.copy(color = textColor )
        )
    }

}

@Preview
@Composable
fun AlphaButton_preview() {

}