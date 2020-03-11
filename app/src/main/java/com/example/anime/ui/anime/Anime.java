package com.example.anime.ui.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anime.R;

public class Anime extends AppCompatActivity {

    private TextView lbnombre, lbsinop;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        lbnombre = findViewById(R.id.lbnombre);
        img = findViewById(R.id.IVportada);
        lbsinop = findViewById(R.id.lbsinopsis);

        String nombre = getIntent().getStringExtra("nombre");
        String imgen = getIntent().getStringExtra("img");
        String sinop = getIntent().getStringExtra("sinop");
        lbnombre.setText(nombre);
        lbsinop.setText(sinop);


        //imagen
        if(imgen.equals("p")) {
            img.setImageResource(R.drawable.p);
        }else if(imgen.equals("doro")){
            img.setImageResource(R.drawable.doro);
        }else if(imgen.equals("a3")){
            img.setImageResource(R.drawable.a3);
        }


    }
}
