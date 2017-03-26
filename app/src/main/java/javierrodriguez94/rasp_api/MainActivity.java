package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    private RequestQueue queue;
    private StringRequest request;
    private TextView textView;
    private String result;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_settings:
                Intent intent = new Intent(this, PreferencesActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView = (TextView) findViewById(R.id.temp);

        b1 = (ImageButton) findViewById(R.id.tempBtn);
        b2 = (ImageButton) findViewById(R.id.photoBtn);
        b4 = (ImageButton) findViewById(R.id.lightBtn);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://" + getIp() + "/get_temp";

                //url = "http://www.uam.es";
                //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), response.substring(0, 500), Toast.LENGTH_SHORT).show();

                        result =response;

                    }
                };
                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();

                        result = "Se produjo un error.";
                    }
                };
                request = new StringRequest(Request.Method.GET, url, listener, errorListener);
                queue.add(request);
                Intent activityChangeIntent = new Intent(MainActivity.this, TempActivity.class);
                activityChangeIntent.putExtra("temp", result);
                // currentContext.startActivity(activityChangeIntent);

                MainActivity.this.startActivity(activityChangeIntent);
            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://" + getIp() + "/image";

                //url = "http://www.uam.es";
                //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), response.substring(0, 500), Toast.LENGTH_SHORT).show();

                        result =response;

                    }
                };
                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();

                        result = "Se produjo un error.";
                    }
                };
                request = new StringRequest(Request.Method.GET, url, listener, errorListener);
                queue.add(request);
                Intent activityChangeIntent = new Intent(MainActivity.this, ImageActivity.class);
                activityChangeIntent.putExtra("temp", result);
                // currentContext.startActivity(activityChangeIntent);

                MainActivity.this.startActivity(activityChangeIntent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent activityChangeIntent = new Intent(MainActivity.this, LightActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                MainActivity.this.startActivity(activityChangeIntent);
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
