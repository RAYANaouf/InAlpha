package com.jetapptech.InAlpha.view.screens.navigated

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.rememberAsyncImagePainter
import com.example.bigsam.model.data.`object`.NormalTextStyles
import com.jetapptech.InAlpha.ui.theme.customBlack2
import com.jetapptech.InAlpha.ui.theme.customBlack6
import com.jetapptech.InAlpha.ui.theme.customWhite
import com.jetapptech.InAlpha.ui.theme.customWhite1
import com.jetapptech.InAlpha.ui.theme.customWhite2
import com.jetapptech.InAlpha.ui.theme.customWhite4
import com.jetapptech.InAlpha.ui.theme.customWhite7


val img1 = "https://scontent.cdninstagram.com/v/t51.2885-19/427626253_803160954964333_4652259268885923447_n.jpg?stp=dst-jpg_s150x150&_nc_ht=scontent.cdninstagram.com&_nc_cat=101&_nc_ohc=p9qAiZQoQy0AX83vBhm&edm=APs17CUBAAAA&ccb=7-5&oh=00_AfD2OurX9Ns3-dY87agiZOACYNQcNb5KMOo5quzTMlFyvA&oe=65D4F574&_nc_sid=10d13b"
@Composable
fun HomeScreen(
    modifier : Modifier = Modifier
) {



    var show by remember{
        mutableStateOf(true)
    }
    val view = LocalView.current
    val window = (view.context as Activity).window
    val insetsController = WindowCompat.getInsetsController(window, view)



    SideEffect {

        window.statusBarColor = customWhite.toArgb()

        if (!view.isInEditMode){
            insetsController.apply {
                hide(WindowInsetsCompat.Type.navigationBars())
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        
    }



    LazyColumn(
        modifier = modifier

//            .clickable {
//                show = !show
//            }
    ){

        item {

            Spacer(modifier = Modifier.height(16.dp))

            Post(
                modifier = Modifier
            )
            
        }

        item{

            Spacer(modifier = Modifier.height(25.dp))

            Post(
                modifier = Modifier
            )

        }

        item{

            Spacer(modifier = Modifier.height(25.dp))

            Post(
                modifier = Modifier
            )

        }

        item{

            Spacer(modifier = Modifier.height(25.dp))

            Post(
                modifier = Modifier
            )

        }

        item{

            Spacer(modifier = Modifier.height(25.dp))

            Post(
                modifier = Modifier
            )

        }
        
        item { 
            Spacer(modifier = Modifier.height(22.dp))
        }

    }
}


@Composable
fun Post(
    modifier: Modifier = Modifier
) {

    TopSection_post(
        modifier = modifier
            .fillMaxWidth()
    )

}


@Composable
fun TopSection_post(
    modifier : Modifier = Modifier
) {

    val constraintSet = ConstraintSet{
        val imgRef     = createRefFor("img")
        val nameRef    = createRefFor("name")
        val descRef    = createRefFor("desc")
        val photosRef  = createRefFor("photos")
        val dividerRef = createRefFor("divider")



        constrain(imgRef){
            top.linkTo(parent.top )
            start.linkTo(parent.start , margin = 16.dp)

            width  = Dimension.value(40.dp)
            height = Dimension.value(40.dp)
        }

        constrain(nameRef){
            top.linkTo(imgRef.top)
            start.linkTo(imgRef.end , margin = 8.dp)
        }

        constrain(descRef){
            top.linkTo(nameRef.bottom , margin = 6.dp)
            start.linkTo(nameRef.start)
        }

        constrain(photosRef){
            top.linkTo(descRef.bottom , margin = 12.dp)
            start.linkTo(parent.start)
        }

        constrain(dividerRef){
            top.linkTo(imgRef.bottom , margin = 8.dp)
            start.linkTo(imgRef.start)
            end.linkTo(imgRef.end)
            bottom.linkTo(parent.bottom)
            width  = Dimension.value(1.5.dp)
            height = Dimension.fillToConstraints
        }
    }


    ConstraintLayout(constraintSet = constraintSet , modifier = modifier) {
        Image(
            painter = rememberAsyncImagePainter(model = img1 ),
            contentDescription = null ,
            modifier = Modifier
                .clip(CircleShape)
                .layoutId("img")
        )

        Text(
            text = "Rayan aouf",
            style = NormalTextStyles.TextStyleSZ8.copy(color = customBlack2),
            modifier = Modifier
                .layoutId("name")
        )

        Text(
            text = "#basket #chaussure #beauty #enfants #colorful\n" +
                    "Pointeur : 26-34\n" +
                    "Prix : 2900 DA ",
            style = NormalTextStyles.TextStyleSZ9.copy(color = customBlack6),
            modifier = Modifier
                .layoutId("desc")
        )
        
        
        Spacer(modifier = Modifier
            .background(customWhite7)
            .layoutId("divider"))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .layoutId("photos")
        ){
            
            item{
                Spacer(modifier = Modifier.width(40.dp + 16.dp - 12.dp))
            }
            
            item {
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .width(290.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.5.dp,
                            color = customWhite7,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(customWhite2)
                ) {

                }
            }
            item {
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .width(290.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.5.dp,
                            color = customWhite7,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(customWhite4)
                ) {

                }
            }
            item {
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .width(290.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.5.dp,
                            color = customWhite7,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(customWhite1)
                ) {

                }
            }
            item {
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .width(290.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.5.dp,
                            color = customWhite7,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(customWhite2)
                ) {

                }
            }
        }

    }

}


@Composable
fun MiddelSection_post(
    modifier: Modifier = Modifier
) {

}


@Composable
fun BottomSection_post(
    modifier: Modifier = Modifier
) {

}


@Preview
@Composable
fun Post_preview() {
    Post()
}



