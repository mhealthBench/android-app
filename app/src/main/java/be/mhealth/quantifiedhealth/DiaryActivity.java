package be.mhealth.quantifiedhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import be.mhealth.quantifiedhealth.listener.OnSwipeTouchListener;

public class DiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        setTitle(R.string.title_activity_diary);

        ((ImageView)findViewById(R.id.imgViewDiary)).setOnTouchListener(new OnSwipeTouchListener(DiaryActivity.this) {
            @Override
            public void onSwipeRight() {
                final Intent intent = new Intent(DiaryActivity.this, AdviceActivity.class);
                startActivity(intent);
            }
        });
    }
}
