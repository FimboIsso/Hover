package com.androidstudy.hover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;

public class MainActivity extends AppCompatActivity {

    private static final int HOVER_REQUEST = 0;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeHoverRequest();
            }
        });
    }

    private void makeHoverRequest() {
        Intent i = new HoverParameters.Builder(this)
                .request("964711da").extra("dummyData", "Juma Allan")
                .buildIntent();
        startActivityForResult(i, 0);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == HOVER_REQUEST && resultCode == Activity.RESULT_OK) {
            String[] sessionTextArr = data.getStringArrayExtra("ussd_messages");
            String uuid = data.getStringExtra("uuid");
            Log.d("UUID ", "onActivityResult: " + uuid);
        } else if (requestCode == HOVER_REQUEST && resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Error: " + data.getStringExtra("error"), Toast.LENGTH_LONG).show();
        }
    }
}
