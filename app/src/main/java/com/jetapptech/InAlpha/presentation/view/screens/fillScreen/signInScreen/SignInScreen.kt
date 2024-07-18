package com.jetapptech.InAlpha.presentation.view.screens.fillScreen.signInScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.screens.common.textFields.AlphaTextField
import com.example.bigsam.model.data.`object`.NormalTextStyles
import com.jetapptech.InAlpha.R
import com.jetapptech.InAlpha.presentation.view.material.alphaButton.AlphaButton
import com.jetapptech.InAlpha.presentation.ui.theme.background_00

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier
        .background(background_00)
) {

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(0.5f)
        ){

        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
//                .background(Color.Cyan)
        ) {
            Image(
                painter = painterResource(id = R.drawable.alpha),
                contentDescription = null ,
                contentScale = ContentScale.Inside,
                modifier = Modifier
            )
        }

        Box(
            modifier = Modifier
                .weight(0.5f)
        ){

        }

        Column(
//            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
//                .background(Color.Green)
        ) {

            AlphaTextField(
                text = "",
                onValueChange = {

                },
                hint = "enter the email",
                hintStyle = NormalTextStyles.TextStyleSZ6,
                textFieldStyle = NormalTextStyles.TextStyleSZ6,
                modifier = Modifier
                    .padding(start = 26.dp , end = 26.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )

            AlphaTextField(
                text = "",
                onValueChange = {

                },
                hint = "password",
                hintStyle = NormalTextStyles.TextStyleSZ6,
                textFieldStyle = NormalTextStyles.TextStyleSZ6,
                modifier = Modifier
                    .padding(start = 26.dp , end = 26.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(55.dp)
                    .padding(start = 26.dp , end = 26.dp)
            ) {

                Text(
                    text = "Forget the password"
                )

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                AlphaButton(
                    txt = "Done"
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth()
                    .padding(start = 26.dp , end = 26.dp)
            ) {

                Text(
                    text = "Create new account"
                )

            }

        }






    }

}


@Preview
@Composable
fun SignInScreen_preview() {

}