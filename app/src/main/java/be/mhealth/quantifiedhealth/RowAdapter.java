package be.mhealth.quantifiedhealth;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by bfriedrich on 20/03/16.
 */
public class RowAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] objects;
    private final int resource;
    private final Point  displaySize;

    public RowAdapter(final Context context, final int resource,final  String[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;

        final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final Display display = wm.getDefaultDisplay();
        this.displaySize = new Point();
        display.getSize(displaySize);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final View view =  super.getView(position, convertView, parent);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setMinimumWidth(displaySize.y);

        return view;
    }
}
