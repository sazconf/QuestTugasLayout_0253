package com.example.questlayout0253

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StudentCard(student: StudentUiModel) {
    val nameStyle = if (student.useScriptName) FontFamily.Cursive else FontFamily.Default

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.card_height))
            .semantics {
                contentDescription = stringResource(
                    R.string.student_card_description,
                    stringResource(student.nameRes)
                )
            },
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        colors = CardDefaults.cardColors(containerColor = colorResource(student.backgroundRes))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.card_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.card_content_spacing))
        ) {
            UmyLogo()
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(student.nameRes),
                    color = colorResource(student.nameColorRes),
                    fontFamily = nameStyle,
                    fontSize = dimensionResource(R.dimen.student_name_size).value.sp,
                    fontWeight = if (student.useScriptName) FontWeight.Normal else FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = stringResource(student.phoneRes),
                    color = colorResource(student.phoneColorRes),
                    fontSize = dimensionResource(R.dimen.student_detail_size).value.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = stringResource(student.addressRes),
                    color = colorResource(student.addressColorRes),
                    fontSize = dimensionResource(R.dimen.student_detail_size).value.sp,
                    maxLines = 1
                )
            }
            UmyLogo()
        }
    }
}

@Composable
private fun UmyLogo(@DrawableRes logoRes: Int = R.drawable.umy_seal) {
    Image(
        painter = painterResource(logoRes),
        contentDescription = stringResource(R.string.umy_logo_description),
        modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
    )
}
