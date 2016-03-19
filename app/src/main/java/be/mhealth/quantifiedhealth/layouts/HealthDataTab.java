package be.mhealth.quantifiedhealth.layouts;

/**
 * Created by Stijn on 19/03/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.mhealth.quantifiedhealth.R;

/**
 * Created by Stijn on 19-03-2016.
 */
public class HealthDataTab extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.health_data_tab, container, false);

        return view;
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of HealthDataFragment");
        super.onResume();
    }
}