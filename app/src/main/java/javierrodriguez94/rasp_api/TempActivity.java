package javierrodriguez94.rasp_api;

import android.content.Intent;
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
        temptv.setText(a.getStringExtra("temp")+"º");
    }
}
