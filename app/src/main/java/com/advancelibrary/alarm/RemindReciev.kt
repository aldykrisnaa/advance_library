package com.advancelibrary.alarm

import android.content.BroadcastReceiver

import android.content.Context
import android.content.Intent
import com.advancelibrary.alarm.KeyNotif.RMNDR_NOTI_TITLE_KEY

class RemindReciev :BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val scheduleNotificationService = context?.let { RemaindNotif(it) }
        val title: String = intent?.getStringExtra(RMNDR_NOTI_TITLE_KEY) ?: return
        scheduleNotificationService?.sendRemindNotif(title)
    }
}
