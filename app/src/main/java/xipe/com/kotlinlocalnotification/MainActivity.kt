package xipe.com.kotlinlocalnotification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.NOTIFICATION_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.widget.Button


class MainActivity : AppCompatActivity() {

    lateinit var b1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.button) as Button
        b1.setOnClickListener {
            addNotification()
        }
    }

    private fun addNotification() {
        val builder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.img_cacl)
                .setContentTitle("Notifications Example")
                .setContentText("This is a test notification")
                .setOngoing(true)

        val notificationIntent = Intent(this, MainActivity::class.java)
        val contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(contentIntent)

        // Add as notification
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }
}
