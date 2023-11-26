package com.example.budgetbitesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Bite(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)