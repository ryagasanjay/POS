package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;



public class SecondActivity extends AppCompatActivity {

    private EditText msg;
    public static final String EXTRA_MESSAGE = "com.example.android.pos.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        msg = findViewById(R.id.message);

    }

    /**
     *
     * This handles the functionality of sending the message typed in the text field.
     */
    public void launchThirdActivitiy(View view){
        Log.d("LOG_CAT","Send button is clicked");
        Intent intent = new Intent(this,ThirdActivity.class);
        String message = msg.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }
}
