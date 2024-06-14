package com.advancelibrary.ui.theme.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.advancelibrary.R

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(27.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomBarItem(
            icon = R.drawable.ic_home,
            contentDescription = "Home",
            iconSize = 32.dp // Increased icon size
        ) {
            // TODO: Handle Home click
        }
        BottomBarItem(
            icon = R.drawable.ic_library,
            contentDescription = "Library",
            iconSize = 32.dp // Increased icon size
        ) {
            // TODO: Handle Library click
        }
        BottomBarItem(
            icon = R.drawable.ic_search,
            contentDescription = "Search",
            iconSize = 32.dp // Increased icon size
        ) {
            // TODO: Handle Search click
        }
        BottomBarItem(
            icon = R.drawable.ic_profile,
            contentDescription = "Profile",
            iconSize = 32.dp // Increased icon size
        ) {
            // TODO: Handle Profile click
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar()
}
