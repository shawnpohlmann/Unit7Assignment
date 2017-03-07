package com.example.spohlmann.unit7assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.name;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewData;
    int width;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewData = (TextView) findViewById(R.id.textViewData);

        Bundle extras = getIntent().getExtras();
        width = extras.getInt("Width");
        length = extras.getInt("Length");
        textViewData.setText("Width is " + width + " Length is " + length + " and flooring needed is  " + (width* length));

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("Flooring", (width*length));
        setResult(RESULT_OK, intent);
        super.finish();
    }
}