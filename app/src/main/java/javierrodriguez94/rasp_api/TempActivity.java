package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity {

    TextView temptv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        temptv = (TextView) findViewById(R.id.temp);

        Intent a = getIntent();
        String result = a.getStringExtra("response");

        if ( result.length() > 4 || result.length() <= 0 ) {
            temptv.setText("Error");
        }else{
            temptv.setText(result + "º");
        }
        Float temp = Float.parseFloat(result);
        if (temp > 23 ){
            temptv.setTextColor(Color.RED);
        }else if (temp > 18) {
            temptv.setTextColor(Color.YELLOW);
        }else {
            temptv.setTextColor(Color.BLUE);
        }
    }
}
