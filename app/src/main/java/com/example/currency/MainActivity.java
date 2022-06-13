package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner_input;
    private Spinner spinner_output;
    private TextView txt1,txt2, txtCompare;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, dec, ce, backspace;
    Double var;
    double value1, value2, score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.spinner_input = (Spinner) findViewById(R.id.spinner_input);
        Currency[] currencies = CurrencyData.getCurrencies();

        ArrayAdapter<Currency> adapter = new ArrayAdapter<Currency>(this, android.R.layout.simple_spinner_item, currencies);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spinner_input.setAdapter(adapter);
        this.spinner_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler1(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.spinner_output = (Spinner) findViewById(R.id.spinner_output);
        Currency[] currencies1 = CurrencyData.getCurrencies();

        ArrayAdapter<Currency> adapter1 = new ArrayAdapter<Currency>(this, android.R.layout.simple_spinner_item, currencies1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spinner_output.setAdapter(adapter1);
        this.spinner_output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler2(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.four);
        b5 = findViewById(R.id.five);
        b6 = findViewById(R.id.six);
        b7 = findViewById(R.id.seven);
        b8 = findViewById(R.id.eight);
        b9 = findViewById(R.id.nine);
        b0 = findViewById(R.id.zero);
        ce = findViewById(R.id.CE);
        dec = findViewById(R.id.dec);
        backspace = findViewById(R.id.backspace);
        txt1 = findViewById(R.id.input);
        txt2 = findViewById(R.id.output);
        txtCompare = findViewById(R.id.compare);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"1");
            }
        });
        //to show value of this button in textView1
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"2");
            }
        });
        //to show value of this button in textView1
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"3");
            }
        });
        //to show value of this button in textView1
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"4");
            }
        });
        //to show value of this button in textView1
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"5");
            }
        });
        //to show value of this button in textView1
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"6");
            }
        });
        //to show value of this button in textView1
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"7");
            }
        });
        //to show value of this button in textView1
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"8");
            }
        });
        //to show value of this button in textView1
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"9");
            }
        });
        //to show value of this button in textView1
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+"0");
            }
        });
        //to show value of this button in textView1
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(txt1.getText()+".");
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText("0");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(txt1.getText());
                if(text.length() <= 1){
                    txt1.setText("0");
                }else if(text.length() > 1){
                    text = text.substring(0, text.length() -1 );
                    txt1.setText(text);
                }
            }
        });
        if(!txt1.getText().equals("")){

            txt1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    String text = String.valueOf(txt1.getText());
                    if(text.length() > 1 && text.charAt(0) == 48){
                        txt1.setText(text.substring(1));
                    }
                    var = Double.parseDouble(txt1.getText().toString())*score;
                    txt2.setText(var.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }


    }
    String currency1, currency2;
    private void onItemSelectedHandler1(AdapterView<?> adapterView, View view, int position, long id){
        Adapter adapter = adapterView.getAdapter();
        Currency currency = (Currency) adapter.getItem(position);
        value1 = currency.getValue();
        currency1 = currency.getSymbol();
        score = value1/value2;
        var = Double.parseDouble(txt1.getText().toString())*score;
        txt2.setText(var.toString());
        txtCompare.setText("1 " + currency1 + " = "+ score + " " +currency2);
    }
    private void onItemSelectedHandler2(AdapterView<?> adapterView, View view, int position, long id){
        Adapter adapter = adapterView.getAdapter();
        Currency currency = (Currency) adapter.getItem(position);
        value2 = currency.getValue();
        currency2 = currency.getSymbol();
        score = value1/value2;
        var = Double.parseDouble(txt1.getText().toString())*score;
        txt2.setText(var.toString());
        txtCompare.setText("1 " + currency1 + " = "+ score + " " +currency2);

    }

}