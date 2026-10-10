package com.example.questlayout0253

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding

@Composable
internal fun Footer() {
    Text(
        text = stringResource(R.string.copyright),
        color = colorResource(R.color.text_dark),
        fontSize = dimensionResource(R.dimen.footer_text_size).value.sp,
        modifier = Modifier.padding(
            top = dimensionResource(R.dimen.footer_top_spacing),
            bottom = dimensionResource(R.dimen.footer_bottom_spacing)
        )
    )
}
