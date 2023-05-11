package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    EditText name;
    Button accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome = findViewById(R.id.textViewWelcome);
        name = findViewById(R.id.editTextPersonName);
        accept = findViewById(R.id.buttonAccept);
    }

    public void acceptClick(View view) {
        String n = name.getText().toString();
        if(n.equals("")){
            Toast.makeText(this, "Enter a name", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this,MainActivity2.class);
            Bundle bundle = new Bundle();
            bundle.putString("name",name.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}