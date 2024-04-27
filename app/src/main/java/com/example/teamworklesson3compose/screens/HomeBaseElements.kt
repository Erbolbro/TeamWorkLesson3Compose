package com.example.teamworklesson3compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.ui.theme.Blue
import com.example.teamworklesson3compose.ui.theme.TeamWorkLesson3ComposeTheme
import com.example.teamworklesson3compose.ui.theme.White

@Composable
fun UserInfo(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.isayama),
                contentDescription = stringResource(R.string.isayama),
                contentScale = ContentScale.Crop,
            )
            Column {
                Text(text = stringResource(R.string.welcome_back), color = Gray, fontSize = 12.sp)
                Text(
                    text = stringResource(R.string.hajime_isayama),
                    color = White,
                    fontSize = 16.sp
                )

            }
        }
        Icon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(40.dp),
            painter = painterResource(id = R.drawable.bell),
            contentDescription = "Bell", tint = Blue
        )

    }
}

@Composable
fun SearchAccount(modifier: Modifier = Modifier) {
        Row(modifier = modifier) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.search),
                contentDescription = stringResource(R.string.search)
            )

            Text(
                text = stringResource(R.string.serch),
                color = Gray, fontSize = 16.sp
            )

            Icon(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .size(30.dp),
                painter = painterResource(id = R.drawable.filter),
                contentDescription = stringResource(R.string.filter)
            )
        }
    }

@Preview()
@Composable
fun GreetingPreview() {
    TeamWorkLesson3ComposeTheme {
        UserInfo(modifier = Modifier.fillMaxWidth())
        SearchAccount(modifier = Modifier.fillMaxWidth())
    }

}