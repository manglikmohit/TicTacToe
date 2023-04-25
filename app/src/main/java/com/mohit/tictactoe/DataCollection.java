package com.mohit.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DataCollection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);

        Button btnNext = findViewById(R.id.btnNext);

        Intent iNext = new Intent(DataCollection.this, MainActivity.class);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fUser, sUser;
                fUser = ((EditText) findViewById(R.id.etFirstUserName)).getText().toString();
                sUser = ((EditText) findViewById(R.id.etSecondUserName)).getText().toString();

                iNext.putExtra("first_name", fUser);
                iNext.putExtra("second_name", sUser);
                startActivity(iNext);
            }
        });
    }
}