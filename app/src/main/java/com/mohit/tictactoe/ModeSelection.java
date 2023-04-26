package com.mohit.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModeSelection extends AppCompatActivity {

    ArrayList<String> arrayListModes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);


        Intent iNext = new Intent(ModeSelection.this, MainActivity.class);

        arrayListModes.add("Offline");
        arrayListModes.add("online");

        ListView lvMode = findViewById(R.id.lvMode);

        ArrayAdapter<String> modeAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListModes);
        lvMode.setAdapter(modeAdapter);

        lvMode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(ModeSelection.this, "Offline mode selected", Toast.LENGTH_SHORT).show();
                    startActivity(iNext);
                } else
                    Toast.makeText(ModeSelection.this, "Online mode selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}