package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;
    TextView register;
    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin = findViewById(R.id.btSignIn);
        register = (TextView) findViewById(R.id.register);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword = findViewById(R.id.edPassword);

        //membuat fingfi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edemail.getText().toString();
                String password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123456";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email & Password wajib Diisi!",
                            Toast.LENGTH_LONG);
                    edemail.setError("Email Harus Diisi!!!");
                    edpassword.setError("Password Harus Diisi!!!");
                    t.show();
                }
                if (nama.equals("admin@mail.com") && password.equals("123456")) {
                    //jika login berhasil
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();
                    //membuat objek bundle
                    Bundle b = new Bundle();
                    //memasukkan value dari variabel nama dengan kunci "a"
                    // dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variable password dengan kunci "b"
                    // dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);

                } else if (!nama.equals("admin@mail.com") && password.equals("123456")) {
                    //jika email salah
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email salah", Toast.LENGTH_LONG);
                    t.show();
                } else if (nama.equals("admin@mail.com") && !password.equals("123456")) {
                    //jika password salah
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password salah", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    //jika email dan password salah
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password salah", Toast.LENGTH_LONG);
                    t.show();


                }
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to DaftarActivity
                Intent intent = new Intent(getApplicationContext(), DaftarActivity.class);
                startActivity(intent);
            }
        });
    }
}