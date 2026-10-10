package com.example.questlayout0253

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

data class StudentUiModel(
    @StringRes val nameRes: Int,
    @StringRes val phoneRes: Int,
    @StringRes val addressRes: Int,
    @ColorRes val backgroundRes: Int,
    @ColorRes val nameColorRes: Int,
    @ColorRes val phoneColorRes: Int,
    @ColorRes val addressColorRes: Int,
    val useScriptName: Boolean = false
)
