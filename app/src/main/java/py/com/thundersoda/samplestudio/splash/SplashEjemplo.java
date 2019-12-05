package py.com.thundersoda.samplestudio.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import py.com.thundersoda.samplestudio.MainActivity;
import py.com.thundersoda.samplestudio.R;

public class SplashEjemplo extends Activity {

    Timer timer;
    TimerTask task;
    Context context;
    TextView texto_splash;
    private static final long SPLASH_SCREEN_DELAY = 3000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_ejemplo);

        context = SplashEjemplo.this;
        texto_splash = findViewById(R.id.texto_splash);

        task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(context, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };
        timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
