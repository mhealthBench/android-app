package be.mhealth.quantifiedhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdviceEntryActivity extends AppCompatActivity {

    public static final String ENTRY_POSITION = "ENTRY__POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_entry);

        final Intent intent = getIntent();
        final int entryPosition = intent.getIntExtra(ENTRY_POSITION, 0);
        final String[] entries = getResources().getStringArray(R.array.advice_entries);
        final TextView txtView = (TextView)findViewById(R.id.textView);
        txtView.setText(entries[entryPosition]);
    }
}
