package com.jetapptech.InAlpha.presentation.view.screens.navigated

import android.app.Activity
import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
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
import com.jetapptech.InAlpha.presentation.ui.theme.customBlack2
import com.jetapptech.InAlpha.presentation.ui.theme.customBlack6
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite0
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite1
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite2
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite4
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite7


val img1 = "https://scontent.cdninstagram.com/v/t51.2885-19/427626253_803160954964333_4652259268885923447_n.jpg?stp=dst-jpg_s150x150&_nc_ht=scontent.cdninstagram.com&_nc_cat=101&_nc_ohc=p9qAiZQoQy0AX83vBhm&edm=APs17CUBAAAA&ccb=7-5&oh=00_AfD2OurX9Ns3-dY87agiZOACYNQcNb5KMOo5quzTMlFyvA&oe=65D4F574&_nc_sid=10d13b"


data class User(
    val name   : String = "",
    val imgUrl : String = ""
)
data class PostData(
    val user   : User         = User(),
    val desc   : String       = "",
    val photos : List<String> = emptyList()
)


val posts = listOf(
    PostData(
        user   = User(name = "Rayan Aouf" , imgUrl = "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/boutique-fashion-logo-design-template-b38bb3b2998ca202be88743724487518_screen.jpg?ts=1677355315"),
        desc   = "Multicolor Balmain Men's Shoes\n₹ 13,000/ pairGet Latest Price" ,
        photos = listOf(
            "https://5.imimg.com/data5/SELLER/Default/2022/11/AM/NN/PC/12752929/balmain-men-s-shoes.jpg",
            "https://5.imimg.com/data5/SELLER/Default/2022/9/IQ/SN/TD/159505247/img-20220930-wa0080-500x500.jpg",
            "https://5.imimg.com/data5/SELLER/Default/2022/8/XG/NN/PJ/9581609/balmain-brand-shoe.jpg",
            "https://kdbdeals.com/wp-content/uploads/2023/08/Balmain-unicorn-sneaker-For-Men-Black-White-1.jpg"
        )
    ),
    PostData(
        user = User(name = "Sammi" , imgUrl = "https://img.freepik.com/vecteurs-libre/vintage-boutique-logo_1057-438.jpg"),
        desc = "RUNFALCON 3 RUNNING SHOES\n\$65\n\$49" ,
        photos = listOf(
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/f2d9229b65c248488c78af3b00851dab_9366/Runfalcon_3_Running_Shoes_White_HP7557_01_standard.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/335685e6d9af420694a1af3b008a42a5_9366/Runfalcon_3_Running_Shoes_White_HP7557_02_standard_hover.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/6a6de7d4b97c47ee886faf3b008a4b3e_9366/Runfalcon_3_Running_Shoes_White_HP7557_03_standard.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/c3fe7bea5fe444aeb1c1af3b008a53a1_9366/Runfalcon_3_Running_Shoes_White_HP7557_04_standard.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/daab56b023304a0aaca4af3b008a5ce4_9366/Runfalcon_3_Running_Shoes_White_HP7557_05_standard.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/d217f51cb3f44933b3a3af3b00aac993_9366/Runfalcon_3_Running_Shoes_White_HP7557_09_standard.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/eb6d3808fe4b4cc1ae68af3b008a65fd_9366/Runfalcon_3_Running_Shoes_White_HP7557_41_detail.jpg",
            "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/9585def867264de78a95af3b008a6fb0_9366/Runfalcon_3_Running_Shoes_White_HP7557_42_detail.jpg"
        )
    ),
    PostData(
        user = User(name = "Sigma Shoes" , imgUrl = "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/fashion-boutique-circle-blue-pink-logo-design-template-94ff8fe643d8ed79a0436e92233fabee_screen.jpg?ts=1619134622"),
        desc = "Adidas Runfalcon Running Shoes Blue Men's Running Adidas US, 59% OFF" ,
        photos = listOf(
            "https://cdn.outsideonline.com/wp-content/uploads/2022/07/HOKA_W_MACH5_s.jpg",
            "https://di2ponv0v5otw.cloudfront.net/posts/2023/07/01/64a098b7fedc5c5c1c18f48c/s_64a09a55bd66cdbe8d2e69d3.jpeg",
            "https://di2ponv0v5otw.cloudfront.net/posts/2024/04/09/6615a5eb15460031ccd39cfd/m_wp_6615a604142ad41e52945d3e.webp",

        )
    ),
    PostData(
        user = User(name = "Happy_Boutique" , imgUrl = "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/boutique-logo-design-template-d05adb0d64f44697095205575f8cfca9_screen.jpg?ts=1646204567") ,
        desc = "Adult Basketball Shoes Protect 120 Black Grey" ,
        photos = listOf(
            "https://contents.mediadecathlon.com/p2143006/ae3f52f8b19434fb8b9bb2ee1c293d09/p2143006.jpg?format=auto&quality=70&f=650x0",
            "https://contents.mediadecathlon.com/p2033214/k\$386b506940fc181445e7610a564af230/chaussures-basketball-pour-adulte-hslashf-debutant-protect-120.jpg?&f=250x250",
            "https://cdn.dsmcdn.com/ty451/product/media/images/20220609/17/123464734/497356079/2/2_org_zoom.jpg"
        )
    ),
//    PostData(
//        user = User(name = "Mo Moh"),
//        desc = "" ,
//        photos = listOf()
//    ),
//    PostData(
//        user = User(name = "Happy_Boutique") ,
//        desc = "" ,
//        photos = listOf()
//    ),
//    PostData(
//        user = User(name = "Happy_Boutique") ,
//        desc = "" ,
//        photos = listOf()
//    ),
//    PostData(
//        user = User(name = "Rayan Aouf")     ,
//        desc = "" ,
//        photos = listOf()
//    ),
//    PostData(
//        user = User(name = "Sammi")          ,
//        desc = "" ,
//        photos = listOf()
//    ),
//    PostData(
//        user = User(name = "Abdou"),
//        desc = "" ,
//        photos = listOf()
//    ),
)


