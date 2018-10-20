package saurabh.test.com.proficiencyexercise.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by saurabha on 18/10/18.
 */
public class NetworkConnection {

    /**
     * Wifi.
     */
    public static final int TYPE_WIFI = 1;
    /**
     * Mobile.
     */
    public static final int TYPE_MOBILE = 2;
    /**
     * Not connected.
     */
    public static final int TYPE_NOT_CONNECTED = 0;
    /**
     * Network status of wifi and mobile.
     */
    public static final int NETWORK_STATUS_NOT_CONNECTED = 0;

    /**
     * Retrieving network connectivity status.
     *
     * @param context Context.
     * @return status of network connection.
     */
    public static int getConnectivityStatus(Context context) {
        if (context != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (null != activeNetwork) {
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        return TYPE_WIFI;
                    }

                    if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        return TYPE_MOBILE;
                    }
                }
            }
        }
        return TYPE_NOT_CONNECTED;
    }
}
