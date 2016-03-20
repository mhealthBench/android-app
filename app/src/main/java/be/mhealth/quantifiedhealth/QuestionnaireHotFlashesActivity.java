package be.mhealth.quantifiedhealth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class QuestionnaireHotFlashesActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_flashes_questionnaire);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        StyleHelper.setupWindowColor(this);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.flash_button);

        button.setText(R.string.btn_questionaire_done);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            final Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            }

        });

    }
}
