package com.example.martoraneca.newcalculator;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mClearButton;
    private char operation;
    private double number;
    private double result;
    private double currentNumber;
    private DecimalFormat dfPercent = new DecimalFormat("###.######");
    private DecimalFormat dfOperations = new DecimalFormat("#.###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mClearButton = (Button) findViewById(R.id.clearButton);

    }

    public void numberClicked(View view) {
        String oldText = mEditText.getText().toString();
        if (oldText.startsWith("0") && !oldText.contains(".")) {
            oldText = oldText.substring(1);
        }
        if (mEditText.getText().equals(0)) {
            mClearButton.setText("AC");
        }
        else {
            mClearButton.setText("C");
        }
        mEditText.setText(oldText + ((Button)view).getText());
    }

    public void percentClicked(View view) {

        try {
            currentNumber = Double.parseDouble(mEditText.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        mEditText.setText(dfPercent.format(currentNumber/100));
    }

    public void operationClicked(View view) {

        try {
            this.operation = ((Button)(view)).getText().charAt(0);
            this.number = Double.parseDouble(mEditText.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mEditText.setText(String.valueOf(operation));
    }

    public void equalsClick(View view) {

        try {
            String strNumber = mEditText.getText().toString();
            if (strNumber.contains(String.valueOf(operation))){
                strNumber = strNumber.substring(1);
            }
            currentNumber = Double.parseDouble(String.valueOf(strNumber));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (this.operation == '+') {
            this.result = number + currentNumber;
            mEditText.setText(dfOperations.format(result));
            this.operation = '0';
            this.number = '0';
        }
        if (this.operation == '-') {
            this.result = number - currentNumber;
            mEditText.setText(dfOperations.format(Double.valueOf(result)));
            this.operation = '0';
            this.number = '0';
        }
        if (this.operation == '*') {
            this.result = number * currentNumber;
            mEditText.setText(dfOperations.format(Double.valueOf(result)));
            this.operation = '0';
            this.number = '0';
        }
        if (this.operation == '/') {
            this.result = number / currentNumber;
            mEditText.setText(dfOperations.format(Double.valueOf(result)));
            this.operation = '0';
            this.number = '0';
        }
    }

    public void clearResult(View view) {
        this.number = 0;
        this.result = 0;
        mEditText.setText("0");
        mClearButton.setText("AC");
    }

    public void plusMinusClicked(View view) {

        try {
            mEditText.setText(""+Double.parseDouble(mEditText.getText().toString()) * (-1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void pointClicked(View view) {
        String oldText = mEditText.getText().toString();
        if (oldText.contains(".")){
            mEditText.setText(mEditText.getText().toString());
        }
        else {
            mEditText.setText(oldText+".");
        }
    }

}
