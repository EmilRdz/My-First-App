package com.emiliordz.myfirstapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";
    public static final String  EXTRA_MESSAGE = "EXTRA_MESSAGE";
    TextView mTextView;
    String getExtraMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        final TextView tv = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.withText);
        if(Intent.ACTION_SEND.equals(action)&&type!=null){
            String extraText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            if (extraText != null) {
                editText.setText(extraText);
            }
        }
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String link = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (link!= null) {
                    editText.setText(link);
                }
            }
        }
    }
}