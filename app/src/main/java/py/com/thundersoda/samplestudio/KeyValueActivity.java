package py.com.thundersoda.samplestudio;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyValueActivity extends Activity {
    JSONArray jsonArray = new JSONArray();
    JSONObject temp = new JSONObject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_value);

        //Agregar un objeto a un arreglo.
        //jsonArray = Array dentro de la Respuesta a un Enpoint específico
        //temp = Objeto dentro de la Respuesta a un Enpoint específico
        //En el método setAdapter() pasar como parámetro el arreglo modificado. 'jsonArray' en este caso
        try {
            if(jsonArray.length() > 0) {
                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    object.put("objectName", temp);
                }
            // Usamos el arreglo con el nuevo objeto agregado a cada Object de la Lista.
            // yourListView.setAdapter(...  ..., jsonArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
