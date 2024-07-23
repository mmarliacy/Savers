package com.example.affirmation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.assertion.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

//FontFamily
val cormorantGaramond = GoogleFont("Cormorant Garamond")

val fontLobsterFamily = FontFamily(
    Font(
        googleFont = cormorantGaramond,
        fontProvider = provider,
        weight = FontWeight.W300,
        style = FontStyle.Normal,

    ), Font(
        googleFont = cormorantGaramond,
        fontProvider = provider,
        weight = FontWeight.Bold,
        style = FontStyle.Normal,

    )
)
val upProtestRevolution = GoogleFont("Protest Revolution")
val protestRevolution = FontFamily(
    Font(R.font.protestrevolution, FontWeight.Thin)
)

val lato = FontFamily(
    Font(R.font.latothin, FontWeight.Thin),
    Font(R.font.latolight, FontWeight.Light),
    Font(R.font.latoregular, FontWeight.Normal),
    Font(R.font.latolightitalic, FontWeight.W400),
    Font(R.font.latoitalic, FontWeight.W300),
    Font(R.font.latobolditalic, FontWeight.W200),
    Font(R.font.latobold, FontWeight.Bold),
    Font(R.font.latoblackitalic, FontWeight.W100),
    Font(R.font.latoblack, FontWeight.Black)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = fontLobsterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 60.sp,
        lineHeight = 30.sp,
        letterSpacing = 1.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontLobsterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 40.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = fontLobsterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 50.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fontLobsterFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp
    ),

    bodySmall = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp,
        lineHeight = 25.sp,
        letterSpacing = 1.5.sp
    ),
    labelLarge = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Thin,
        fontSize = 30.sp,
        lineHeight = 25.sp,
        letterSpacing = 1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 15.sp,
        letterSpacing = 1.sp
    ),
    labelSmall = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 15.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    )
)

