package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ed1; //displeys kurā parādās cipari
    TextView historyWindow;
    private Button readMemory, clearMemory, btn0, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPoint,btnEquals,btnC,btnPlus,btnMinus,btnMultiply,btnDivide, btnHistory;;
    private String result, resultString; //result stringi
    private boolean plus,minus,multiply,divide, decimal =false; //pārbaudes vērtības
    private double firstNumber =0,secondNumber=0; //pirmais un otrais cipars
    int dotCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readMemory = findViewById(R.id.btnReadMemory);
        clearMemory = findViewById(R.id.btnClearMemory);
        ed1 = findViewById(R.id.editText);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnC = (Button) findViewById(R.id.btnC);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnHistory = (Button) findViewById(R.id.btnHistory);


        result = "";
        btnHistory.setVisibility(View.GONE);
        readMemory.setEnabled(false); //nelauj pasa sakuma nolasit memmory uzspiest punktu un ir zimi
        btnPoint.setEnabled(false);
        btnEquals.setEnabled(false);

        readMemory.setOnClickListener(new View.OnClickListener() { //nolasita atmina
            @Override
            public void onClick(View v) {
                loadData();
                updateViews();
            }
        });

        clearMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHistory.setVisibility(View.GONE);
                SharedPreferences.Editor ed = getSharedPreferences("shared preferences", MODE_PRIVATE).edit();
                ed.clear();
                ed.apply();
                readMemory.setEnabled(false);
                Toast.makeText(MainActivity.this, "Memory cleared", Toast.LENGTH_SHORT).show();
            }

        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("0");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("1");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("2");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("3");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("4");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("5");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("6");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("7");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("8");
                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton("9");

                if(decimal){
                    btnPoint.setEnabled(false);
                }
                else{
                    btnPoint.setEnabled(true);
                }
                btnEquals.setEnabled(true);
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignButton(".");
                decimal = true;
                btnPoint.setEnabled(false);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                result = "";
                firstNumber = 0.0;
                secondNumber = 0.0;
                decimal =false;
                btnPoint.setEnabled(false);
                btnEquals.setEnabled(false);
            }
        });


        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().length() != 0) {
                    firstNumber = Float.parseFloat(ed1.getText() + "");
                    divide = true;
                    decimal = false;
                    ed1.setText(null);
                    btnPoint.setEnabled(false);
                    btnEquals.setEnabled(false);
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().length() != 0) {
                    firstNumber = Float.parseFloat(ed1.getText() + "");
                    multiply = true;
                    decimal = false;
                    ed1.setText(null);
                    btnPoint.setEnabled(false);
                    btnEquals.setEnabled(false);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().length() != 0) {
                    firstNumber = Float.parseFloat(ed1.getText() + "");
                    minus = true;
                    decimal = false;
                    ed1.setText(null);
                    btnPoint.setEnabled(false);
                    btnEquals.setEnabled(false);
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().length() != 0) {
                    firstNumber = Float.parseFloat(ed1.getText() + "");
                    plus = true;
                    decimal = false;
                    ed1.setText(null);
                    btnPoint.setEnabled(false);
                    btnEquals.setEnabled(false);
                }
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plus || minus || multiply || divide) {
                    secondNumber = Float.parseFloat(ed1.getText() + "");
                }
                if (plus) {
                    result = firstNumber + secondNumber + "";
                    ed1.setText(result);
                    plus = false;
                }
                if (minus) {
                    result = firstNumber - secondNumber + "";
                    ed1.setText(result);
                    minus = false;
                }
                if (multiply) {
                    result = firstNumber * secondNumber + "";
                    ed1.setText(result);
                    multiply = false;
                }
                if (divide) {
                    result = firstNumber / secondNumber + "";
                    ed1.setText(result);
                    divide = false;
                }
                saveData(); //tiek izsaukta saglabāt datus metode
                readMemory.setEnabled(true);
                btnPoint.setEnabled(false);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnHistory.getText().toString();
                ed1.setText(buttonText);
                btnPoint.setEnabled(false);
            }
        });
    }


    public void assignButton(String text){ //uzliek pogām virsū ciparu
        ed1.setText(ed1.getText() + text);
    }

    public void saveData(){ //saglabā rezultātu sharedPrefos
        SharedPreferences sp = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("RESULT", result);
        editor.apply();
    }

    private void loadData(){ //ielādē sharedPrefos noseivoto vērtību un uzstāda viņu history pogai
        SharedPreferences sp = getSharedPreferences("shared preferences", MODE_PRIVATE);
        resultString = sp.getString("RESULT", "");
        if(resultString == ""){ //gadijuma ja netiek sakuma ievadita nekada vertiba, tad tiek panemta pirma vertiba no textfield
            btnHistory.setText(ed1.getText());
        }
        else {
            btnHistory.setText(resultString);
        }
    }

    public void updateViews() { //padara skatu redzamu kad tiek izsaukta metode
        btnHistory.setVisibility(View.VISIBLE);
    }
}