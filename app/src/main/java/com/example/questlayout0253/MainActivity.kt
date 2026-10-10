package com.example.questlayout0253

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun StudentListPreview() {
    QuestLayout0253Theme {
        StudentListScreen()
    }
}
