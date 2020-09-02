package com.ipekcoskun.sanatrehberim;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class yerler_activity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //menüyü bağladık
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_place, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //menüye tıklandığında ne olacağını belirtiyoruz
        if(item.getItemId() == R.menu.add_place) { //tıklanılan menu add_place menusu ise
            Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.yerler_ekrani);

        ListView listView = (ListView) findViewById(R.id.listView);
    }

}
