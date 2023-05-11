package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView cappuccino, espresso, latte, mocha;
    TextView coffeeMenu, cName, cCount, cPrice, eName, eCount, ePrice, lName, lCount, lPrice, mName, mCount, mPrice;
    Button cAdd, cSub, eAdd, eSub, lAdd, lSub, mAdd, mSub, checkout;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cappuccino = findViewById(R.id.imageViewCappuccino);
        espresso = findViewById(R.id.imageViewEspresso);
        latte = findViewById(R.id.imageViewLatte);
        mocha = findViewById(R.id.imageViewMocha);
        coffeeMenu = findViewById(R.id.textViewCoffeeMenu);
        cName = findViewById(R.id.textViewCappuccino);
        eName = findViewById(R.id.textViewEspresso);
        lName = findViewById(R.id.textViewLatte);
        mName = findViewById(R.id.textViewMocha);
        cCount = findViewById(R.id.textViewCCount);
        eCount = findViewById(R.id.textViewECount);
        lCount = findViewById(R.id.textViewLCount);
        mCount = findViewById(R.id.textViewMCount);
        cPrice = findViewById(R.id.textViewCPrice);
        ePrice = findViewById(R.id.textViewEPrice);
        lPrice = findViewById(R.id.textViewLPrice);
        mPrice = findViewById(R.id.textViewMPrice);
        cAdd = findViewById(R.id.buttonAddCappuccino);
        eAdd = findViewById(R.id.buttonAddEspresso);
        lAdd = findViewById(R.id.buttonAddLatte);
        mAdd = findViewById(R.id.buttonAddMocha);
        cSub = findViewById(R.id.buttonSubCappuccino);
        eSub = findViewById(R.id.buttonSubEspresso);
        lSub = findViewById(R.id.buttonSubLatte);
        mSub = findViewById(R.id.buttonSubMocha);
        checkout = findViewById(R.id.buttonCheckout);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
    }

    public void subCappuccinoClick(View view) {
        int ccCount = Integer.parseInt(cCount.getText().toString());
        if(ccCount != 0) {
            ccCount--;
            cCount.setText(Integer.toString(ccCount));
        }
    }

    public void addCappuccinoClick(View view) {
        int ccCount = Integer.parseInt(cCount.getText().toString());
        ccCount++;
        cCount.setText(Integer.toString(ccCount));
    }

    public void subEspressoClick(View view) {
        int eeCount = Integer.parseInt(eCount.getText().toString());
        if(eeCount != 0){
            eeCount--;
            eCount.setText(Integer.toString(eeCount));
        }
    }

    public void addEspressoClick(View view) {
        int eeCount = Integer.parseInt(eCount.getText().toString());
        eeCount++;
        eCount.setText(Integer.toString(eeCount));
    }

    public void subLatteClick(View view) {
        int llCount = Integer.parseInt(lCount.getText().toString());
        if(llCount != 0){
            llCount--;
            lCount.setText(Integer.toString(llCount));
        }
    }

    public void addLatteClick(View view) {
        int llCount = Integer.parseInt(lCount.getText().toString());
        llCount++;
        lCount.setText(Integer.toString(llCount));
    }

    public void subMochaClick(View view) {
        int mmCount = Integer.parseInt(mCount.getText().toString());
        if(mmCount != 0){
            mmCount--;
            mCount.setText(Integer.toString(mmCount));
        }
    }

    public void addMochaClick(View view) {
        int mmCount = Integer.parseInt(mCount.getText().toString());
        mmCount++;
        mCount.setText(Integer.toString(mmCount));
    }

    public void checkoutClick(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        bundle.putInt("cCount", Integer.parseInt(cCount.getText().toString()));
        bundle.putInt("eCount", Integer.parseInt(eCount.getText().toString()));
        bundle.putInt("lCount", Integer.parseInt(lCount.getText().toString()));
        bundle.putInt("mCount", Integer.parseInt(mCount.getText().toString()));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}