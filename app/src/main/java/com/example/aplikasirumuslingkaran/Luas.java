package com.example.aplikasirumuslingkaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Luas extends AppCompatActivity implements View.OnClickListener{
    private EditText eJari;
    private Button bHitungL;
    private TextView thasilL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);

        eJari = findViewById(R.id.idjariL);
        bHitungL = findViewById(R.id.bhitungL);
        thasilL = findViewById(R.id.hasill);

        bHitungL.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.bhitungL);
        String inputJariL = eJari.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputJariL)){
            isEmptyFields = true;
            eJari.setError("Tidak Boleh Kosong");

        }

        Double jariL = toDouble(inputJariL);

        if (jariL == null){
            isInvalidDouble = true;
            eJari.setError("Nomor harus sesuai");

        } if (!isEmptyFields && !isInvalidDouble){
            double volume = 3.14*jariL*jariL;
            thasilL.setText(String.valueOf(volume));
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
        outState.putString(STATE_RESULT, thasilL.getText().toString());
    }
}