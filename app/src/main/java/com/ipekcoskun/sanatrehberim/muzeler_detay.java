package com.ipekcoskun.sanatrehberim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.ipekcoskun.sanatrehberim.muzeler_ekrani_activity.selectedImage;

public class muzeler_detay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muzeler_detay);

        ImageView imageView = findViewById(R.id.imageViewMuseum);
        TextView museumNameText = findViewById(R.id.museumNameText);
        TextView museumAddressText = findViewById(R.id.museumAddressText);

        Intent intent = getIntent();
        String museumName = intent.getStringExtra("name");
        String museumAddress = intent.getStringExtra("address");//put koydu get aldı
        museumNameText.setText(museumName);
        museumAddressText.setText(museumAddress);

        imageView.setImageBitmap(selectedImage);
    }
}
