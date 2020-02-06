package py.com.thundersoda.samplestudio;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;

public class FilterActivity extends Activity {
    EditText filterBox;
    ListView sampleList;
    String currentElement;
    JSONArray responseArray = new JSONArray();
    //Donde 'responseArray' sería la Respuesta a un Endpoint que hayamos consumido.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_view);

        filterBox = findViewById(R.id.filterBox);
        sampleList = findViewById(R.id.sampleList);

        //Avoid Exception

        /*
            Toda esta sección más abajo se puede realizar desde el método OnPostExecute()
            Donde originalmente primero se obtiene la respuesta y el Array deseado (responseArray)

            De no ser requerido el ordenamiento de elementos por algún campo específico
            utilizamos 'responseArray' en el filtro de búsqueda.

            Caso contrario obtenemos el 'responseArray' y lo ordenamos con el método 'Collections.sort()' (Ver SortActivity)
            y usamos el nuevo Array 'sortedList' para el filtro.
        */


        filterBox.setEnabled(false);
        filterBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                JSONArray jsonArray = new JSONArray();
                //Removemos los espacios antes y despues del String con la función 'trim()'
                String search = filterBox.getText().toString().trim();
                // responseArray = Lista no ordenada
                // sortedList = Lista Ordenada
                // Cambiar estos dentro del bucle for, dependiendo si es requerida o no el orden alfabético, etc.

                if(search.length() > 0) {
                    for (int i = 0; i < responseArray.length(); i++) {
                        try {
                            currentElement = responseArray.getJSONObject(i).getString("name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(currentElement.toLowerCase().contains(search.toLowerCase())) {
                            try {
                                jsonArray.put(responseArray.get(i));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    // yourAdapter = new YourAdapter... (context, R.layout..., jsonArray);
                    // sampleList.setAdapter(yourAdapter);
                } else {
                    // yourAdapter = new YourAdapter... (context, R.layout..., sortedList/resposeArray);
                    // sampleList.setAdapter(yourAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
