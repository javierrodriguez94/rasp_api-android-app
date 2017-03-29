package javierrodriguez94.rasp_api;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.NetworkImageView;

public class ImageActivity extends AppCompatActivity {


    private NetworkImageView mNetworkImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);



    }
    protected void onStart(){
        super.onStart();

        mNetworkImageView = (NetworkImageView) findViewById(R.id
                .networkImageView);

        Peticion peticion = new Peticion(getApplicationContext(), mNetworkImageView);

        peticion.getImage();

    }
}