@Composable
fun HomeScreen(
    modifier : Modifier = Modifier
        .background(Color(parseColor("#FCFCFC")))
) {




    LazyColumn(
        modifier = modifier

//            .clickable {
//                show = !show
//            }
    ){



        itemsIndexed(posts){index , post ->
            Spacer(modifier = Modifier.height(if (index == 0) 16.dp else 25.dp))

            Post(
                modifier = Modifier,
                post = post
            )
        }


        
        item { 
            Spacer(modifier = Modifier.height(22.dp))
        }

    }
}




@Composable
fun Post(
    modifier: Modifier = Modifier,
    post    : PostData
) {

    TopSection_post(
        post     = post,
        modifier = modifier
            .fillMaxWidth()
    )

}


@Composable
fun TopSection_post(
    modifier : Modifier = Modifier,
    post    : PostData
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
            painter = rememberAsyncImagePainter(model = post.user.imgUrl ),
            contentDescription = null ,
            modifier = Modifier
                .clip(CircleShape)
                .layoutId("img")
        )

        Text(
            text = post.user.name,
            style = NormalTextStyles.TextStyleSZ8.copy(color = customBlack2),
            modifier = Modifier
                .layoutId("name")
        )

        Text(
//            text = "#basket #chaussure #beauty #enfants #colorful\n" +
//                    "Pointeur : 26-34\n" +
//                    "Prix : 2900 DA ",
            text = post.desc,
            style = NormalTextStyles.TextStyleSZ9.copy(color = customBlack6),
            modifier = Modifier
                .layoutId("desc")
        )
        
        
//        Spacer(modifier = Modifier
//            .background(customWhite7)
//            .layoutId("divider"))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .layoutId("photos")
        ){
            
            item{
                Spacer(modifier = Modifier.width(40.dp + 16.dp - 12.dp))
            }
            
            itemsIndexed(post.photos) {index , img->
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .width(290.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.5.dp,
                            color = customWhite2,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(customWhite0)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = img),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
////            item {
////                Box(
////                    modifier = Modifier
////                        .height(240.dp)
////                        .width(290.dp)
////                        .clip(RoundedCornerShape(12.dp))
////                        .border(
////                            width = 1.5.dp,
////                            color = customWhite7,
////                            shape = RoundedCornerShape(12.dp)
////                        )
////                        .background(customWhite0)
////                ) {
////
////                }
////            }
////            item {
////                Box(
////                    modifier = Modifier
////                        .height(240.dp)
////                        .width(290.dp)
////                        .clip(RoundedCornerShape(12.dp))
////                        .border(
////                            width = 1.5.dp,
////                            color = customWhite7,
////                            shape = RoundedCornerShape(12.dp)
////                        )
////                        .background(customWhite1)
////                ) {
////
////                }
////            }
////            item {
////                Box(
////                    modifier = Modifier
////                        .height(240.dp)
////                        .width(290.dp)
////                        .clip(RoundedCornerShape(12.dp))
////                        .border(
////                            width = 1.5.dp,
////                            color = customWhite7,
////                            shape = RoundedCornerShape(12.dp)
////                        )
////                        .background(customWhite2)
////                ) {
////
////                }
//            }
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
    Post(
        post = PostData()
    )
}



