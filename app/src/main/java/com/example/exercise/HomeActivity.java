package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasi variabel dengan jenis data listview
    private ListView list;
    //Memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;
    //Deklarasi array untuk menyimpan nama
    String[] listNama;
    //Memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    //Membuat objek Bundle
    Bundle bundle = new Bundle();
    //Membuat objek intent
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Menyimpan nama didalam array listNama
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};
        list = findViewById(R.id.ListKontak);
        //membuat objek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();
        //Membaca seluruh data pada array listNama
        for (int i = 0; i < listNama.length; i++)
        {
            //Membuat objek class nama da
            ClassNama classNama = new ClassNama(listNama[i]);
            // Binds string ke array
            classNamaArrayList.add(classNama);
        }
        // Membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);
        // Binds Adapter ke listView
        list.setAdapter(adapter);
        //Membuat event dari onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();
                //memasukkan value dari variabel nama dengan kunci "a"
                // dan dimasukkan kedalam bundle
                bundle.putString("a",nama.trim());
                //Membuat onjek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                // Membuat event untukk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(HomeActivity.this);
                //Menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup);
                //Menampilkan popup menu
                pm.show();
            }
        });
    }
    //event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}