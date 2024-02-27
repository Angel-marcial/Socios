package com.example.socios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tieUsuario ;
    EditText tidPasswd;
    ImageButton imbtIngresar;
    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tieUsuario = findViewById(R.id.tieUsuario);
        tidPasswd = findViewById(R.id.tidPasswd);
        imbtIngresar = findViewById(R.id.imbtIngresar);
        tvDatos = findViewById(R.id.tvDatos);

        imbtIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (tieUsuario.getText().toString().equals("Angel") && tidPasswd.getText().toString().equals("Marcial") ){
                    Toast.makeText(MainActivity.this,"usuario valido",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                    tieUsuario.setError("usuario incorrecto");
                    tidPasswd.setError("contraseña incorrecta");

                    tvDatos.setText(tieUsuario.getText() + "\n" + tidPasswd.getText());


                }

            }
        });

    }
}