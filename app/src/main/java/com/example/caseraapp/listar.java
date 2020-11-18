package com.example.caseraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class listar extends AppCompatActivity {
    ListView animals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        animals = findViewById(R.id.listViewAnimals);
    }
}