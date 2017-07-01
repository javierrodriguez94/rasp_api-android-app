package javierrodriguez94.rasp_api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class PreferencesActivity extends PreferenceActivity {

    public final static String IP = "server_address";
    public final static String TOKEN = "server_token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferences);
        addPreferencesFromResource(R.xml.settings);
    }

    public static String getIp(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(IP, null);
    }
    public static void setIp(Context context, String ip) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(IP, ip);
        editor.commit();
    }
    public static String getToken(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(TOKEN, null);
    }
    public static void setToken(Context context, String token) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TOKEN, token);
        editor.commit();
    }
}
