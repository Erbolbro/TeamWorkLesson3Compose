package com.example.teamworklesson3compose.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.presentation.data.model.Characters
import com.example.teamworklesson3compose.presentation.data.model.Titans
import com.example.teamworklesson3compose.presentation.data.remote.models.titans.Info
import com.example.teamworklesson3compose.presentation.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.presentation.data.remote.models.titans.TitansResponse
import com.example.teamworklesson3compose.presentation.ui.theme.Black_transparent
import com.example.teamworklesson3compose.presentation.ui.theme.Blue
import com.example.teamworklesson3compose.presentation.ui.theme.DarkBlue
import com.example.teamworklesson3compose.presentation.ui.theme.DarkBlue2
import com.example.teamworklesson3compose.presentation.ui.theme.Gray40
import com.example.teamworklesson3compose.presentation.ui.theme.TeamWorkLesson3ComposeTheme
import com.example.teamworklesson3compose.presentation.ui.viewmodels.AOTViewModel
import com.example.teamworklesson3compose.presentation.utils.UiState

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: AOTViewModel = hiltViewModel()
) {
    val gridState = rememberLazyGridState()
    val characters by viewModel.charactersState.observeAsState()
    val titans by viewModel.titansState.observeAsState()

    Column {
        UserInfo()
        SearchAccount()
        SuggestionsDesign()
        LazyRow(modifier = Modifier) {
            when (titans) {
                is UiState.Error -> {
                    Log.e("titans", "CharactersScreen: ${(titans as UiState.Error).message}", )
                }

                is UiState.Loading -> {

                }

                is UiState.Success -> {
                    (titans as UiState.Success<List<ResultTitan>>).data?.let {
                        items(it) { item ->
                            LazyRowTitanItem(titans = item)
                        }
                    }
                }

                null -> {

                }
            }
        }
    }

//    characters?.let { uiState ->
//        when (uiState) {
//            is UiState.Error -> {Log.e("error",uiState.message ?: "Unknown",uiState.throwable)}
//            UiState.Loading -> {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    CircularProgressIndicator(color = Black)
//                }
//            }
//
//            is UiState.Success -> {
//                LazyHorizontalGrid(
//                    modifier = Modifier,
//                    state = gridState,
//                    rows = GridCells.Fixed(10)
//                ) {
//                    uiState.data?.let {
//                        items(it) { character ->
//                            CharacterItem(character = character)
//                        }
//                    }
//                }
//            }
//        }
//    }

}

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
                    text = stringResource(R.string.hajime_isayama), color = White, fontSize = 16.sp
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
        TextField(value = text,
            onValueChange = { text = it },
            label = { Text("search") },
            textStyle = TextStyle(color = Color.Red),
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Black),
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
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
            })
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
                ), color = White
            )
            Spacer(modifier = Modifier.width(160.dp))
            Text(
                text = stringResource(
                    id = R.string.see_all
                ), color = White
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
fun LazyRowTitanItem(modifier: Modifier = Modifier, titans: ResultTitan) {
    Card(modifier = Modifier) {
        Box(
            modifier = modifier
        ) {
            AsyncImage(
                modifier = Modifier.size(180.dp,200.dp),
                model = titans.img,
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
                    .background(Black_transparent)
                    .padding(2.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(start = 4.dp),
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
                    tint = Yellow
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 8.dp)
                    .wrapContentSize()
                    .align(Alignment.BottomStart),
            ) {
                Text(
                    text = titans.name, color = Black, fontSize = 16.sp
                )
                Text(
                    text = titans.allegiance, color = Black, fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun LazyColumTitanItem(modifier: Modifier = Modifier, characters: Characters) {
    Box(
        modifier = modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DarkBlue2)
            .fillMaxWidth()
    ) {
        Row {
            Image(
                modifier = modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.eron),
                contentDescription = stringResource(R.string.welcome_back),
                contentScale = ContentScale.Crop,
            )

            Column {
                Text(
                    modifier = Modifier.padding(top = 12.dp),
                    text = "Eren Jaeger",
                    fontSize = 18.sp,
                    color = White
                )
                Row {
                    Icon(
                        modifier = Modifier.padding(top = 12.dp),
                        painter = painterResource(R.drawable.calendar),
                        contentDescription = "",
                        tint = DarkGray
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "19",
                        fontSize = 13.sp,
                        color = White
                    )
                }
                Row {
                    Icon(
                        modifier = Modifier.padding(top = 12.dp),
                        painter = painterResource(id = R.drawable.dollar),
                        contentDescription = "",
                        tint = DarkGray
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "15 m (Titan form)",
                        fontSize = 13.sp,
                        color = White
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "/day",
                        fontSize = 13.sp,
                        color = Gray
                    )
                    Icon(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .padding(start = 26.dp),
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = DarkGray
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "Jaeger family",
                        fontSize = 13.sp,
                        color = Gray
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Gray40)
            ) {
                Text(modifier = Modifier, text = "Alive", color = White)
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(id = R.drawable.ic_rating),
                    contentDescription = "",
                    tint = Yellow
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
//                LazyRowTitanItem(
//                    titans = TitansResponse(Info(0,0,0,0), listOf(ResultTitan(abilities = "", allegiance = "", currentInheritor = "", formerInheritors = listOf(""), height = "",)))
//                )
                LazyColumTitanItem(
                    characters = Characters(
                        "Eren Jaeger",
                        19,
                        "SDK",
                        "15 m (Titan form)",
                        "Jaeger family",
                        "Alive"
                    )
                )
            }
        }
    }
}