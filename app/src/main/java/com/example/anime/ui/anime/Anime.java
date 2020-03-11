package com.example.anime.ui.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anime.R;

public class Anime extends AppCompatActivity {

    private TextView lbnombre;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        lbnombre = findViewById(R.id.lbnombre);
        img = findViewById(R.id.IVportada);
        String nombre = getIntent().getStringExtra("nombre");
        lbnombre.setText(nombre);
        String imgen = getIntent().getStringExtra("img");

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
