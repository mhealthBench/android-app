package be.mhealth.quantifiedhealth.layouts;

/**
 * Created by Stijn on 7/10/15.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import be.mhealth.quantifiedhealth.HomeActivity;
import be.mhealth.quantifiedhealth.R;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    Drawable myDrawable;
    String title;
    Context context;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, Context context) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.context = context;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            HealthDataTab healthDataTab = new HealthDataTab();

            return new HomeActivity();
        }
        else  if(position == 1)  {
            HealthDataTab healthDataTab = new HealthDataTab();
            return healthDataTab;
        } else  {
            HealthDataTab healthDataTab = new HealthDataTab();
            return healthDataTab;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_health_data);
                title = Titles[position].toString();
                break;
            case 1:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_walking);
                title = Titles[position].toString();
                break;
            case 2:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_food);
                title = Titles[position].toString();
                break;
            case 3:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_mental);
                title = Titles[position].toString();
                break;
            default:
                break;
        }
        SpannableStringBuilder sb = new SpannableStringBuilder(" "); // space added before text for convenience
        try {
            myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
            ImageSpan span = new ImageSpan(myDrawable, DynamicDrawableSpan.ALIGN_BASELINE);
            sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return sb;
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
