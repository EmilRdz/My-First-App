package com.emiliordz.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";
    public static final String  EXTRA_MESSAGE = "EXTRA_MESSAGE";
    TextView mTextView;
    String getExtraMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.textView);
        final Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundaActividad.class);
                intent.putExtra(EXTRA_MESSAGE, "Mensaje");
                startActivity(intent);
                tv.setText(LocalTime.now().toString());
            }
        });
        if (savedInstanceState!=null) {
            getExtraMessage = savedInstanceState.getString(EXTRA_MESSAGE);
        }
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        }


        @Override
        public void onRestoreInstanceState(Bundle savedInstanceState) {
            final TextView tv = findViewById(R.id.textView);
            tv.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
        }
        @Override
        public void onSaveInstanceState(Bundle outstate) {
            final TextView tv = findViewById(R.id.textView);
            outstate.putString(TEXT_VIEW_KEY,tv.getText().toString());
            super.onSaveInstanceState(outstate);
        }
    }