package javierrodriguez94.rasp_api;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

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
                    value = "on";
                } else {
                    value = "off";
                }
                new Peticion(getApplicationContext(), LightActivity.this, null, getString(R.string.route_light) + value).send();
            }
        });
    }
}
