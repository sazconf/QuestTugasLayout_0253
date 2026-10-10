package com.example.questlayout0253

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.questlayout0253.ui.theme.QuestLayout0253Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = getColor(R.color.screen_background)
        window.navigationBarColor = getColor(R.color.screen_background)
        setContent {
            QuestLayout0253Theme {
                StudentListScreen()
            }
        }
    }
}

@Composable
fun StudentListScreen() {
    val students = studentUiModels()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(colorResource(R.color.screen_background))
            .padding(horizontal = dimensionResource(R.dimen.screen_horizontal_padding)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.card_spacing))
        ) {
            items(students) { student ->
                StudentCard(student = student)
            }
        }
        Footer()
    }
}

@Composable
private fun Header() {
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

@Composable
fun StudentCard(student: StudentUiModel) {
    val nameStyle = if (student.useScriptName) {
        FontFamily.Cursive
    } else {
        FontFamily.Default
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.card_height)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(student.backgroundRes)
        )
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

@Composable
private fun Footer() {
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

private fun studentUiModels() = listOf(
    StudentUiModel(
        nameRes = R.string.student_bambang_name,
        phoneRes = R.string.student_bambang_phone,
        addressRes = R.string.student_bambang_address,
        backgroundRes = R.color.card_bambang,
        nameColorRes = R.color.text_white,
        phoneColorRes = R.color.text_yellow,
        addressColorRes = R.color.text_yellow,
        useScriptName = true
    ),
    StudentUiModel(
        nameRes = R.string.student_gibran_name,
        phoneRes = R.string.student_gibran_phone,
        addressRes = R.string.student_gibran_address,
        backgroundRes = R.color.card_gibran,
        nameColorRes = R.color.text_white,
        phoneColorRes = R.color.text_cyan,
        addressColorRes = R.color.text_yellow
    ),
    StudentUiModel(
        nameRes = R.string.student_zhila_name,
        phoneRes = R.string.student_zhila_phone,
        addressRes = R.string.student_zhila_address,
        backgroundRes = R.color.card_zhila,
        nameColorRes = R.color.text_white,
        phoneColorRes = R.color.text_cyan,
        addressColorRes = R.color.text_white
    ),
    StudentUiModel(
        nameRes = R.string.student_ahmad_name,
        phoneRes = R.string.student_ahmad_phone,
        addressRes = R.string.student_ahmad_address,
        backgroundRes = R.color.card_ahmad,
        nameColorRes = R.color.text_white,
        phoneColorRes = R.color.text_cyan,
        addressColorRes = R.color.text_white
    )
)

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun StudentListPreview() {
    QuestLayout0253Theme {
        StudentListScreen()
    }
}
