package com.ipekcoskun.sanatrehberim;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class sergi_icerik_activity extends AppCompatActivity {
    TextView txtSergiadi, txtSanatci;
    Button btnSil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sergi);
        txtSergiadi = (TextView) findViewById(R.id.txtSergiadi);
        txtSanatci = (TextView) findViewById(R.id.txtSanatci);
        btnSil = (Button) findViewById(R.id.btnSil);
    }
}
