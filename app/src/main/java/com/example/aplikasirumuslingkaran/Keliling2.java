package com.example.aplikasirumuslingkaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Keliling2 extends AppCompatActivity implements View.OnClickListener {
    private EditText eJari;
    private Button bHitung;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keliling2);

        eJari = findViewById(R.id.idjari2);
        bHitung = findViewById(R.id.idhitung2);
        tHasil = findViewById(R.id.idhasil2);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tHasil.setText(result);
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.idhitung2);
        String inputJari = eJari.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputJari)){
            isEmptyFields = true;
            eJari.setError("Tidak Boleh Kosong");
        }
        Double jari = toDouble(inputJari);

        if (jari == null){
            isInvalidDouble = true;
            eJari.setError("Nomor harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double keliling = jari * 3.14 * 2;
            tHasil.setText(String.valueOf(keliling));
        }
    }


    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }
}
