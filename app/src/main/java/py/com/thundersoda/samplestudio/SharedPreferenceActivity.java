package py.com.thundersoda.samplestudio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SharedPreferenceActivity extends Activity {
    TextView textView;
    EditText edt;
    Button save, delete;
    String valor;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    Boolean marangatuPin;
    Boolean bmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preference);
        context = SharedPreferenceActivity.this;

        textView = findViewById(R.id.textView);
        edt = findViewById(R.id.edt);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);

//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        marangatuPin = sharedPreferences.getBoolean("valor", true);
//        Log.e("value", String.valueOf(marangatuPin));

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        bmp = sharedPreferences.getBoolean("bmp", Boolean.parseBoolean(""));
        Log.e("bmp", String.valueOf(bmp));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bmp) {
                    editor = sharedPreferences.edit();
                    editor.putBoolean("bmp", false);
                    editor.apply();
                    //Log.e("true", String.valueOf(bmp));
                    Intent i = new Intent(context, MainActivity.class);
                    startActivity(i);
                } else {
                    //Log.e("false", String.valueOf(bmp));
                    editor = sharedPreferences.edit();
                    editor.putBoolean("bmp", true);
                    editor.apply();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });
    }
}
