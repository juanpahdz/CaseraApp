package com.example.caseraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.caseraapp.adapters.animalAdapter;
import com.example.caseraapp.model.animal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class listar extends AppCompatActivity {
    ListView lv_animals;
    private String TAG = "LFNOT";
    private animal model;
    private ArrayList<animal> list;
    ListAdapter animalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        lv_animals = findViewById(R.id.listViewAnimals);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        list = new ArrayList<>();


        db.collection("animals")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                model = document.toObject(animal.class);
                                list.add(model);
                            }
                            animalAdapter = new animalAdapter(getApplicationContext(), R.layout.item_row , list);
                            lv_animals.setAdapter(animalAdapter);

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}