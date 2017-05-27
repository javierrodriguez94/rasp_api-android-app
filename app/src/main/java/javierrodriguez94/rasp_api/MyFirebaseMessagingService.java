package javierrodriguez94.rasp_api;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.os.Vibrator;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.R.attr.data;

/**
 * Created by javi on 20/05/17.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("t");
        mBuilder.setContentText("m");
        mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText("m2"));
        mBuilder.setTicker("ms");

        mBuilder.setDefaults(Notification.DEFAULT_LIGHTS);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);


        //Intent myIntent = new Intent(this, MyActivity.class);
        //PendingIntent intent2 = PendingIntent.getBroadcast(this, 1, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //mBuilder.setContentIntent(intent2);

        notificationManager.notify(1, mBuilder.build());
       // Uri sound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
       // builder.setSound(sound);




//        // Get instance of Vibrator from current Context
//        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//
//// Start without a delay
//// Vibrate for 100 milliseconds
//// Sleep for 1000 milliseconds
//        long[] pattern = {0, 100, 1000};
//
//// The '0' here means to repeat indefinitely
//// '0' is actually the index at which the pattern keeps repeating from (the start)
//// To repeat the pattern from any other point, you could increase the index, e.g. '1'
//        v.vibrate(pattern, 0);

        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
    }
}