package com.advancelibrary.ui.theme.screen

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.advancelibrary.R
import com.advancelibrary.navigation.Screen
import com.advancelibrary.ui.theme.component.ButtonMasuk

@Composable
fun LoginScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    // Load saved email and password
    LaunchedEffect(Unit) {
        email = TextFieldValue(sharedPreferences.getString("email", "") ?: "")
        password = TextFieldValue(sharedPreferences.getString("password", "") ?: "")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Daftarkan Akun Anda",
            textAlign = TextAlign.Start,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            modifier = Modifier.padding(bottom = 3.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Bersiaplah untuk terhubung, belajar dan menginspirasi di dalamnya. Temukan peluang baru. Mari kita mulai!",
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier
                .width(380.dp)
                .height(75.dp)
                .padding()
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Alamat Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp),
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Kata Sandi") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Lupa kata sandi?",
            color = Color.Blue,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            modifier = Modifier
                .align(Alignment.End)
                .clickable { /* Handle forgot password click */ }
                .padding(bottom = 16.dp)
        )

        Column(
            modifier = Modifier.padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)
        ) {
            ButtonMasuk(text = "Masuk", onClick = {
                saveLoginDetails(sharedPreferences, email.text, password.text)
                navController.navigate(Screen.Beranda.route) {
                    popUpTo(Screen.Login.route) {
                        inclusive = true
                    }
                }
            })
        }
    }
}

private fun saveLoginDetails(sharedPreferences: SharedPreferences, email: String, password: String) {
    with(sharedPreferences.edit()) {
        putString("email", email)
        putString("password", password)
        apply()
    }
}



