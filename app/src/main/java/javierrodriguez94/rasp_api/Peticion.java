package javierrodriguez94.rasp_api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by javi on 28/3/17.
 */

public class Peticion {
    private RequestQueue queue;
    private StringRequest request;
    private String peticion;
    private Activity activity;
    private Class destiny;
    private Context context;
    private String url;
    public ImageLoader mImageLoader;
    public NetworkImageView mNetworkImageView;

    public Peticion (Context context, Activity activity, Class destiny, String peticion){
        this.peticion = peticion;
        this.activity = activity;
        this.destiny = destiny;
        this.context = context;
        System.out.print(getIp());
        queue = Volley.newRequestQueue(activity);
        url = "http://" + getIp() + peticion;
    }

    public Peticion (Context context, NetworkImageView mNetworkImageView){

        this.context = context;
        this.mNetworkImageView = mNetworkImageView;
    }

    public void send(){



        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplicationContext(), response.substring(0, 500), Toast.LENGTH_SHORT).show();
                if ( destiny != null ){
                    Intent activityChangeIntent = new Intent(activity, destiny);
                    activityChangeIntent.putExtra("response", response);
                    activity.startActivity(activityChangeIntent);
                }else{
                    //TODO: Devolver error o lanzar excepcion para controlar cuando no se cambia de activty
                }
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if ( destiny != null ){
                    Intent activityChangeIntent = new Intent(activity, destiny);
                    activityChangeIntent.putExtra("response", "");
                    activity.startActivity(activityChangeIntent);
                }else{
                    //TODO: Devolver error o lanzar excepcion para controlar cuando no se cambia de activty
                }
            }
        };
        request = new StringRequest(Request.Method.GET, url, listener, errorListener);
        queue.add(request);
    }

    public ImageLoader getImage(){


        //imagen = (ImageView) findViewById(R.id.imageView);
        //Intent a = getIntent();


        mImageLoader = CustomVolleyRequestQueue.getInstance(context)
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        final String url = "http://" + getIp() + context.getResources().getString(R.string.route_image);
        mImageLoader.get(url, ImageLoader.getImageListener(mNetworkImageView,
                R.mipmap.rasp_api, android.R.drawable
                        .ic_dialog_alert));
        mNetworkImageView.setImageUrl(url, mImageLoader);
        return mImageLoader;
    }

    public String getIp(){
        SharedPreferences preferences = context.getSharedPreferences("settings", context.MODE_PRIVATE);
        //Toast.makeText(this.getApplicationContext(), preferences.getString("server_address", null), Toast.LENGTH_SHORT).show();
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("server_address", null);
    }
}
