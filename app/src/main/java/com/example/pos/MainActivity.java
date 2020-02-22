package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pos.Model.CalculationUtil;

public class MainActivity extends AppCompatActivity {

    private EditText uprice, quantity, total;
    private RadioGroup rg;
    private TextView upriceText;
    private RadioButton radio;
    private static final int tax = 15;
    private double taxesCalculated, totalCalculated;
    private EditText taxes_value;
    private String radioText;
    private Button phone;


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
        phone = (Button)findViewById(R.id.call);


        /**
         * Main Activity : this method sets the unit price of the vehicles selected and controls the visibility of the uprice field.
         */
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                radio = findViewById(checkedId);
                radioText = radio.getText().toString().toLowerCase();
                Toast.makeText(MainActivity.this, radio.getText().toString(), Toast.LENGTH_SHORT).show();
                uprice.setVisibility(View.VISIBLE);
                upriceText.setVisibility(View.VISIBLE);

                if (radioText.equalsIgnoreCase("car")) {
                    uprice.setText("25000");
                }
                if (radioText.equalsIgnoreCase("bike")) {
                    uprice.setText("10000");
                }
                if (radioText.equalsIgnoreCase("plane")) {
                    uprice.setText("9500000");
                }
                if (radioText.equalsIgnoreCase("boat")) {
                    uprice.setText("145500");
                }
            }
        });

        /***
         * email button
         */
        Button emailBtn = (Button) findViewById(R.id.email);
        emailBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
        /***
         * sms button
         */

        Button smsBtn = (Button) findViewById(R.id.sms);
        smsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });

        Button calc = findViewById(R.id.calculator);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Calculator.class);
                startActivity(intent);
            }
        });


    }

    /**
     * the calculationUtil method is called and :
     * 1. Taxes are calculated by calling the method from Calculation Util
     * 2. Total is calculated by calling the method form the Calculation Util
     */
    public void calculate(View view) {
        int quanityt = Integer.parseInt(quantity.getText().toString());
        int unitPrice = Integer.parseInt(uprice.getText().toString());
        Log.v("sanjay", quantity.getText().toString());
        Log.v("sanjay", uprice.getText().toString());
        CalculationUtil cl = new CalculationUtil(quanityt, unitPrice);

        taxesCalculated = cl.getTaxesCalculated();
        taxes_value.setText("" + taxesCalculated);
        totalCalculated = cl.getTotalCalculated();
        total.setText("" + totalCalculated);
    }

    /**
     * This method handles the movement from Main screen to the Second screen
     */
    public void CreateSimpleMessage(View view) {
        //Toast.makeText(MainActivity.this,radio.getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * This method hANDLES TO SEND EMAIL FROM MOBILE>>>
     */


    @SuppressLint("LongLogTag")
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This method hANDLES TO SEND SMS FROM MOBILE>>>
     */


    private void sendSMS() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) // At least KitKat
        {
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this); // Need to change the build to API 19

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text");

            if (defaultSmsPackageName != null)// Can be null in case that there is no default, then the user would be able to choose
            // any app that support this intent.
            {
                sendIntent.setPackage(defaultSmsPackageName);
            }
            startActivity(sendIntent);

        } else // For early versions, do what worked for you before.
        {
            Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", "phoneNumber");
            smsIntent.putExtra("sms_body", "message");
            startActivity(smsIntent);
        }
    }



/*


      phone.OnClickListener(new View.OnClickListener()

    {
        public void onClick (View arg0){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0377778888"));

        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }
    });

*/





}












