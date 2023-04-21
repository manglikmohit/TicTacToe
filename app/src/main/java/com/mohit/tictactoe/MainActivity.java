package com.mohit.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String X = "X";
    String O = "O";
    String current_move = X;

    int move_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn1);
        btn4 = findViewById(R.id.btn1);
        btn5 = findViewById(R.id.btn1);
        btn6 = findViewById(R.id.btn1);
        btn7 = findViewById(R.id.btn1);
        btn8 = findViewById(R.id.btn1);
        btn9 = findViewById(R.id.btn1);
    }

    public void check(View view) {
        move_count++;
        Button btn = (Button) view;
        ((Button) view).setText(current_move);


        if (move_count > 4) {
            if (checkWin()) {
                Toast.makeText(this, "winner is " + btn.getText(), Toast.LENGTH_SHORT).show();
            }
        }

        if (move_count == 9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }

        btn.setActivated(false);
        toggleCurrentMove();
    }

    private boolean checkWin() {
        String b1 = btn1.getText().toString();
        String b2 = btn2.getText().toString();
        String b3 = btn3.getText().toString();
        String b4 = btn4.getText().toString();
        String b5 = btn5.getText().toString();
        String b6 = btn6.getText().toString();
        String b7 = btn7.getText().toString();
        String b8 = btn8.getText().toString();
        String b9 = btn9.getText().toString();

        if ((b1.equals(b2) && b2.equals(b3) && !b1.equals("")) ||
                (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) ||
                (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) ||
                (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) ||
                (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) ||
                (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) ||
                (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) ||
                (b3.equals(b5) && b5.equals(b7) && !b3.equals("")))
            return true;

        return false;
    }

    void toggleCurrentMove() {
        current_move = current_move.equals(X) ? O : X;
    }
}