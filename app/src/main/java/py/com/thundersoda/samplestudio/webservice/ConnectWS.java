package py.com.thundersoda.samplestudio.webservice;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectWS {
    private static final int HTTP_time = 15 * 1000;
    private static String TAG = "ConnectionWS";
    private static String url_base = "http://www.json-generator.com/api/";

    private static String Request(String destination, String obj, String method) throws IOException {
        Log.e(TAG+" url",url_base + destination);

        OkHttpClient client = new OkHttpClient();
        OkHttpClient newClient = client.newBuilder()
                .connectTimeout(HTTP_time, TimeUnit.SECONDS)
                .readTimeout(HTTP_time, TimeUnit.SECONDS)
                .writeTimeout(HTTP_time, TimeUnit.SECONDS)
                .build();

        MediaType mediaType = MediaType.parse("application/json");
        Request request;
        if(method.equals("POST")) {
            RequestBody body = RequestBody.create(null, new byte[0]);
            if(obj != null)
                body = RequestBody.create(mediaType, obj);
            request = new Request.Builder()
                    .url(url_base + destination)
                    .post(body)
                    .addHeader("cache-control", "no-cache")
                    .build();
        }
        else if(method.equals("GET"))
            request = new Request.Builder()
                    .url(url_base + destination)
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .build();
        else
            request = new Request.Builder()
                    .url(url_base + destination)
                    .delete()
                    .addHeader("cache-control", "no-cache")
                    .build();

        Response response = newClient.newCall(request).execute();

        return response.body().string();
    }

    public static JSONArray getData() throws IOException, JSONException {
        String jsonResult = Request("json/get/ceuJtTOjDm?indent=2", null, "GET");
        return new JSONArray(jsonResult);
    }
}
