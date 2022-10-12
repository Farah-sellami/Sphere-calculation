package com.sphere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCalcul , btnPeser;
    private EditText edRayon , edAire , edVol , edMassVol , edPoids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ecouteur();
    }

    private void init(){
        btnCalcul=findViewById(R.id.btnCalcul);
        btnPeser=findViewById(R.id.btnPeser);
        edRayon=findViewById(R.id.edRayon);
        edAire=findViewById(R.id.edAire);
        edVol=findViewById(R.id.edVolume);
        edMassVol=findViewById(R.id.edMassVol);
        edPoids=findViewById(R.id.edPoids);
    }

    private void ecouteur() {
        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
            }
        });
        btnPeser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peser();
            }
        });
    }

    protected void calculer() {
        if(!edRayon.getText().toString().isEmpty()){
            double rayon = Double.parseDouble(edRayon.getText().toString());
            double aire = 4 * Math.PI * Math.pow(rayon, 2);
            edAire.setText(aire + "");
            double volume = 4 * Math.PI * Math.pow(rayon, 3) / 3;
            edVol.setText(volume + "");
        } else {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Tapez un réel dans Rayon SVP!", Toast.LENGTH_LONG);
            t.show();
            edRayon.requestFocus();
        }
    }
    protected void peser() {
        if(!edVol.getText().toString().isEmpty() && (!edMassVol.getText().toString().isEmpty()))
        {
            double volume = Double.parseDouble(edVol.getText().toString());
            double masseV = Double.parseDouble(edMassVol.getText().toString());
            double poids = volume * masseV;
            edPoids.setText(poids + "");
        }
        else {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Tapez un réel dans Masse Volumique SVP!",
                    Toast.LENGTH_LONG);
            t.show();
            edMassVol.requestFocus();
        }
    }
}