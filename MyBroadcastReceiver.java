package com.example.sahith.wake1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

/**
 * Created by sahith on 12-01-2019.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        Notification noti = new Notification.Builder(context)
                .setContentTitle("ON")
                .setContentText("YOU'VE SETUP THE ALARM")
                .setSmallIcon(R.mipmap.ic_launcher).build();
        NotificationManager manager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        noti.flags|=Notification.FLAG_AUTO_CANCEL;
        manager.notify(0,noti);
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone r = RingtoneManager.getRingtone(context,notification);
        r.play();
    }
}
