package com.example.andrewy.bigbrother;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andrewy on 7/8/16.
 *
 *   Reference : http://stackoverflow.com/questions/32886177/smsmessage-createfrompdu-with-extra-parameter-format
 *             http://blog.csdn.net/mad1989/article/details/22426415
 */
public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        SmsMessage [] messages = null;
        String strMessage = "";

        if (myBundle != null)
        {
            Object [] pdus = (Object[]) myBundle.get("pdus");

            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++)
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = myBundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                else {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                strMessage += " : ";
                strMessage += messages[i].getMessageBody();
                strMessage += "\n";
            }

            Log.e("SMS", strMessage);
            Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
        }
    }

}
