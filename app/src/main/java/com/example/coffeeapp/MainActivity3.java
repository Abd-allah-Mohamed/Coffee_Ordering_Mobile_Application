package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView order, customer, totalPrice, cName, tPrice;
    EditText vNumber, vPass;
    Button pay;
    String name;
    int cCount, eCount, lCount, mCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        order = findViewById(R.id.textViewOrder);
        customer = findViewById(R.id.textViewCustomer);
        cName = findViewById(R.id.textViewName);
        totalPrice = findViewById(R.id.textViewTotalPrice);
        tPrice = findViewById(R.id.textViewTPrice);
        vNumber = findViewById(R.id.editTextVisaNumber);
        vPass = findViewById(R.id.editTextVisaPassword);
        pay = findViewById(R.id.buttonPay);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        cCount = bundle.getInt("cCount");
        eCount = bundle.getInt("eCount");
        lCount = bundle.getInt("lCount");
        mCount = bundle.getInt("mCount");
        cName.setText(name);
        int res = 35 * cCount + 25 * eCount + 40 * lCount + 40 * mCount;
        tPrice.setText(Integer.toString(res));
    }

    public void payClick(View view) {
        String visaNumber = vNumber.getText().toString(), evenIndexes = "", oddIndexes = "";
        String passNumber = vPass.getText().toString();
        if(visaNumber.equals("") || passNumber.equals("")){
            Toast.makeText(this, "Enter all data fields", Toast.LENGTH_LONG).show();
        }
        else{
            if(visaNumber.length() != 16){
                Toast.makeText(this, "Invalid Visa Number", Toast.LENGTH_LONG).show();
                return;
            }
            for(int i = 0; i < visaNumber.length(); i = i + 2) {
                evenIndexes = evenIndexes + visaNumber.charAt(i);
                oddIndexes = oddIndexes + visaNumber.charAt(i+1);
            }
            int lastDegit = (int)(visaNumber.charAt(15))-48;
            int sum = 0;
            for(int i = 0; i < evenIndexes.length(); i++){
                int checkNumber = (int)(evenIndexes.charAt(i))-48;
                if(checkNumber == 5)
                    sum = sum + 1;
                else if(checkNumber == 6)
                    sum = sum + 3;
                else if(checkNumber == 7)
                    sum = sum + 5;
                else if(checkNumber == 8)
                    sum = sum + 7;
                else if(checkNumber == 9)
                    sum = sum + 9;
                else
                    sum = sum + (checkNumber*2);
            }
            for(int i = 0; i < oddIndexes.length() - 1; i++){
                int takenNumber = (int)(oddIndexes.charAt(i))-48;
                sum = sum + takenNumber;
            }
            if((sum + lastDegit) % 10 == 0 && passNumber.equals("123")) {
                Intent intent = new Intent(this, MainActivity4.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Invalid Visa Number", Toast.LENGTH_LONG).show();
            }
        }
    }
}