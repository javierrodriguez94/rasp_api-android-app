package javierrodriguez94.rasp_api;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferences);
        addPreferencesFromResource(R.xml.settings);
    }



//    public void setBoardSize(String str, int size) {
//        SharedPreferences preferences =
//                PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt(BOARD_SIZE, size);
//        editor.commit();
//    }
}
