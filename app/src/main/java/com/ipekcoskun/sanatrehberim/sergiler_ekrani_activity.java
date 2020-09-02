package com.ipekcoskun.sanatrehberim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class sergiler_ekrani_activity extends AppCompatActivity {
    Context context = this;
   ListView listemiz;
   List<Sergi> list;
   SQLiteHelper db = new SQLiteHelper(context);
   ArrayAdapter<String> mAdapter;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sergiler_ekrani);
        listemiz = findViewById(R.id.listemiz);
        db.onUpgrade(db.getWritableDatabase(),1,2);
        db.SergiEkle(new Sergi("Flux","Marina Abramovic"));
        db.SergiEkle(new Sergi("Misafirler:Sanatçılar ve Zanaatkarlar","Rana Begum"));
        db.SergiEkle(new Sergi("Bir Zamanlar Toros'larda","TC.Kültür Bakanlığı"));
        list = db.sergileriGetir();
        List<String> listSergiadi = new ArrayList<>();
        for (int i=0; i<list.size();i++){
            listSergiadi.add(i,list.get(i).getSergiadi());
        }
        mAdapter = new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.listMetin,listSergiadi);
        listemiz.setAdapter(mAdapter);
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(context, sergi_icerik_activity.class);
                intent.putExtra("sergiadi",list.get(position).getId());
                Log.i("idimiz",String.valueOf(list.get(position).getId()));
                startActivityForResult(intent,1);
            }
        });
    }
}
