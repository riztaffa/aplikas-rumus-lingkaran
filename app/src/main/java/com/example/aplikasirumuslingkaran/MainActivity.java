package com.example.aplikasirumuslingkaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int req_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnkelilingA = findViewById(R.id.idkeliling);
        btnkelilingA.setOnClickListener(this);

        Button btnluasA = findViewById(R.id.idluas);
        btnluasA.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.idkeliling:
                Intent moveIntent = new Intent(MainActivity.this, Keliling2.class);
                startActivity(moveIntent);
                break;
            case R.id.idluas:
                Intent data = new Intent(MainActivity.this, Luas1.class);
                startActivityForResult(data, req_code);
        }
    }
 public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.viewluas);
                hasilnama.setText(data.getData().toString());
            }
        }
 }
}