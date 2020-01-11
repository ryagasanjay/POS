package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText uprice, quantity,total ;
    private RadioGroup rg;
    private TextView upriceText;
    private RadioButton radio;
    private static final int tax = 15;
    private double taxesCalculated,totalCalculated;
    private EditText taxes_value;
    private String radioText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uprice = findViewById(R.id.upriceValue);
        upriceText = findViewById(R.id.uprice);
        rg = findViewById(R.id.radiogroup);
        quantity = findViewById(R.id.quantity_value);
        taxes_value = findViewById(R.id.taxes_value);
        total = findViewById(R.id.total_value);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                radio = findViewById(checkedId);
                radioText = radio.getText().toString().toLowerCase();
                Toast.makeText(MainActivity.this,radio.getText().toString() , Toast.LENGTH_SHORT).show();
                uprice.setVisibility(View.VISIBLE);
                upriceText.setVisibility(View.VISIBLE);
            }
        });
    }



    public void calculate(View view) {
        String text = "25000";
        int quanityt = Integer.valueOf(quantity.getText().toString());

//        Toast.makeText(MainActivity.this, radioText, Toast.LENGTH_SHORT).show();
        if (radioText.equalsIgnoreCase("car")) {
            uprice.setText(text);
            taxesCalculated = calculateTaxes( quanityt,25000);
            taxes_value.setText(""+taxesCalculated);
            totalCalculated = calculateTotal(quanityt,taxesCalculated,25000);
            total.setText(""+totalCalculated);

        }

        if (radioText.equalsIgnoreCase("bike")) {
            uprice.setText("10000");
            taxesCalculated = calculateTaxes( quanityt,10000);
            taxes_value.setText(""+taxesCalculated);
            totalCalculated = calculateTotal(quanityt,taxesCalculated,10000);
            total.setText(""+totalCalculated);

        }
        if (radioText.equalsIgnoreCase("plane")){
            uprice.setText("9500000");
            taxesCalculated = calculateTaxes( quanityt,9500000);
            taxes_value.setText(""+taxesCalculated);
            totalCalculated = calculateTotal(quanityt,taxesCalculated,9500000);
            total.setText(""+totalCalculated);
        }
        if (radioText.equalsIgnoreCase("boat")) {
            uprice.setText("145500");
            taxesCalculated = calculateTaxes( quanityt,145500);
            taxes_value.setText(""+taxesCalculated);
            totalCalculated = calculateTotal(quanityt,taxesCalculated,145500);
            total.setText(""+totalCalculated);
        }

    }

    public int calculateTaxes(int quantity,int value){
        return (15*quantity*value)/100;
    }

    public double calculateTotal(int quantity,double taxesCalculated,int value){
        return quantity*value+taxesCalculated;
    }

    public void CreateSimpleMessage(View view){
        //Toast.makeText(MainActivity.this,radio.getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
