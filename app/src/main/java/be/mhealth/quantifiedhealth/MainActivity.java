package be.mhealth.quantifiedhealth;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import be.mhealth.quantifiedhealth.listener.OnSwipeTouchListener;

public class MainActivity extends AppCompatActivity {

    AvatarManager mAvatarManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to logging", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        final ImageView imgView = (ImageView)findViewById(R.id.avatar);
        final TextView myScoreView = (TextView)findViewById(R.id.score1);
        final TextView populationScoreView = (TextView)findViewById(R.id.score3);
        AvatarManager.getInstance().initialize(this, imgView, myScoreView, populationScoreView, (float)Math.random(), 0.65f);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AvatarManager.getInstance().updateScore((float) Math.random());
                Snackbar.make(view, "Go to benchmark details", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


        registerSwipeListener(imgView);
        registerSwipeListener(myScoreView);
        registerSwipeListener(populationScoreView);
        registerSwipeListener(findViewById(R.id.score0));
        registerSwipeListener(findViewById(R.id.score2));
        registerSwipeListener(findViewById(R.id.title0));
        registerSwipeListener(findViewById(R.id.title1));
    }

    private void registerSwipeListener(final View view) {
        view.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            @Override
            public void onSwipeLeft() {
                final Intent intent = new Intent(MainActivity.this, ProfileSettingsActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public void showProfileSettings(final View view){
        final Intent intent = new Intent(this, ProfileSettingsActivity.class);
        startActivity(intent);
    }





}
