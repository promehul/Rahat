package com.bridgefy.samples.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetName extends AppCompatActivity {

    EditText editText = findViewById(R.id.editText);

    String name = editText.getText().toString();
    Button button = findViewById(R.id.button);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

    }


    public void onNameSelected(View view) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }
    /*********************/

    /*EditText editText = findViewById(R.id.editText);
    String name = editText.getText().toString();
    Button button = findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

    }


    public void onNameSelected(View view) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }*/
}
