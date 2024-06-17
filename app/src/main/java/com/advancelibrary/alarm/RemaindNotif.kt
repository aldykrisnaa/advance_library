package com.advancelibrary.alarm

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.advancelibrary.R
import com.advancelibrary.alarm.KeyNotif.RMNDR_NOTI_CHNNL_ID
import com.advancelibrary.alarm.KeyNotif.RMNDR_NOTI_ID


class RemaindNotif (private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    fun sendRemindNotif(title: String?) {
        val notification = NotificationCompat.Builder(context, RMNDR_NOTI_CHNNL_ID)
            .setContentTitle(title)
            .setContentText(context.getString(R.string.app_name))
            .setSmallIcon(R.drawable.ic_big)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.ic_small
                )
            )
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(RMNDR_NOTI_ID, notification)
    }

}