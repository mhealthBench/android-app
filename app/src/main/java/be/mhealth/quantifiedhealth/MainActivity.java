package be.mhealth.quantifiedhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import be.mhealth.quantifiedhealth.layouts.SlidingTabLayout;
import be.mhealth.quantifiedhealth.layouts.ViewPagerAdapter;
import be.mhealth.quantifiedhealth.listener.OnSwipeTouchListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StyleHelper.setupWindowColor(this);


        createTabs();
    }


    private void createTabs() {

        ViewPager pager;
        ViewPagerAdapter adapter;
        SlidingTabLayout tabs;
        int numberOfTabs = 4;

        CharSequence Titles[]={
                getString(R.string.healthdata),
                getString(R.string.activity),
                getString(R.string.nutrition),
                getString(R.string.mental)
        };

        adapter = new ViewPagerAdapter(
                getSupportFragmentManager(),
                Titles,numberOfTabs,this.getApplicationContext()
        );

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setCustomTabView(R.layout.custom_tab, 0);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorTabIndicator);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }

}
