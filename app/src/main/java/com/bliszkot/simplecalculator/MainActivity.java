package com.bliszkot.simplecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button ba, bs, bm, bd;
    Button be, bc, bdt;
    EditText tres;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tres = findViewById(R.id.txt_input);
        tres.setText("");

        b0 = findViewById(R.id.button_zero);
        b0.setOnClickListener(v -> tres.append("0"));

        b1 = findViewById(R.id.button_one);
        b1.setOnClickListener(v -> tres.append("1"));

        b2 = findViewById(R.id.button_two);
        b2.setOnClickListener(v -> tres.append("2"));

        b3 = findViewById(R.id.button_three);
        b3.setOnClickListener(v -> tres.append("3"));

        b4 = findViewById(R.id.button_four);
        b4.setOnClickListener(v -> tres.append("4"));

        b5 = findViewById(R.id.button_five);
        b5.setOnClickListener(v -> tres.append("5"));

        b6 = findViewById(R.id.button_six);
        b6.setOnClickListener(v -> tres.append("6"));

        b7 = findViewById(R.id.button_seven);
        b7.setOnClickListener(v -> tres.append("7"));

        b8 = findViewById(R.id.button_eigth);
        b8.setOnClickListener(v -> tres.append("8"));

        b9 = findViewById(R.id.button_nine);
        b9.setOnClickListener(v -> tres.append("9"));

        bd = findViewById(R.id.button_div);
        bd.setOnClickListener(v -> tres.append("/"));

        ba = findViewById(R.id.button_add);
        ba.setOnClickListener(v -> tres.append("+"));

        bs = findViewById(R.id.button_sub);
        bs.setOnClickListener(v -> tres.append("-"));

        bm = findViewById(R.id.button_mul);
        bm.setOnClickListener(v -> tres.append("*"));

        be = findViewById(R.id.button_equals);
        be.setOnClickListener(v -> tres.append("="));

        bdt = findViewById(R.id.button_dot);
        bdt.setOnClickListener(v -> tres.append("."));

        bc = findViewById(R.id.button_clear);
        bc.setOnClickListener(v -> tres.setText(""));


        try {
            if (data.contains("/")) doMath("/");
            if (data.contains("*")) doMath("*");
            if (data.contains("-")) doMath("-");
            if (data.contains("+")) doMath("+");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }

    private void doMath(String s) {
        String[] operands;
        if (s.equals("+")) {
            operands = data.split("\\+");
        } else if (s.equals("*")) {
            operands = data.split("\\*");
        } else {
            operands = data.split(s);
        }
        double res = 0;
        if (operands.length == 2) {
            double op1 = Double.parseDouble(operands[0]);
            double op2 = Double.parseDouble(operands[1]);
            switch (s) {
                case "/": res = op1 / op2; break;
                case "*": res = op1 * op2; break;
                case "+": res = op1 + op2; break;
                case "-": res = op1 - op2; break;
            }
            tres.setText(String.valueOf(res));
        } else {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }
    }
}



