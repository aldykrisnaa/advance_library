package com.advancelibrary.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.advancelibrary.R
import com.advancelibrary.ui.theme.Kuning
import com.advancelibrary.ui.theme.component.ScheduleDateText
import com.advancelibrary.ui.theme.component.ScheduleNameText
import com.advancelibrary.ui.theme.component.ScheduleTimeText
import com.advancelibrary.ui.theme.component.TimePickDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import androidx.compose.material.icons.outlined.AlarmAdd
import androidx.compose.material.icons.outlined.ArrowBackIos
import com.advancelibrary.alarm.cancelNotification
import com.advancelibrary.alarm.scheduleNotification
import com.advancelibrary.ui.theme.putih

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    val context = LocalContext.current

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    var scheduleText by remember { mutableStateOf("") }
    var scheduleDate by remember { mutableStateOf("") }
    var scheduleTime by rememberSaveable { mutableStateOf("") }

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePicker by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Library Alarm")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIos,
                            contentDescription = " Back Icon",
                            tint = Kuning
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val selectedDate = Calendar.getInstance().apply {
                                timeInMillis = datePickerState.selectedDateMillis!!
                            }
                            scheduleDate = formatter.format(selectedDate.time)
                            showDatePicker = false
                        }
                    ) {
                        Text("Oke")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }
                    ) { Text("Cancel") }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

        if (showTimePicker) {
            TimePickDialog(
                onDismissRequest = { showTimePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                            showTimePicker = false
                        }
                    ) {
                        Text("Oke")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showTimePicker = false }
                    ) {
                        Text("Cancel")
                    }
                }
            ) {
                TimePicker(state = timePickerState)
            }
        }
        Surface(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Remind Your Reading Time, Set With Us",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                ScheduleNameText(
                    value = scheduleText,
                    onValueChange = { if (it.length <= 25) scheduleText = it },
                    label = "Set Your Reading Plan"
                )
                ScheduleDateText(
                    value = scheduleDate,
                    onValueChange = { scheduleDate = it },
                    label = "Set Your Date Reading",
                    icon = Icons.Default.DateRange,
                    onIconClick = {
                        showDatePicker = true
                    }
                )
                ScheduleTimeText(
                    value = scheduleTime,
                    label = "Set Your Time Reading",
                    icon = Icons.Outlined.AlarmAdd,
                    onValueChange = { scheduleTime = it },
                    onIconClick = { showTimePicker = true })
                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            if (scheduleText.isBlank() || scheduleDate.isBlank() || scheduleTime.isBlank()) {
                                Toast.makeText(
                                    context,
                                    "Semua field wajib diisi!",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            } else {
                                scheduleNotification(
                                    context,
                                    timePickerState,
                                    datePickerState,
                                    scheduleText
                                )
                                scheduleText = ""
                                scheduleDate = ""
                                scheduleTime = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Kuning),
                        shape = RoundedCornerShape(size = 6.dp),
                        modifier = modifier
                            .width(300.dp)
                            .height(50.dp)
                            .padding(5.dp)
                    ) {
                        Text(
                            "Simpan",
                            color = putih,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            cancelNotification(context)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        shape = RoundedCornerShape(size = 6.dp),
                        modifier = modifier
                            .width(300.dp)
                            .height(50.dp)
                            .padding(5.dp)
                    ) {
                        Text(
                            "Batalkan",
                            color = Color.Gray,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }
            }
        }
    }
}