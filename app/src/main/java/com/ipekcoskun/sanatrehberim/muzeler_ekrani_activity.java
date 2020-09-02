package com.ipekcoskun.sanatrehberim;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class muzeler_ekrani_activity extends AppCompatActivity {
    static Bitmap selectedImage; //static: her yerden ulaşılabilir olduğu için pek güvenilir değil tercih edilmez
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.muzeler_ekrani);

        ListView listView = findViewById(R.id.listView);
        //data

        final ArrayList<String> museumNames = new ArrayList<>();
        museumNames.add("Kocaeli Tarih Müzesi");
        museumNames.add("Kocaeli Bilim Müzesi");
        museumNames.add("Kağıt Müzesi");

        final ArrayList<String> museumAddress = new ArrayList<>();
        museumAddress.add("Şişli/İstanbul");
        museumAddress.add("Seka/Kocaeli");
        museumAddress.add("Beykoz/İstanbul");

        Bitmap tarih = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tarih);  //getResources açıkla raporda..
        Bitmap bilim = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bilim);
        Bitmap kagit = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kagit);

        final ArrayList<Bitmap> museumImages = new ArrayList<>();
        museumImages.add(tarih);
        museumImages.add(bilim);
        museumImages.add(kagit);

        //listview

        ArrayAdapter arrayAdapter = new ArrayAdapter(muzeler_ekrani_activity.this,android.R.layout.simple_list_item_1,museumNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//listener(dinleyici): bir action olduğunda dinler yapar
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //System.out.println(museumNames.get(i));
                //System.out.println(museumAddress.get(i));
                Intent intent = new Intent(getApplicationContext(),muzeler_detay.class);
                intent.putExtra("name",museumNames.get(i));
                intent.putExtra("address",museumAddress.get(i)); //intent.putExtra image gibi büyük veriler için uygun değildir
                selectedImage = museumImages.get(i);

                startActivity(intent);

            }
        });


    }
}
