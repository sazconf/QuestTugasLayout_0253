package com.example.questlayout0253

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
internal fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.header_top_spacing)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.screen_title),
            color = colorResource(R.color.text_dark),
            fontSize = dimensionResource(R.dimen.header_title_size).value.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.university_subtitle),
            color = colorResource(R.color.text_dark),
            fontSize = dimensionResource(R.dimen.header_subtitle_size).value.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.header_bottom_spacing)))
    }
}
