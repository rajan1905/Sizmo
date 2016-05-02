package sizmoapp.adsizzler.sizmo;

/**
 * Created by rajan on 23/4/16.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONfunctions {

    public static JSONObject getJSONfromURL(String url) {
        InputStream is = null;

        JSONObject jArray = null;
        StringBuilder builder = new StringBuilder();
        // Download JSON data from URL
        try {
            HttpClient httpclient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE0NjA3NDUwMDAsImlzcyI6Ind3dy5hZHNpenpsZXIuY29tIiwiYXVkIjoiQU5EUk9JRCIsInN1YiI6ImFua3VzaDIwMDU4QGdtYWlsLmNvbSJ9.nm6ibadoFhDMYcj6Ip5zM0bMGD9LZikWa2GS_RcsgD-ZY7RprFTKRNpS_wps5bljswlQU7pocpXIb1UJ0LjYMg");
            httpGet.setHeader("Content-Type", "application/json");
//
            HttpResponse response = httpclient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e( "log_tag","Failed to download file");
            }
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }

        // Convert response to string


        try {

            jArray = new JSONObject(builder.toString());
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return jArray;
    }
}
