package py.com.thundersoda.samplestudio.mvc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import py.com.thundersoda.samplestudio.R;
import py.com.thundersoda.samplestudio.mvc.adapter.UserAdapter;
import py.com.thundersoda.samplestudio.mvc.model.User;
import py.com.thundersoda.samplestudio.webservice.ConnectWS;

public class ModelMain extends AppCompatActivity {
    JSONArray jsonArray;
    ListView listViewData;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_main);
        context = ModelMain.this;

        listViewData = findViewById(R.id.listViewData);

        new dataList().execute();
    }

    @SuppressLint("StaticFieldLeak")
    public class dataList extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            try {
                jsonArray = ConnectWS.getData();
                Log.e("schoolList", jsonArray.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (JSONException e) {
                e.printStackTrace();
                result = "ok";
            }
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String success) {
            super.onPostExecute(success);

            String json = jsonArray.toString();
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            ArrayList<User> data = gson.fromJson(json, listType);

            listViewData.setAdapter(new UserAdapter(context, R.layout.data_item_list, data));
            listViewData.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        }
    }
}
