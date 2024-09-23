package com.example.lab3bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtC, txtF;
    EditText edtC, edtF;
    Button btnFar, btnCel, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtC = findViewById(R.id.txtC);
        txtF = findViewById(R.id.txtF);
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnFar = findViewById(R.id.btnFar);
        btnCel = findViewById(R.id.btnCel);
        btnReset = findViewById(R.id.btnReset);
        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCtoF();
            }
        });

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFtoC();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }


    private void convertCtoF() {
        String celsiusStr = edtC.getText().toString();
        if (!celsiusStr.isEmpty()) {
            double celsius = Double.parseDouble(celsiusStr);
            double fahrenheit = (celsius * 9/5) + 32;
            edtF.setText(String.format("%.2f", fahrenheit));
        }
    }

    private void convertFtoC() {
        String fahrenheitStr = edtF.getText().toString();
        if (!fahrenheitStr.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitStr);
            double celsius = (fahrenheit - 32) * 5/9;
            edtC.setText(String.format("%.2f", celsius));
        }
    }

    private void resetFields() {
        edtC.setText("");
        edtF.setText("");
    }

}