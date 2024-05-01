package com.example.teamworklesson3compose.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.presentation.data.remote.models.persons.Group
import com.example.teamworklesson3compose.presentation.data.remote.models.persons.Relative
import com.example.teamworklesson3compose.presentation.data.remote.models.persons.Result
import com.example.teamworklesson3compose.presentation.ui.theme.Black30
import com.example.teamworklesson3compose.presentation.ui.theme.TeamWorkLesson3ComposeTheme

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier, isPreview: Boolean = false, character: Result
) = with(character) {
    Box(
        modifier = modifier.border(
            width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(10.dp)
        ),
    ) {
        if (!isPreview) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                model = ImageRequest.Builder(LocalContext.current).data(img)
                    .crossfade(enable = true).build(),
                contentDescription = stringResource(
                    R.string.character_image_content_description, name
                ),
                contentScale = ContentScale.FillBounds,
            )
        } else {
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = stringResource(
                    R.string.character_image_content_description, name
                )
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Black30)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = name,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterItem() {
    TeamWorkLesson3ComposeTheme {
        CharacterItem(
            modifier = Modifier.wrapContentSize(), isPreview = true, character = Result(
                id = 1,
                name = "Armin Arlelt",
                img = "",
                age = 1,
                alias = listOf(""),
                birthplace = "",
                episodes = listOf(""),
                gender = "",
                groups = listOf(Group(name = "", subGroups = listOf(""))),
                height = "",
                occupation = "",
                relatives = listOf(Relative("", listOf(""))),
                residence = "",
                roles = listOf(""),
                species = listOf(""),
                status = ""
            )
        )
    }
}