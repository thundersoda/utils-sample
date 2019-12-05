package py.com.thundersoda.samplestudio.floating_button;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionMenu;

import py.com.thundersoda.samplestudio.R;

public class FloatingButonMenu extends Activity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_button_menu);

        context = FloatingButonMenu.this;

        FloatingActionMenu contact_menu = findViewById(R.id.contact_menu);
        //Add Button programatically to menu
        //contact_menu.addMenuButton(button);
        //where 'button' is a FloatingActionButton

        //Library deprecated IF you have androidx!!!
    }
}
