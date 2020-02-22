package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends AppCompatActivity {

    EditText view;
    String num1="",num2="",num3="",num4="";
    double cal1,cal2;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bmin,bplus,bdiv,bmul,beqal,bclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        view = findViewById(R.id.viewcal);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button10);
        bmin = findViewById(R.id.buttonmil);
        bmul = findViewById(R.id.buttonmul);
        bplus = findViewById(R.id.buttonplus);
        bdiv = findViewById(R.id.buttondiv);
        beqal = findViewById(R.id.buttoneq);
        bclear = findViewById(R.id.bclear);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"1");
                if(num2 == "")
                {
                    num1 = num1 + "1";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "1";
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"2");
                if(num2 == "")
                {
                    num1 = num1 + "2";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "2";
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"3");
                if(num2 == "")
                {
                    num1 = num1 + "3";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "3";
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"4");
                if(num2 == "")
                {
                    num1 = num1 + "4";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "4";
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"5");
                if(num2 == "")
                {
                    num1 = num1 + "5";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "5";
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"6");
                if(num2 == "")
                {
                    num1 = num1 + "6";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "6";
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"7");
                if(num2 == "")
                {
                    num1 = num1 + "7";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "7";
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"8");
                if(num2 == "")
                {
                    num1 = num1 + "8";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "8";
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"9");
                if(num2 == "")
                {
                    num1 = num1 + "9";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "9";
                }
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText(view.getText().toString()+"0");
                if(num2 == "")
                {
                    num1 = num1 + "0";
                }
                else if(num2 == "+"||num2 == "-"||num2 == "/"||num2 == "*")
                {
                    num3 = num3 + "0";
                }
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("");
                num1="";
                num2="";
                num3="";
                cal1=0;
                cal2=0;
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal1 = Double.parseDouble(num1);
                view.setText(view.getText().toString()+"+");
                num2 = "+";
            }
        });
        bmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal1 = Double.parseDouble(num1);
                view.setText(view.getText().toString()+"-");
                num2 = "-";
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal1 = Double.parseDouble(num1);
                view.setText(view.getText().toString()+"/");
                num2 = "/";
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal1 = Double.parseDouble(num1);
                view.setText(view.getText().toString()+"*");
                num2 = "*";
            }
        });
        beqal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num2 == "+")
                {
                    cal2 = Double.parseDouble(num3);
                    num4 = String.valueOf(cal1 + cal2);
                }
                else if(num2 == "-")
                {
                    cal2 = Double.parseDouble(num3);
                    num4 = String.valueOf(cal1 - cal2);
                }
                else if(num2 == "/")
                {
                    cal2 = Double.parseDouble(num3);
                    num4 = String.valueOf(cal1 / cal2);
                }
                else if(num2 == "*")
                {
                    cal2 = Double.parseDouble(num3);
                    num4 = String.valueOf(cal1 * cal2);
                }
                view.setText(num4);
                num1="";
                num2="";
                num3="";cal1=0;cal2=0;
            }
        });
    }
}
