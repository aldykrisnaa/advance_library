package com.advancelibrary.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.advancelibrary.R
import com.advancelibrary.model.ItemFiksi
import com.advancelibrary.ui.theme.Abuabu
import com.advancelibrary.ui.theme.AdvanceLibraryTheme

@Composable
fun ItemBerandaFiksi(
    modifier: Modifier = Modifier,
    itemfiksi : ItemFiksi,
    onItemClicked: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .height(300.dp)
            .width(220.dp)

    ) {
        Column(
            modifier = modifier
                .clickable {
                    onItemClicked(itemfiksi.id)}
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id =  itemfiksi.image),
                contentDescription = "",
                modifier = Modifier
                    .height(180.dp)
                    .width(150.dp)
            )
            Text(
                text =  itemfiksi.title,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color.Black,
                fontSize = 14.sp,
                letterSpacing = 0.2.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text =  itemfiksi.writer,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Abuabu,
                fontSize = 13.sp,
                letterSpacing = 0.2.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun Preview() {
    AdvanceLibraryTheme {
        ItemBerandaFiksi(
            itemfiksi= ItemFiksi (
                1,
                title = "Educated (Terdidik): Sebuah Memoar",
                writer = "Tara Westover",
                image = R.drawable.educated_cov),
            onItemClicked = { itemfiksiId ->
                println("Mentor Id : $itemfiksiId")
            }
        )
    }
}