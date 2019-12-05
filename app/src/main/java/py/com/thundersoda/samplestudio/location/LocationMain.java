package py.com.thundersoda.samplestudio.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import py.com.thundersoda.samplestudio.R;

public class LocationMain extends Activity {
    Context context;
    FusedLocationProviderClient fusedLocationProviderClient;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_main);

        context = LocationMain.this;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);

        fusedLocationProviderClient.getLastLocation()
            .addOnSuccessListener(LocationMain.this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null) {
                        Toast.makeText(
                                context,
                                "Lat:" + location.getLatitude() + " " + "Lon:" + location.getLongitude(),
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
    }
}
