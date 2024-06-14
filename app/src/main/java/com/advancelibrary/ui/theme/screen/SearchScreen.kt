package com.advancelibrary.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.advancelibrary.R

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.searchbar),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 360.dp, height = 60.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = "Trending",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Divider()
        Row(modifier = Modifier.padding(end = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 32.dp, top = 16.dp)
                    .size(16.dp)
            )
            Column(modifier = Modifier.padding(start = 4.dp)) {}
            Text(
                text = "Kesehatan",
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        Divider()
        Row(modifier = Modifier.padding(end = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 32.dp, top = 16.dp)
                    .size(16.dp)
            )
            Column(modifier = Modifier.padding(start = 4.dp)) {}
            Text(
                text = "Educated",
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSearchScreen() {
    SearchScreen()
}