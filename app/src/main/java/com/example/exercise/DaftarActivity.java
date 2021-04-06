package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {
    //deklarasi variabel
    EditText edtxNama, edtxAlamat, edtxEmail, edtxPassword, edtxrepass,

    //textview
    edtxJenis, edtxAgama;

    //deklarasi button
    Button btnbatal, btndaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtxNama = findViewById(R.id.edName);
        edtxAlamat = findViewById(R.id.edAlamat);
        edtxEmail = findViewById(R.id.edEmail);
        edtxPassword = findViewById(R.id.edPass);
        edtxrepass = findViewById(R.id.edrepass);
        btnbatal = findViewById(R.id.btnbatal);
        btndaftar = findViewById(R.id.btndaftar);
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtxNama.getText().toString().isEmpty() ||
                        edtxAlamat.getText().toString().isEmpty() ||
                        edtxEmail.getText().toString().isEmpty() ||
                        edtxPassword.getText().toString().isEmpty() ||
                        edtxrepass.getText().toString().isEmpty()) {
                    Snackbar.make(v, "WAJIB!!! (Mengisikan Seluruh Data)", Snackbar.LENGTH_LONG).show();
                } else {
                    if (edtxPassword.getText().toString().equals(edtxrepass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Pendaftaran yang Dilakukan Berhasil",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Snackbar.make(v, "Password pertama dan Password kedua harus sama !!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}


