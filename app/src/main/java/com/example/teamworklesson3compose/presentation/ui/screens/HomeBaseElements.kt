package com.example.teamworklesson3compose.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ShapeDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.domain.entities.ResultTitan
import com.example.teamworklesson3compose.presentation.ui.theme.Black_transparent
import com.example.teamworklesson3compose.presentation.ui.theme.Blue
import com.example.teamworklesson3compose.presentation.ui.theme.DarkBlue
import com.example.teamworklesson3compose.presentation.ui.theme.DarkBlue2

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
                Text(
                    text = stringResource(R.string.welcome_back),
                    color = Gray,
                    fontSize = 12.sp,
                    onTextLayout = {

                    })
                Text(
                    text = stringResource(R.string.hajime_isayama),
                    color = White,
                    fontSize = 16.sp,
                    onTextLayout = {

                    }
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
fun SearchAccount(
    onSearchClick: (name: String) -> Unit = {},
    any: Any?,

    ) {

    var text by remember {
        mutableStateOf("")
    }

    Card(modifier = Modifier) {
        TextField(value = text,
            onValueChange = { text = it },
            label = { Text("search", onTextLayout = {}) },
            textStyle = TextStyle(color = Color.Red),
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Black),
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .clickable {
                            onSearchClick(text)
                        }
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search",
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
                ),
                color = White,
                onTextLayout = {
                }
            )
            Spacer(modifier = Modifier.width(160.dp))
            Text(
                text = stringResource(
                    id = R.string.see_all
                ), color = White,
                onTextLayout = {
                }
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
                modifier = Modifier.size(180.dp, 200.dp),
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
                    color = White, onTextLayout = {

                    }
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
                    text = titans.name, color = White, fontSize = 16.sp, onTextLayout = {

                    }
                )
                Text(
                    text = titans.allegiance, color = White, fontSize = 18.sp, onTextLayout = {

                    }
                )
            }
        }
    }
}

@Composable
fun TheBestCharacter(modifier: Modifier) {
    Text(
        text = stringResource(R.string.the_characters),
        fontSize = 20.sp,
        color = White,
        onTextLayout = {

        })
}

@Composable
fun LazyColumCharacterItem(modifier: Modifier = Modifier, characters: Character) {
    Card(modifier = Modifier.background(DarkBlue)) {
        Box(
            modifier = modifier
                .background(DarkBlue)
                .padding(12.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(DarkBlue2)
                .fillMaxWidth()
                .height(112.dp)
        ) {
            Row(modifier = Modifier) {
                AsyncImage(
                    modifier = Modifier
                        .clip(shape = ShapeDefaults.ExtraLarge)
                        .size(140.dp)
                        .padding(10.dp),
                    model = characters.img,
                    contentDescription = stringResource(R.string.characters_aot),
                )

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Row(modifier = Modifier) {
                        Text(
                            text = characters.name,
                            fontSize = 14.sp,
                            color = White,
                            maxLines = 1, onTextLayout = {

                            }
                        )
                        Spacer(modifier = Modifier.width(40.dp))
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_rating),
                            contentDescription = "",
                            tint = Yellow,
                        )
                        Text(text = characters.age,
                            fontSize = 16.sp,
                            maxLines = 1,
                            color = White,
                            onTextLayout = {

                            })

                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.calendar_icon),
                            contentDescription = "calendar icon"
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier.width(80.dp),
                            text = characters.height,
                            color = White,
                            fontSize = 16.sp,
                            maxLines = 1, onTextLayout = {

                            }
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.dollar_icon),
                            contentDescription = stringResource(R.string.dollars_icon)
                        )
                        Text(
                            text = characters.status,
                            color = White,
                            fontSize = 16.sp, onTextLayout = {

                            }
                        )
                        Spacer(modifier = Modifier.width(40.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.location_icon),
                            contentDescription = stringResource(
                                R.string.location
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = characters.occupation,
                            color = White,
                            fontSize = 16.sp,
                            onTextLayout = {

                            })
                    }
                }
            }
        }
    }
}
