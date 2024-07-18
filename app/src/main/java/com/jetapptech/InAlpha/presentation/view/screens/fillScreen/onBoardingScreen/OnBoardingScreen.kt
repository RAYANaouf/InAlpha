package com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bigsam.model.data.`object`.NormalTextStyles
import com.jetapptech.InAlpha.R
import com.jetapptech.InAlpha.presentation.ui.theme.blue1
import com.jetapptech.InAlpha.presentation.ui.theme.customBlack5
import com.jetapptech.InAlpha.presentation.ui.theme.customBlack8
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite1
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite2
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite5
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.data.onboardingScene.OnBoardingScene
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.data.events.Events
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.pager.OnBoardingPager
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onEven       : (Events)->Unit = {},
    modifier     : Modifier
) {


    val pagesList = listOf(
        OnBoardingScene(
            title = "Welcome to Alpha app.",
            desc = "Discoverthe world of alpha app. \nGet started with our intuitive features.",
            img = R.drawable.welcome
        ) ,
        OnBoardingScene(
            title = "Buy new shoes and clothes.",
            desc  = "get new shoes or clothes , follow your store products.\nget new shoes or clothes , follow your store products.get new shoes or clothes , follow your store products.",
            img = R.drawable.shoes
        ) ,
        OnBoardingScene(
            title = "delivery is available.",
            desc  = "get new shoes or clothes , follow your store products.\nget new shoes or clothes , follow your store products.get new shoes or clothes , follow your store products.\n",
            img = R.drawable.delivery
        )
    )

    val pagerState = rememberPagerState {
        3
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
    ) {


        //blank space
        Spacer(
            modifier = Modifier.weight(1f)
        )

        OnBoardingPager(
            pagerState = pagerState,
            onBoardingScenes = pagesList,
            modifier = Modifier
                .weight(6f)
        )


//        Spacer(
//            modifier = Modifier.weight(3f)
//        )


        Indicator(
            pages = pagesList,
            selectedPage = pagerState.currentPage,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )

        Buttons(
            lastPage = pagerState.currentPage == pagesList.size-1,
            onNextClick = {
                if (pagerState.currentPage < pagesList.size-1){
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage+1)
                    }
                }
                else if (pagerState.currentPage == pagesList.size-1){
                    onEven(Events.saveAppEntryEvent)
                }
            },
            onBackClick = {
                if (pagerState.currentPage > 0){
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage-1)
                    }
                }
            }
        )

    }

}






@Composable
fun Indicator(
    selectedPage : Int = 0 ,
    pages        : List<OnBoardingScene> = emptyList(),
    modifier     : Modifier
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        pages.forEachIndexed {index , item ->
            Box(
                modifier = Modifier
                    .size(if (index == selectedPage) 16.dp else 10.dp)
                    .clip(CircleShape)
                    .background(if (index == selectedPage) blue1 else Color.Transparent)
                    .border(
                        width = 1.dp,
                        color = blue1,
                        shape = CircleShape
                    )
            )

            if (index != pages.size-1)
                Spacer(modifier = Modifier.width(6.dp))
        }

    }
}


@Composable
fun Buttons(
    lastPage     : Boolean ,
    onNextClick  : ()->Unit = {},
    onBackClick  : ()->Unit = {}
    ){
    Column(
        modifier = Modifier
            .fillMaxWidth()
//                .background(Color.Cyan)
            .padding(top = 25.dp, bottom = 25.dp)
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(start = 26.dp, end = 26.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(blue1)
                .clickable {
                    onNextClick()
                }
        ) {
            Text(
                text = if(lastPage) "Done" else "Next",
                style = NormalTextStyles.TextStyleSZ6.copy(color = Color.White)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(start = 26.dp, end = 26.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(customWhite1)
                .clickable {
                    onBackClick()
                }
        ) {
            Text(
                text = "Back",
                style = NormalTextStyles.TextStyleSZ6.copy(color = customBlack5)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

    }
}