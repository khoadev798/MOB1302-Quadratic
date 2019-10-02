package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {
    private EditText txtResult = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        mapping();
        Bundle bundle = getIntent().getBundleExtra("numSet");
        double valueA = bundle.getDouble("getA");
        double valueB = bundle.getDouble("getB");
        double valueC = bundle.getDouble("getC");
        //Vô nghiệm
        if(valueA==0 && valueB==0 && valueC!=0){
            txtResult.setText("Phương trình vô nghiệm");
        }
        //Vô số nghiệm
        else if(valueA==0 && valueB==0 && valueC==0){
            txtResult.setText("Phương trình vô số nghiệm");
        }

        else if(valueA==0){
        txtResult.setText("Nghiệm của phương trình là: " + (-valueC)/valueB);
        }
        else{
            double delta = Math.pow(valueB,2) - 4*valueA*valueC;
            if(delta<0){
                txtResult.setText("Phương trình vô nghiệm!");
            }
            else if(delta == 0){
                double x1 = (-valueB) / (2 * valueA);
                txtResult.setText("Phương trình có 2 nghiệm bằng nhau x1=x2="+x1);
            }
            else {
                double x1 = ((-valueB) + Math.sqrt(delta)) / 2 * valueA;
                double x2 = ((-valueB) - Math.sqrt(delta)) / 2 * valueA;
                txtResult.setText("Phương trình có 2 nghiệm là x1=" + x1 + ", x2=" + x2);
            }
        }
    }
    private void mapping(){
        if(txtResult==null)
            txtResult = findViewById(R.id.txtResult);
    }
}
