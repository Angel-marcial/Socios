package com.example.socios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] imageIds = {R.drawable.group, R.drawable.group, R.drawable.group}; // Reemplaza con tus recursos de imágenes
    private int currentPage = 0;
    private static final long DELAY_MS = 3000; // 3 segundos
    private Handler handler;


    EditText tieUsuario ;
    EditText tidPasswd;
    ImageButton imbtIngresar;
    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tieUsuario = findViewById(R.id.tieUsuario);
        tidPasswd = findViewById(R.id.tidPasswd);
        imbtIngresar = findViewById(R.id.imbtIngresar);
        tvDatos = findViewById(R.id.tvDatos);

        ImagePagerAdapter adapter = new ImagePagerAdapter(this, imageIds);
        viewPager.setAdapter(adapter);

        handler = new Handler();
        startAutoPager();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                stopAutoPager();
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

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

    private void startAutoPager() {
        handler.postDelayed(autoPager, DELAY_MS);
    }

    private void stopAutoPager() {
        handler.removeCallbacks(autoPager);
    }

    private final Runnable autoPager = new Runnable() {
        public void run() {
            if (currentPage == imageIds.length - 1) {
                currentPage = 0;
            } else {
                currentPage++;
            }
            viewPager.setCurrentItem(currentPage, true);
            startAutoPager();
        }
    };

}