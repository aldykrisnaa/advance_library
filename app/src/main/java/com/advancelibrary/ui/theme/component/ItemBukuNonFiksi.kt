package com.advancelibrary.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.advancelibrary.R
import com.advancelibrary.ui.theme.Abuabu
import com.advancelibrary.ui.theme.AdvanceLibraryTheme

@Composable
fun ItemBukuNonFiksi(
    modifier: Modifier = Modifier,
    title: String,
    writer: String,
    desc: String,
    image: Int,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .height(200.dp)
                    .width(170.dp)
            )
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color.White,
                fontSize = 16.sp,
                letterSpacing = 0.2.sp,
                lineHeight = 18.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = writer,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Abuabu,
                fontSize = 16.sp,
                letterSpacing = 0.2.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 14.dp)
            )

            Column {
                Text(
                    text = "Deskripsi Buku",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = Color.White,
                    fontSize = 14.sp,
                    letterSpacing = 0.2.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .padding(start = 22.dp)
                )
                Text(
                    text = desc,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    letterSpacing = 0.2.sp,
                    lineHeight = 18.sp
                )
                Text(
                    text = "Sinopsis Buku",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = Color.White,
                    fontSize = 14.sp,
                    letterSpacing = 0.2.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .padding(start = 22.dp)

                )

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    AdvanceLibraryTheme {
        ItemBukuNonFiksi(
            title = "Stop Diabetes, Stop Obat",
            writer = "Dr.Hans Tandra",
            desc = "“Educated (Terdidik): Sebuah Memoar” merupakan buku autobiografi yang menceritakan kisah hidup Tara Westover. Cerita yang disuguhkan dalam buku ini akan menginspirasi pembaca.\n",
            image = R.drawable.stopdiabetstopobat
        )
    }
}
