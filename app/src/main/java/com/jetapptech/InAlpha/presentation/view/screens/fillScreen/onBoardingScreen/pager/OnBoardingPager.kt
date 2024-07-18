package com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.pager

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bigsam.model.data.`object`.NormalTextStyles
import com.jetapptech.InAlpha.presentation.ui.theme.blue1
import com.jetapptech.InAlpha.presentation.ui.theme.customBlack5
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.data.onboardingScene.OnBoardingScene

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(
    onBoardingScenes : List<OnBoardingScene> ,
    pagerState       : PagerState,
    modifier         : Modifier = Modifier
) {


    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) {index->

        PageScene(
            onBoardingScenes[index].img,
            onBoardingScenes[index].title,
            onBoardingScenes[index].desc,
            modifier = Modifier
                .fillMaxHeight()
        )

    }

}

@Composable
fun PageScene(
    @DrawableRes img : Int,
    text : String,
    desc : String,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier
    ) {
        Imgs(
            img,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 180.dp , min = 180.dp)
        )

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = text,
            style = NormalTextStyles.TextStyleSZ4.copy(color = blue1),
            modifier = Modifier
                .padding(start = 16.dp , end = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = desc,
            style = NormalTextStyles.TextStyleSZ9.copy(color = customBlack5),
            modifier = Modifier
                .padding(start = 16.dp , end = 16.dp)
        )
    }

}

@Composable
fun Imgs(
    @DrawableRes img : Int,
    modifier : Modifier = Modifier
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
    }

}