package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private EditText valueA = null;
    private EditText valueB = null;
    private EditText valueC = null;
    private Button btnSol = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapComp();
        SetOnClickListener();

    }

    private void mapComp() {
        if (valueA == null)
            valueA = findViewById(R.id.valueA);
        if (valueB == null)
            valueB = findViewById(R.id.valueB);
        if (valueC == null)
            valueC = findViewById(R.id.valueC);
        if(btnSol == null)
            btnSol = findViewById(R.id.btnSol);
    }

    private void SetOnClickListener() {
        if (valueA == null)
            mapComp();
        if (valueB == null)
            mapComp();
        if (valueC == null)
            mapComp();
        if(btnSol == null)
            mapComp();
        btnSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(valueA.getText().toString());
                double B = Double.parseDouble(valueB.getText().toString());
                double C = Double.parseDouble(valueC.getText().toString());
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("getA", A);
                bundle.putDouble("getB",B);
                bundle.putDouble("getC",C);
                intent.putExtra("numSet", bundle);
                startActivity(intent);
            }
        });
    }


}
