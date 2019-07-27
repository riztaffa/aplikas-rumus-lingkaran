package com.example.aplikasirumuslingkaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnvolumeA = findViewById(R.id.idkeliling);
        btnvolumeA.setOnClickListener(this);

        Button btnluasA = findViewById(R.id.idluas);
        btnluasA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.idkeliling:
                Intent moveIntent = new Intent(MainActivity.this, Keliling.class);
                startActivity(moveIntent);
                break;
            case R.id.idluas:
                Intent moveIntentA = new Intent(MainActivity.this, Luas.class);
                startActivity(moveIntentA);
        }
    }
}