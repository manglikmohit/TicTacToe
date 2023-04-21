package com.mohit.tictactoe;

import android.graphics.Color;
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
    private boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View view) {
        Button btn = (Button) view;
        if(btn.getText().toString() != "" || !isGameActive)
            return;

        move_count++;

        ((Button) view).setText(current_move);

        if (btn.getText().toString().equals(X)) {
            btn.setBackgroundColor(Color.CYAN);
        } else {
            btn.setBackgroundColor(Color.YELLOW);
        }


        if (move_count > 4) {
            if (checkWin()) {
                Toast.makeText(this, "winner is " + btn.getText(), Toast.LENGTH_SHORT).show();
                isGameActive = false;
            }
        }

        if (move_count == 9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }

        toggleCurrentMove();
    }

    public  void reset(View view){
        reset();
    }

    public  void reset(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        btn1.setBackgroundColor(Color.GREEN);
        btn2.setBackgroundColor(Color.GREEN);
        btn3.setBackgroundColor(Color.GREEN);
        btn4.setBackgroundColor(Color.GREEN);
        btn5.setBackgroundColor(Color.GREEN);
        btn6.setBackgroundColor(Color.GREEN);
        btn7.setBackgroundColor(Color.GREEN);
        btn8.setBackgroundColor(Color.GREEN);
        btn9.setBackgroundColor(Color.GREEN);

        move_count = 0;
        current_move=X;
        isGameActive = true;
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