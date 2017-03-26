package javierrodriguez94.rasp_api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {

    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imagen = (ImageView) findViewById(R.id.imageView);
        Intent a = getIntent();


        String base = a.getStringExtra("temp");

        if (base != null){

            URL url = null;
            try {
                url = new URL("http://192.168.1.110/image");
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imagen.setImageBitmap(bmp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
