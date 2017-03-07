package com.example.spohlmann.unit7assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtWidth;
    EditText txtLength;
    TextView txtResult;
    private static final int RequestCode = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWidth = (EditText) findViewById(R.id.txtWidth);
        txtLength = (EditText) findViewById(R.id.txtLength);
    }

    public void onButtonClick(View view) {
        // Call the second activity
        int width = Integer.parseInt(String.valueOf(txtWidth.getText()));
        int length = Integer.parseInt(String.valueOf(txtLength.getText()));
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("Width", width);
        intent.putExtra("Length", length);
        startActivityForResult(intent, RequestCode);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RequestCode) {
            if (data.hasExtra("Flooring")) {
                String result = data.getExtras().getString("Flooring");
                if (result != null && result.length() > 0) {
                    txtResult.setText("Flooring : " + result);
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
