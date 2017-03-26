package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PairActivity extends AppCompatActivity {

    Button pairBtn;
    EditText serverAddressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair);

        pairBtn = (Button) findViewById(R.id.pairBtn);
        serverAddressField = (EditText) findViewById(R.id.serverAddressField);

        pairBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setAddress(serverAddressField.getText().toString());
                Intent activityChangeIntent = new Intent(PairActivity.this, MainActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                PairActivity.this.startActivity(activityChangeIntent);
            }
        });
    }


    public void setAddress(String address) {
        SharedPreferences preferences =
                getSharedPreferences("preferences", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("server_address", address);
        editor.commit();
    }

}


