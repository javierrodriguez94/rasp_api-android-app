package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class PairActivity extends AppCompatActivity {

    Button pairBtn;
    EditText serverAddressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair);
        String ip = PreferencesActivity.getIp(getApplicationContext());
        String token = PreferencesActivity.getToken(getApplicationContext());
        if(ip!=null && token != null){
            Intent activityChangeIntent = new Intent(PairActivity.this, MainActivity.class);
            // currentContext.startActivity(activityChangeIntent);
            PairActivity.this.startActivity(activityChangeIntent);
        }

        pairBtn = (Button) findViewById(R.id.pairBtn);
        serverAddressField = (EditText) findViewById(R.id.serverAddressField);

        pairBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //setAddress(serverAddressField.getText().toString());
                PreferencesActivity.setIp(getApplicationContext(), serverAddressField.getText().toString());
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        PreferencesActivity.setToken(getApplicationContext(), response);
                        Intent activityChangeIntent = new Intent(PairActivity.this, MainActivity.class);
                        // currentContext.startActivity(activityChangeIntent);
                        PairActivity.this.startActivity(activityChangeIntent);
                    }
                };

                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PairActivity.this, "Error al obtener token", Toast.LENGTH_SHORT).show();
                    }
                };

                new Peticion(getApplicationContext(), PairActivity.this, listener, errorListener, getString(R.string.route_pair), "POST").send();

            }
        });
    }


    public void setAddress(String address) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("server_addres", address);
        editor.commit();
    }

}


