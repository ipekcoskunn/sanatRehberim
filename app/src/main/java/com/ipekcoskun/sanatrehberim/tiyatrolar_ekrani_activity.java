package com.ipekcoskun.sanatrehberim;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class tiyatrolar_ekrani_activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    ArrayList<String> userEmailFromFB;
    ArrayList<String> userCommentFromFB;
    ArrayList<String> userOyunAdiFromFB;
    ArrayList<String> userKurumAdiFromFB;
    ArrayList<String> userImageFromFB;
    TiyatroRecyclerAdapter tiyatroRecyclerAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.guncel_tiyatro_options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.upload){
            Intent intentToUpload = new Intent(tiyatrolar_ekrani_activity.this,GuncelTiyatroActivity.class);
            startActivity(intentToUpload);
        }
        else if (item.getItemId() == R.id.signout){
            firebaseAuth.signOut();
            Intent intentToSignUp = new Intent(tiyatrolar_ekrani_activity.this,welcome_ekrani_activity.class);
            startActivity(intentToSignUp);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiyatrolar_ekrani);

        userCommentFromFB = new ArrayList<>();
        userEmailFromFB = new ArrayList<>();
        userImageFromFB = new ArrayList<>();
        userOyunAdiFromFB = new ArrayList<>();
        userKurumAdiFromFB = new ArrayList<>();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        getDataFromFirestore();

        //RecyclerView tanımlıycaz

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tiyatroRecyclerAdapter = new TiyatroRecyclerAdapter(userEmailFromFB,userCommentFromFB,userImageFromFB,userOyunAdiFromFB,userKurumAdiFromFB);
        recyclerView.setAdapter(tiyatroRecyclerAdapter);
    }

    public void getDataFromFirestore(){
       CollectionReference collectionReference = firebaseFirestore.collection("Posts");

       collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
           //descending date'e göre sırala verileri
           @Override
           public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

               if(e != null){
                   Toast.makeText(tiyatrolar_ekrani_activity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

               }
               if (queryDocumentSnapshots !=null){
                   for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()){
                       Map<String,Object> data = snapshot.getData();

                       //Casting
                       String comment = (String) data.get("comment");
                       String oyunAdi = (String) data.get("oyunAdi");
                       String kurumAdi = (String) data.get("kurumAdi");
                       String userEmail = (String) data.get("useremail");
                       String downloadUrl = (String) data.get("downloadurl");

                       userCommentFromFB.add(comment);
                       userEmailFromFB.add(userEmail);
                       userImageFromFB.add(downloadUrl);
                       userOyunAdiFromFB.add(oyunAdi);
                       userKurumAdiFromFB.add(kurumAdi);

                       tiyatroRecyclerAdapter.notifyDataSetChanged();

                   }
               }

           }
       });
    }

}
