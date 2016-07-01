package com.example.andrewy.bigbrother;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by andrewy on 7/1/16.
 * refer : http://blog.csdn.net/jueblog/article/details/12691855
 *        http://www.cnblogs.com/trinea/archive/2012/11/09/2763182.html, broad cast
 */
public class NetworkConnectionListener extends BroadcastReceiver {
    NetworkInfo.State wifiState = null;
    NetworkInfo.State mobileState = null;
    public static final String ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        if (ACTION.equals(intent.getAction())) {

            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (activeNetwork != null) { // connected to the internet
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                }
            } else {
                // not connected to the internet
                Toast.makeText(context, "No network connection", Toast.LENGTH_SHORT).show();
            }
        }

        List<String> result = Utils.getSystemPhotoList(context );
        for (int i = 0; i < result.size(); i++) {

            System.out.println(result.get(i));
        }

    }
}
