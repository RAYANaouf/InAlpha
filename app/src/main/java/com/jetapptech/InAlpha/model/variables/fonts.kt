package com.example.daracademy.model.variables

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.jetapptech.InAlpha.R

val permanentMarker = FontFamily(
    Font(R.font.permanent_marker_regular , FontWeight.Normal)
)

val firaSansFamily = FontFamily(
    Font(R.font.playpen_sans_light       , FontWeight.Light),
    Font(R.font.playpen_sans_bold        , FontWeight.Bold),
    Font(R.font.playpen_sans_extra_light , FontWeight.ExtraLight),
    Font(R.font.playpen_sans_extra_bold  , FontWeight.ExtraBold),
    Font(R.font.playpen_sans_medium      , FontWeight.Medium),
    Font(R.font.playpen_sans_thin        , FontWeight.Thin),
    Font(R.font.playpen_sans_semi_bold   , FontWeight.SemiBold),
    Font(R.font.playpen_sans_regular     , FontWeight.Normal)
)


val nunitoFamily = FontFamily(
    Font(R.font.nunito_bold                      , FontWeight.Bold                         ),
    Font(R.font.nunito_extra_bold                , FontWeight.ExtraBold                    ),
    Font(R.font.nunito_semi_bold                 , FontWeight.SemiBold                     ),
    Font(R.font.nunito_extra_light               , FontWeight.ExtraLight                   ),
    Font(R.font.nunito_light                     , FontWeight.Light                        ),
    Font(R.font.nunito_medium                    , FontWeight.Medium                       ),
    Font(R.font.nunito_regular                   , FontWeight.Normal                       ),


    //italic ones
    Font(R.font.nunito_italic                    , FontWeight.Bold       , FontStyle.Italic),
    Font(R.font.nunito_extra_bold_italic         , FontWeight.ExtraBold  , FontStyle.Italic),
    Font(R.font.nunito_semi_bold_italic          , FontWeight.SemiBold   , FontStyle.Italic),
    Font(R.font.nunito_extra_light_italic        , FontWeight.ExtraLight , FontStyle.Italic),
    Font(R.font.nunito_light                     , FontWeight.Light      , FontStyle.Italic),
    Font(R.font.nunito_medium                    , FontWeight.Medium     , FontStyle.Italic),
    Font(R.font.nunito_regular                   , FontWeight.Normal     , FontStyle.Italic),
)

