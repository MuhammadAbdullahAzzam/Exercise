package com.example.exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor Listviewadapter
    public ListViewAdapter(Context context) {
        //Memberi nilai mContext dengan context
        mContext = context;

        //mengatur LayoutInflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arraylist dari class Classnama
        this.arrayList = new ArrayList<ClassNama>();

        //Menambahkah semua elemen ke arraylist
        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }

    //membuat class untuk mendeklerasikan tempat untuk meletakkan isi kedalam listview
    public class ViewHolder {
        //Mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //fungsi getCount () mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return HomeActivity.classNamaArrayList.size();
    }

    //fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    // tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari Lokasi
    // tertentu dalam pengumpulan data item.
    @Override
    public Object getItem(int i) {
        //mengembalikan niilai berupa objek dari array data
        return HomeActivity.classNamaArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi item ke adaptor
    @Override
    public long getItemId(int i) {
        return i;
    }

    //fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    // ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view == null) {

            //membuat objek view holder
            holder = new ViewHolder();

            //membuat Layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        } else {
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        // Set Item ke TextViews
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getName());

        //mengembalikan nilai ke variabel view
        return view;
    }
}