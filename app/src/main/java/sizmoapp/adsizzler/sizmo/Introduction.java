package sizmoapp.adsizzler.sizmo;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Introduction extends AppCompatActivity {
    HashMap<String,String> contacts=new HashMap<String,String>();
   static LinearLayout skip1=null,skip2=null,skip3=null,forward1=null,forward2=null,forward3=null,ls1=null,ls2=null,ls3=null;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);




    }

    public void skip1(View v)
    {
        Intent skip1=new Intent(Introduction.this,MainScreen.class);
        startActivity(skip1);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_introduction, menu);
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


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
        public static class PlaceholderFragment extends Fragment{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView=null;
            System.out.println("Filer "+getArguments().getInt(ARG_SECTION_NUMBER));
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1){
            rootView = inflater.inflate(R.layout.intro1, container, false);
            skip1=(LinearLayout)rootView.findViewById(R.id.skip1);

            ls1=(LinearLayout)rootView.findViewById(R.id.ls1);
            forward1=(LinearLayout)rootView.findViewById(R.id.forward1);
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                rootView = inflater.inflate(R.layout.intro2, container, false);
                skip2=(LinearLayout)rootView.findViewById(R.id.skip2);
                ls2=(LinearLayout)rootView.findViewById(R.id.ls2);
                forward2=(LinearLayout)rootView.findViewById(R.id.forward2);
            }
            else{
            rootView=inflater.inflate(R.layout.intro3, container, false);
                skip3=(LinearLayout)rootView.findViewById(R.id.skip3);
                ls3=(LinearLayout)rootView.findViewById(R.id.ls3);
                forward3=(LinearLayout)rootView.findViewById(R.id.forward3);
            }
            return rootView;
        }



    }
}
