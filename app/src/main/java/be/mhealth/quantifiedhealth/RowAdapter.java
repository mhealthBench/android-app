package be.mhealth.quantifiedhealth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by bfriedrich on 20/03/16.
 */
public class RowAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] objects;
    private final int resource;

    public RowAdapter(final Context context, final int resource,final  String[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        return null;
    }
}
