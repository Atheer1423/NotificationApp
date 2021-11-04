package com.example.notificationapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var ed:EditText
    lateinit var bt:Button
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"

    lateinit var builder:Notification.Builder
//    val intent = Intent(this, NotificationActivity::class.java)
//    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    ed = findViewById(R.id.ed)
    bt = findViewById(R.id.bt)

    bt.setOnClickListener {
        var Mynotification = ed.text.toString()
        ed.text.clear()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_baseline_speaker_notes_24)
                .setContentTitle("New Notification")
                .setContentText(Mynotification)
        } else {
            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_baseline_speaker_notes_24)
                .setContentTitle("New Notification")
                .setContentText(Mynotification)
        }
        notificationManager.notify(1234, builder.build())

    }

    }
}
