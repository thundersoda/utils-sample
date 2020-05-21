package py.com.thundersoda.samplestudio;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;

import androidx.core.app.ActivityCompat;

import py.com.thundersoda.samplestudio.floating_button.FloatingButonMenu;
import py.com.thundersoda.samplestudio.location.LocationMain;
import py.com.thundersoda.samplestudio.location_updates.LocationUpdateMain;
import py.com.thundersoda.samplestudio.mvc.ModelMain;
import py.com.thundersoda.samplestudio.youtube.YouTubeActivity;

public class MainActivity extends Activity {
    Context context;
    Button mvc_btn, location_btn,location_update_btn, youtube_btn, floating_btn, preference_btn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean hasMarangatuPin = true;
    Boolean bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyLocationPermission(this);

        context = MainActivity.this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mvc_btn = findViewById(R.id.mvc_btn);
        youtube_btn = findViewById(R.id.youtube_btn);
        floating_btn = findViewById(R.id.floating_btn);
        location_btn = findViewById(R.id.location_btn);
        location_update_btn = findViewById(R.id.location_update_btn);
        preference_btn = findViewById(R.id.preference_btn);
        btnMetodo();
        Log.e("hasMarangatuPin", String.valueOf(hasMarangatuPin));

        editor = sharedPreferences.edit();
        editor.putBoolean("bmp", hasMarangatuPin);
        editor.apply();
    }

    public static void verifyLocationPermission(Activity activity) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
    }
    public void btnMetodo() {
        mvc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ModelMain.class);
                startActivity(intent);
            }
        });

        location_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LocationUpdateMain.class);
                startActivity(intent);
            }
        });

        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LocationMain.class);
                startActivity(intent);
            }
        });

        youtube_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YouTubeActivity.class);
                startActivity(intent);
            }
        });

        floating_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloatingButonMenu.class);
                startActivity(intent);
            }
        });

        preference_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SharedPreferenceActivity.class);
                startActivity(intent);
            }
        });
    }
}
