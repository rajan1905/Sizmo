package sizmoapp.adsizzler.sizmo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainScreen extends Slider {
    LinearLayout menu;
    private GridView gridView;
    private GridViewAdapter customGridAdapter;

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

        gridView = (GridView) findViewById(R.id.gridViewPhotGallery);

    }

}
