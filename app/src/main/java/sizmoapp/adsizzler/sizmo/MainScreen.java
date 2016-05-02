package sizmoapp.adsizzler.sizmo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainScreen extends Slider {
    LinearLayout menu;
    private GridView gridView;
    private GridViewAdapter customGridAdapter;
    JSONObject jsonobject;
    JSONArray jsonarray;
    GridView listview;
    ListViewAdapter adapter;
    GridViewAdapter ad;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String BACK = "back";
    static String COUNTRY = "country";
    static String POPULATION = "population";
    static String ICON = "icon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        menu = (LinearLayout)findViewById(R.id.slider);

        menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                drawer.toggleLeftDrawer();

            }
        });


        new DownloadJSON().execute();

    }
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainScreen.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Loading Categories");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://carsizzler.com:8080/demo/v1.0/home");

            try {

                System.out.println("GOT "+ jsonobject.toString());
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("categories");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("id", jsonobject.getInt("id")+"");
                    map.put("name", jsonobject.getString("name"));
                    map.put("logo", jsonobject.getString("logo"));
                    map.put("headerImg", jsonobject.getString("headerImg"));

                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
                System.out.println("Map data is:: "+arraylist.toString());
            } catch (Exception e) {
                System.out.print("Error "+e);
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml
            listview = (GridView)findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(MainScreen.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
