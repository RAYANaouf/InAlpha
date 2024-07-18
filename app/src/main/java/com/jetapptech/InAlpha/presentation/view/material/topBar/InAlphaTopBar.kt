package com.jetapptech.InAlpha.presentation.view.material.topBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.daracademy.model.variables.firaSansFamily
import com.example.daracademy.model.variables.permanentMarker
import com.jetapptech.InAlpha.R
import com.jetapptech.InAlpha.presentation.ui.theme.blue1
import com.jetapptech.InAlpha.presentation.ui.theme.blue2
import com.jetapptech.InAlpha.presentation.ui.theme.blue3
import com.jetapptech.InAlpha.presentation.ui.theme.color3
import com.jetapptech.InAlpha.presentation.ui.theme.color5
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite5
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite7

@Composable
fun InAlphaTopBar(
    modifier  : Modifier = Modifier,
    @DrawableRes logo    : Int = R.drawable.user,
    onClick   : ()->Unit = {},
    brand     : String   = "In-Alpha",
    elevation : Dp = 1.dp
) {

    Surface(
        shadowElevation = elevation,
        color    = Color.White ,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(55.dp)
                .fillMaxWidth()
                .background(Color.Transparent)
        ){
            
//            Spacer(modifier = Modifier.width(16.dp).background(Color.Transparent))
//
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterStart)
            ) {
                Image(
                    painter = painterResource(id = logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            onClick()
                        }
                )
            }
//
//            Spacer(modifier = Modifier.width(8.dp))

//            Text(
//                text = buildAnnotatedString {
//                    withStyle(
//                        style = SpanStyle(color = blue1 , fontFamily = permanentMarker , fontSize = 26.sp)
//                    ){
//                        append("In")
//                    }
//                    withStyle(
//                        style = SpanStyle(fontFamily = permanentMarker)
//                    ){
//                        append("-")
//                    }
//                    withStyle(
//                        style = SpanStyle(color = blue3 , fontFamily = permanentMarker)
//                    ){
//                        append("Alpha")
//                    }
//                }
//            )


//            Spacer(modifier = Modifier.weight(1f))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
            ) {
                Text(
                    text = "All",
                    style = TextStyle(fontSize = 20
                        .sp , fontFamily = firaSansFamily , color = blue1 , fontWeight = FontWeight.SemiBold)
                )

                Text(text = " / ")

                Text(
                    text = "Followed",
                    style = TextStyle(fontFamily = firaSansFamily , color = customWhite7)
                )
            }

//            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .padding(end  = 16.dp)
                    .align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.options),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
            }

        }
    }

}


@Preview
@Composable
fun InAlphaTopBar_preview() {
//    InAlphaTopBar()
}