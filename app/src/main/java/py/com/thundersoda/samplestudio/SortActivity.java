package py.com.thundersoda.samplestudio;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortActivity extends Activity {
    JSONArray responseArray = new JSONArray();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        //Ordenar Lista de Elementos
        JSONArray sortedList = new JSONArray();
        ArrayList<JSONObject> values = new ArrayList<>();

        try {
            for(int i = 0; i < responseArray.length(); i++) {
                values.add(responseArray.getJSONObject(i));
            }

            Collections.sort(values, new Comparator<JSONObject>() {
                //Como ejemplo tomamos un posible elemento existente en el JSON, en este caso el campo "name"
                private static final String KEY_NAME = "name";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String valueA = new String();
                    String valueB = new String();

                    try {
                        valueA = (String) a.get(KEY_NAME);
                        valueB = (String) b.get(KEY_NAME);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return valueA.compareToIgnoreCase(valueB);
                }
            });

//            Agregamos los objetos al arreglo 'sortedList' El cual se puede pasar como parámetro al Adapter

//            for (int x = 0; x < responseArray.length(); x++) {
//                sortedList.put(values.get(x));
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
