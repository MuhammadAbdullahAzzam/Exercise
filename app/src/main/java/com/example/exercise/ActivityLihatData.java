package com.example.exercise;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    String nama;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString( "a");

        tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("08133224455");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("081225533344");
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("08122453344");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("08126633344");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("08122555344");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("08125556344");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("08199233344");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("08122233234");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("08122969344");
        }
    }
}
