package com.example.questlayout0253

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

data class StudentUiModel(
    @param:StringRes val nameRes: Int,
    @param:StringRes val phoneRes: Int,
    @param:StringRes val addressRes: Int,
    @param:ColorRes val backgroundRes: Int,
    @param:ColorRes val nameColorRes: Int,
    @param:ColorRes val phoneColorRes: Int,
    @param:ColorRes val addressColorRes: Int,
    val useScriptName: Boolean = false
)
