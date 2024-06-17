package com.advancelibrary.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.advancelibrary.model.BookFiksi
import com.advancelibrary.ui.theme.AdvanceLibraryTheme
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.advancelibrary.ui.theme.Kuning

@Composable
fun DetailBookFiksi(
    modifier: Modifier = Modifier,
    navController: NavController,
    detailbooksfiksiId: Int?
) {
    val newItemFiksilist = DummyData.listBukuFiksi.filter { itemfiksi ->
        itemfiksi.id == detailbooksfiksiId
    }

    Column(
        modifier = modifier
    ) {
        DetailBookFiksiContent(
            newItemFiksilist = newItemFiksilist,
            onBackClick = { navController.popBackStack() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailBookFiksiContent(
    modifier: Modifier = Modifier,
    newItemFiksilist: List<BookFiksi>,
    onBackClick: () -> Unit = {},
) {
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
                if (newItemFiksilist.isNotEmpty()) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(newItemFiksilist[0].image),
                            contentDescription = "",
                            modifier = Modifier
                                .height(200.dp)
                                .width(170.dp)
                        )
                        Text(
                            text = newItemFiksilist[0].title,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color.Black,
                            fontSize = 16.sp,
                            letterSpacing = 0.2.sp,
                            lineHeight = 18.sp,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = newItemFiksilist[0].writer,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color.Gray,
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
                                color = Color.Black,
                                fontSize = 14.sp,
                                letterSpacing = 0.2.sp,
                                lineHeight = 18.sp,
                                modifier = Modifier
                                    .padding(start = 22.dp)
                            )
                            Text(
                                text = newItemFiksilist[0].desc,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color.Black,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Justify,
                                letterSpacing = 0.2.sp,
                                lineHeight = 18.sp
                            )
                            Text(
                                text = "Sinopsis Buku",
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Color.Black,
                                fontSize = 14.sp,
                                letterSpacing = 0.2.sp,
                                lineHeight = 18.sp,
                                modifier = Modifier
                                    .padding(start = 22.dp)
                            )
                            Text(
                                text = newItemFiksilist[0].sinopsis,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color.Black,
                                textAlign = TextAlign.Justify,
                                fontSize = 14.sp,
                                letterSpacing = 0.2.sp,
                                lineHeight = 18.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))


                    }
                }
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetailBookFiksiContentPreview() {
    AdvanceLibraryTheme {
        DetailBookFiksiContent(newItemFiksilist = DummyData.listBukuFiksi)
    }
}