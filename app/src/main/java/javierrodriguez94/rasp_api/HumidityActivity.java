package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HumidityActivity extends AppCompatActivity {

    TextView humiditytv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);
        humiditytv = (TextView) findViewById(R.id.humidity);

        Intent a = getIntent();
        String result = a.getStringExtra("response");

        if ( result.length() > 4 || result.length() <= 0 ) {
            humiditytv.setText("Error");
        }else{
            humiditytv.setText(result + "%");
        }
    }
}
