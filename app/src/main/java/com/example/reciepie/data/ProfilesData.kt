package com.example.reciepie.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.reciepie.R


/**
 * A data class to present the information shown on the card
 */
data class CardData(
    @DrawableRes val profilePictureId: Int,
    @StringRes val userName: Int,
    @StringRes val bioInfo: Int,
    @StringRes val descriptionInfo: Int
)

val profiles = listOf(
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Available,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_8, R.string.Hireable,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_9, R.string.Available,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Hireable,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_7, R.string.Available,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Hireable,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_6, R.string.Available,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Available,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Available,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Hireable,R.string.Description),
    CardData(R.drawable.nguyai, R.string.Profile_name_5, R.string.Available,R.string.Description),

)