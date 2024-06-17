package com.advancelibrary.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.advancelibrary.R
import com.advancelibrary.dummy.DummyData
import com.advancelibrary.ui.theme.AdvanceLibraryTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.advancelibrary.model.BookNonFiksi
import com.advancelibrary.ui.theme.Abuabu
import com.advancelibrary.ui.theme.Kuning
import com.advancelibrary.ui.theme.putih

@Composable
fun DetailBookNonFiksi(
    modifier: Modifier = Modifier,
    navController: NavController,
    detailbooksnonfiksiId: Int?
) {
    val newItemNonFiksilist = DummyData.listBukuNonFiksi.filter { itemnonfiksi ->
        itemnonfiksi.id == detailbooksnonfiksiId
    }

    Column(
        modifier = modifier
    ) {
        DetailBookNonFiksiContent(
            newItemNonFiksilist = newItemNonFiksilist,
            onBackClick = { navController.popBackStack() }
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailBookNonFiksiContent(
    modifier: Modifier = Modifier,
    newItemNonFiksilist : List<BookNonFiksi>,
    onBackClick: () -> Unit = {},

    ){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIos,
                            contentDescription = "Icon",
                            tint = Kuning,
                            modifier = modifier
                                .clickable { onBackClick() }
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource( newItemNonFiksilist[0].image),
                        contentDescription = "",
                        modifier = Modifier
                            .height(200.dp)
                            .width(170.dp)
                    )
                    Text(
                        text = newItemNonFiksilist[0].title,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = Color.Black,
                        fontSize = 16.sp,
                        letterSpacing = 0.2.sp,
                        lineHeight = 18.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = newItemNonFiksilist[0].writer,
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
                            text = "Deskripsi Buku (${newItemNonFiksilist[0].desc})",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = Color.Black,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Justify,
                            letterSpacing = 0.2.sp,
                            lineHeight = 18.sp
                        )

                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Kuning),
                            shape = RoundedCornerShape(size = 6.dp),
                            modifier = modifier
                                .width(300.dp)
                                .height(50.dp)
                                .padding(5.dp)
                        ) {
                            Text(
                                "Tambahkan ke Library",
                                color = putih,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold))
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetailBookNonFiksiContentPreview() {
    AdvanceLibraryTheme {
        DetailBookNonFiksiContent( newItemNonFiksilist = DummyData.listBukuNonFiksi)
    }
}
