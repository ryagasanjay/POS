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

import com.example.pos.Model.CalculationUtil;

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

        /**
         * Main Activity : this method sets the unit price of the vehicles selected and controls the visibility of the uprice field.
         */
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                radio = findViewById(checkedId);
                radioText = radio.getText().toString().toLowerCase();
                Toast.makeText(MainActivity.this,radio.getText().toString() , Toast.LENGTH_SHORT).show();
                uprice.setVisibility(View.VISIBLE);
                upriceText.setVisibility(View.VISIBLE);

                if (radioText.equalsIgnoreCase("car")) {
                    uprice.setText("25000");
                }if (radioText.equalsIgnoreCase("bike")) {
                    uprice.setText("10000");
                }if (radioText.equalsIgnoreCase("plane")){
                    uprice.setText("9500000");
                }if (radioText.equalsIgnoreCase("boat")) {
                    uprice.setText("145500");
                }
            }
        });

    }

    /**
     *
     * the calculationUtil method is called and :
     * 1. Taxes are calculated by calling the method from Calculation Util
     * 2. Total is calculated by calling the method form the Calculation Util
     */
    public void calculate(View view) {
        int quanityt = Integer.parseInt(quantity.getText().toString());
        int unitPrice = Integer.parseInt(uprice.getText().toString());
        Log.v("sanjay",quantity.getText().toString());
        Log.v("sanjay",uprice.getText().toString());
        CalculationUtil cl = new CalculationUtil(quanityt,unitPrice);

        taxesCalculated = cl.getTaxesCalculated();
        taxes_value.setText(""+taxesCalculated);
        totalCalculated = cl.getTotalCalculated();
        total.setText(""+totalCalculated);
    }

    /**
     *
     * This method handles the movement from Main screen to the Second screen
     */
    public void CreateSimpleMessage(View view){
        //Toast.makeText(MainActivity.this,radio.getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
