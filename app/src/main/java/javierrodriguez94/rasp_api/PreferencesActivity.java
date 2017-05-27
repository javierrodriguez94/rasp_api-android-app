package javierrodriguez94.rasp_api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class PreferencesActivity extends PreferenceActivity {

    public final static String IP = "server_address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferences);
        addPreferencesFromResource(R.xml.settings);
    }

    public static String getIp(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(IP, "0.0.0.0");
    }
    public static void setIp(Context context, String ip) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(IP, ip);
        editor.commit();
    }
}
