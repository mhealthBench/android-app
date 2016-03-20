package be.mhealth.quantifiedhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AdviceActivity2 extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice2);

        setTitle(R.string.title_activity_advice);

        final ListView lw = (ListView) findViewById(R.id.listAdvice2);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);

        final String[] entries = getResources().getStringArray(R.array.advice_entry_highlights);

        adapter=new RowAdapter(this,
                android.R.layout.simple_list_item_1,
                entries);



        lw.setAdapter(adapter);

        // final String[] entries = getResources().getStringArray(R.array.advice_entry_highlights);
        // adapter.addAll(entries);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, final View view,
                                    final int position, final long id) {
                final Intent intent = new Intent(AdviceActivity2.this, AdviceEntryActivity.class);
                intent.putExtra(AdviceEntryActivity.ENTRY_POSITION, position);
                startActivity(intent);
            }
        });
    }
}
