package sizmoapp.adsizzler.sizmo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SplashScreen extends AppCompatActivity {
    Animation mLoadAnimation;
    ImageView logo;
    HashMap<String,String> contacts=new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo=(ImageView)findViewById(R.id.splashImage);
        mLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_out);
        mLoadAnimation.setDuration(3000);
        logo.setVisibility(View.INVISIBLE);
        logo.startAnimation(mLoadAnimation);
        mLoadAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                Intent inn = new Intent(SplashScreen.this,Introduction.class);
                startActivity(inn);
                finish();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ContactsReader extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {//Contacts
            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
            while (phones.moveToNext())
            {
                contacts.put(phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

            }
            Toast.makeText(getApplication(), contacts.toString(), Toast.LENGTH_LONG).show();
            phones.close();
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            Toast.makeText(getApplicationContext(),contacts.toString(),Toast.LENGTH_LONG).show();
        }
    }
    private class SMSReader extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {//Contacts
            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
            while (phones.moveToNext())
            {
                contacts.put(phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

            }
            Toast.makeText(getApplication(), contacts.toString(), Toast.LENGTH_LONG).show();
            phones.close();
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            Toast.makeText(getApplicationContext(),contacts.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
