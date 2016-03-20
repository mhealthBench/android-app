package be.mhealth.quantifiedhealth;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import be.mhealth.quantifiedhealth.R;

/**
 * Created by bfriedrich on 20/03/16.
 */
public final class StyleHelper {
    private StyleHelper(){}

    public static void setupWindowColor(final Activity activity) {
        final Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.colorPrimaryDark));
    }

}
