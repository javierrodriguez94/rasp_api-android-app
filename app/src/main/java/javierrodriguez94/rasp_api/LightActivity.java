package javierrodriguez94.rasp_api;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LightActivity extends AppCompatActivity {
    String value;
    private RequestQueue queue;
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);


        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    value = "0";
                } else {
                    value = "1";
                }


                queue = Volley.newRequestQueue(LightActivity.this);
                String url = "http://" + getIp() + "/gpio/"+value;

                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), response.substring(0, 500), Toast.LENGTH_SHORT).show();


                    }
                };
                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();

                    }
                };
                request = new StringRequest(Request.Method.GET, url, listener, errorListener);
                queue.add(request);
            }
        });
    }

    public String getIp(){
        SharedPreferences preferences =
                getSharedPreferences("preferences", this.MODE_PRIVATE);
        //Toast.makeText(this.getApplicationContext(), preferences.getString("server_address", null), Toast.LENGTH_SHORT).show();
        return preferences.getString("server_address", null);
    }
}
