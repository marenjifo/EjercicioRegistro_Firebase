package com.example.estudiante.ejercicioregistro_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button btn_ingresar;
    EditText et_nombre;
    EditText et_email;
    EditText et_pass;
    FirebaseDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=FirebaseDatabase.getInstance();
        btn_ingresar=findViewById(R.id.btn_ingresar);
        et_nombre=findViewById(R.id.et_nombre);
        et_email=findViewById(R.id.et_email);
        et_pass=findViewById(R.id.et_pass);



        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario =new Usuario(et_nombre.getText().toString(),et_email.getText().toString(),et_pass.getText().toString());

                db.getReference().child("usuarios").setValue(usuario);

            }
        });
    }
}
