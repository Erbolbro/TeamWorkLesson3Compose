package com.example.teamworklesson3compose.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamworklesson3compose.presentation.data.model.Titans
import com.example.teamworklesson3compose.screens.SearchAccount
import com.example.teamworklesson3compose.screens.SecondTitanItem
import com.example.teamworklesson3compose.screens.UserInfo
import com.example.teamworklesson3compose.ui.theme.TeamWorkLesson3ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamWorkLesson3ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    UserInfo()
//                    SearchAccount()
                    SecondTitanItem(titans = Titans("","","",""))
                }
            }
        }
    }
}