package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        button = findViewById(R.id.sentnotification);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("com.example.firstapplication",getString(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT);

                    Intent i = new Intent(NotificationActivity.this,List_Grid_Activity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this,1,i,PendingIntent.FLAG_ONE_SHOT);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
                    builder.setSmallIcon(R.drawable.ic_baseline_shopping_cart_24);
                    builder.setContentTitle("Urbanic Sale");
                    builder.setContentText("Sale on clothes upto 40% off.");
                    builder.setContentIntent(pendingIntent);
                    builder.setChannelId("com.example.firstapplication");

                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.notify(1,builder.build());
                }
            }
        });
    }
}