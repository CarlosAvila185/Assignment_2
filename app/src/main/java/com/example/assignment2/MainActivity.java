package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double newDouble;
    String option, nNum, spinText;

    TextView outputResult;
    EditText enterNum;
    Button submitBut;
    Spinner submitSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitSpin = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        submitSpin.setAdapter(adapter);

        enterNum = (EditText) findViewById(R.id.editTextNumberDecimal);
        outputResult = (TextView) findViewById(R.id.textView4);

        submitBut = (Button) findViewById(R.id.button1);
        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinText = submitSpin.getSelectedItem().toString();
                nNum = enterNum.getText().toString();

                double temp = Double.parseDouble(nNum);
                newDouble = convertCtoF(temp);
                outputResult.setText(String.valueOf(newDouble));

                if (spinText.equals("Celcius to Farenheit"))
                    {
                    newDouble = convertCtoF(temp);
                    outputResult.setText(String.valueOf(String.format("%.2f", newDouble))+ "°F");
                    }
                else
                    {
                    newDouble = convertFtoC(temp);
                    outputResult.setText(String.valueOf(String.format("%.2f",newDouble))+ "°C");
                    }


            }
        });


    }



    private void showToast(int text)
    {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    }

    private double convertFtoC(double num)
    {
        double newNum;
        newNum = (num - 32) * 5/9;
        return newNum;
    }

    private double convertCtoF(double num)
    {
        double newNum;
        newNum = (num * 9/5) + 32;
        return newNum;
    }
}