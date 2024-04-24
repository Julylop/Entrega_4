package com.juliana.entrega_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnInsertar, btnMostrar;
    EditText nombre, cargo,correo;
    DatabaseReference databaseUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertar= findViewById(R.id.btnInsertar);
        btnMostrar = findViewById(R.id.btnMostrar);
        nombre = findViewById(R.id.edtnombre);
        cargo = findViewById(R.id.edtcargo);
        correo = findViewById(R.id.edtcorreo);
        databaseUsuario = FirebaseDatabase.getInstance().getReference();


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Userlist.class));
                finish();
            }
        });

    }

    private void InsertData() {

        String usernombre = nombre.getText().toString();
        String usercargo = cargo.getText().toString();
        String usercorreo = correo.getText().toString();
        String id = databaseUsuario.push().getKey();


        Usuario usuario = new Usuario(usernombre, usercargo,usercorreo);
        databaseUsuario.child("usuarios").child(id).setValue(usuario)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Detalles del empleado insertados", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }




}