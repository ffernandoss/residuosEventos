package com.example.myapplication.Calendario

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat


fun scheduleReminder(context: Context, reminder: Reminder) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, ReminderReceiver::class.java).apply {
        putExtra("reminder_id", reminder.id)
    }
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        reminder.id,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    alarmManager.set(AlarmManager.RTC_WAKEUP, reminder.date, pendingIntent)
}

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val reminderId = intent.getIntExtra("reminder_id", -1)
        val reminder = getReminderById(reminderId) // Implementa esta función

        val iconId = context.resources.getIdentifier("notification_icon", "drawable", context.packageName)

        val notification = NotificationCompat.Builder(context, "reminder_channel")
            .setContentTitle("Recordatorio de recolección")
            .setContentText(reminder.description)
            .setSmallIcon(iconId)
            .setAutoCancel(true)
            .build()

        val notificationManager = ContextCompat.getSystemService(context, NotificationManager::class.java)!!

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                notificationManager.notify(reminderId, notification)
            } else {
                // Solicitar el permiso POST_NOTIFICATIONS (no se puede hacer desde un BroadcastReceiver)
            }
        } else {
            notificationManager.notify(reminderId, notification)
        }
    }
}

// Implementa esta función para obtener el recordatorio por su ID
private fun getReminderById(reminderId: Int): Reminder {
    // Lógica para obtener el recordatorio de tu base de datos o lista
    TODO("Not yet implemented")
}
fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Canal de recordatorios"
        val descriptionText = "Canal para notificaciones de recolección"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("reminder_channel", name, importance).apply {
            description = descriptionText
        }
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}
