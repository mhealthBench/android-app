package be.mhealth.quantifiedhealth;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeActivity extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        final View view = inflater.inflate(R.layout.content_home, container, false);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(HomeActivity.this.getActivity(), QuestionnaireHeadachesActivity.class);
                startActivity(intent);
            }
        });


        final ImageView imgView = (ImageView)view.findViewById(R.id.avatar);
        AvatarManager.getInstance().initialize(view.getContext(), imgView);


        return view;
    }

}
