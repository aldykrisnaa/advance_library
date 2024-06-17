package com.advancelibrary.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.advancelibrary.R
import com.advancelibrary.dummy.DummyData
import com.advancelibrary.model.ItemFiksi
import com.advancelibrary.model.ItemNonFiksi
import com.advancelibrary.navigation.Screen
import com.advancelibrary.ui.theme.component.ItemBerandaFiksi
import com.advancelibrary.ui.theme.component.ItemBerandaNonFiksi

@Composable
fun BerandaScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    listitemfiksi: List<ItemFiksi> = DummyData.listItemFiksi,
    listitemnonfiksi: List<ItemNonFiksi> = DummyData.listItemNonFiksi,
) {
    Column(modifier = modifier
        .padding(8.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Kamu mau baca apa hari ini?",
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            color = Color.Black,
            fontSize = 20.sp,
            letterSpacing = 0.2.sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(start = 8.dp)
        )

        Text(
            text = "Fiksi",
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            color = Color.Black,
            fontSize = 18.sp,
            letterSpacing = 0.2.sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(start = 20.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = modifier
        ) {
            items(listitemfiksi, key = { it.id }) {
                ItemBerandaFiksi(itemfiksi = it) { itemfiksiId ->
                    navController.navigate(Screen.DetailBookFiksi.route + "/$itemfiksiId")
                }
            }
        }

        Text(
            text = "NonFiksi",
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            color = Color.Black,
            fontSize = 18.sp,
            letterSpacing = 0.2.sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(start = 20.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = modifier
        ) {
            items(listitemnonfiksi, key = { it.id }) {
                ItemBerandaNonFiksi(itemnonfiksi = it) { itemnonfiksiId ->
                    navController.navigate(Screen.DetailBookNonFiksi.route + "/$itemnonfiksiId")
                }
            }
        }
    }
}