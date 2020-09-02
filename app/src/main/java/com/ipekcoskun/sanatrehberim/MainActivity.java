package com.ipekcoskun.sanatrehberim;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.signout){

            firebaseAuth.signOut();

            Intent intentToSign = new Intent(MainActivity.this, welcome_ekrani_activity.class);
            startActivity(intentToSign);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        LinearLayout site= (LinearLayout) findViewById(R.id.konserleregit);
        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.biletix.com/category/MUSIC/DIGER/tr"));
                startActivity(intent);
            }
        });
        LinearLayout tiyatrolaragit= (LinearLayout) findViewById(R.id.tiyatrolaragit);
        tiyatrolaragit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,tiyatrolar_ekrani_activity.class);
                startActivity(intent);
            }
        });
        LinearLayout muzeleregit= (LinearLayout) findViewById(R.id.muzeleregit);
        muzeleregit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,muzeler_ekrani_activity.class);
                startActivity(intent);
            }
        });
        LinearLayout sergileregit= (LinearLayout) findViewById(R.id.sergileregit);
        sergileregit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,sergiler_ekrani_activity.class);
                startActivity(intent);
            }
        });
        LinearLayout yer= (LinearLayout) findViewById(R.id.yerleregit);
        yer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, yerler_activity.class);
              startActivity(intent);
            }
        });


    }
}
