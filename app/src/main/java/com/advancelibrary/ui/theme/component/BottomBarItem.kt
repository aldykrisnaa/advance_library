package com.advancelibrary.ui.theme.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.advancelibrary.R

@Composable
fun BottomBarItem(
    icon: Int,
    contentDescription: String?,
    iconSize: Dp = 24.dp,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(iconSize)
            .clickable(onClick = onClick)
    )
}

@Preview(showBackground = true)
@Composable
fun BottomBarItemPreview() {
    BottomBarItem(
        icon = R.drawable.ic_home, // replace with your drawable resource
        contentDescription = "Home",
        iconSize = 32.dp // setting icon size for preview
    ) {
        // TODO: Handle Home click
    }
}