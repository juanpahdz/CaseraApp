package com.example.caseraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.caseraapp.model.animal;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText nombre, edad, descripcion;
    Button send, list;
    private String TAG = "LFNOT";
    private animal model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editTextNombre);
        edad = findViewById(R.id.editTextEdad);
        descripcion = findViewById(R.id.editTextDescripcion);
        send = findViewById(R.id.buttonSend);
        list = findViewById(R.id.buttonList);

        send.setOnClickListener(new View.OnClickListener() {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            @Override
            public void onClick(View view) {
                final String nombreAnimal = nombre.getText().toString();
                int edadAnimal = Integer.parseInt(edad.getText().toString());
                String descripcionAnimal = descripcion.getText().toString();

                animal animalModel = new animal(nombreAnimal, edadAnimal, descripcionAnimal);

                        db.collection("animals")
                                .add(animalModel)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                        Toast.makeText(getApplicationContext(), "" + nombreAnimal + " fue Registrado Correctamente", Toast.LENGTH_SHORT).show();

                                        nombre.setText("");
                                        edad.setText("");
                                        descripcion.setText("");

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listar.class);
                startActivity(intent);
            }
        });
    }



}