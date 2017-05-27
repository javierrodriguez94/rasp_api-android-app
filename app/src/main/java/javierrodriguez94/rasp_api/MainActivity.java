package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b6;
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
        b3 = (ImageButton) findViewById(R.id.humidityBtn);
        b4 = (ImageButton) findViewById(R.id.lightBtn);
        b6 = (ImageButton) findViewById(R.id.statsBtn);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Peticion(getApplicationContext(), MainActivity.this, TempActivity.class, getString(R.string.route_temp)).send();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //new Peticion(getApplicationContext(), MainActivity.this, ImageActivity.class, getString(R.string.route_image)).send();
                Intent activityChangeIntent = new Intent( MainActivity.this, ImageActivity.class);
                //activityChangeIntent.putExtra("response", "");
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Peticion(getApplicationContext(), MainActivity.this, HumidityActivity.class, getString(R.string.route_humidity)).send();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(MainActivity.this, LightActivity.class);
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });




    }


}
