package com.example.teamworklesson3compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.presentation.data.model.Titans
import com.example.teamworklesson3compose.ui.theme.Blue
import com.example.teamworklesson3compose.ui.theme.DarkBlue
import com.example.teamworklesson3compose.ui.theme.TeamWorkLesson3ComposeTheme

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
            contentDescription = "Bell",
            tint = Blue
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}


@Composable
fun SearchAccount() {
    var text by remember {
        mutableStateOf("")
    }
    Card(modifier = Modifier) {
        TextField(
            value = text, onValueChange = { text = it },
            label = { Text("search") },
            textStyle = TextStyle(color = Color.Red),
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Black),
            modifier = Modifier.fillMaxWidth(), leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search",
                    Modifier.size(20.dp)
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "filter",
                )
            }
        )
    }
}


@Composable
fun SuggestionsDesign(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(
                    id = R.string.suggestions
                ),
                color = White
            )
            Spacer(modifier = Modifier.width(160.dp))
            Text(
                text = stringResource(
                    id = R.string.see_all
                ),
                color = White
            )
            Icon(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = R.drawable.see_all_arrow),
                tint = White,
                contentDescription = stringResource(R.string.see_all_desc)
            )
        }
    }
}

@Composable
fun LazyRowTitanItem(modifier: Modifier = Modifier, titans: Titans) {
    Card(modifier = Modifier) {
        Box(
            modifier = modifier
        ) {
            AsyncImage(
                modifier = Modifier,
                model = ImageRequest.Builder(LocalContext.current).data(titans.image)
                    .crossfade(true).build(),
                contentDescription = stringResource(R.string.image_aot),
                placeholder = painterResource(
                    id = R.drawable.place_holder,
                ),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(Color(Black.value))
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp),
                    text = titans.height,
                    fontSize = 10.sp,
                    color = White
                )
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .padding(),
                    painter = painterResource(id = R.drawable.ic_rating),
                    contentDescription = "",
                    tint = Yellow,

                    )
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 8.dp)
                    .wrapContentSize()
                    .align(Alignment.BottomStart),
            ) {
                Text(
                    text = titans.name,
                    color = Black,
                    fontSize = 14.sp
                )
                Text(
                    text = titans.abilities,
                    color = Black,
                    fontSize = 10.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun GreetingPreview() {
    TeamWorkLesson3ComposeTheme {
        Box(modifier = Modifier.background(DarkBlue)) {
            Column {
                UserInfo(modifier = Modifier.fillMaxWidth())
                SearchAccount()
                SuggestionsDesign(modifier = Modifier.fillMaxWidth())
                LazyRowTitanItem(
                    titans = Titans("eren", "sdka", "20", "atackTitan")
                )
            }
        }
    }
}