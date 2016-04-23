package sizmoapp.adsizzler.sizmo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.navdrawer.SimpleSideDrawer;
public class Slider extends AppCompatActivity {
    SimpleSideDrawer drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawer = new SimpleSideDrawer(this);
        drawer.setLeftBehindContentView(R.layout.activity_slider);
    }

}
