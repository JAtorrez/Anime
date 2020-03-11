package com.example.anime.ui.home;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.anime.R;
import com.example.anime.bd.Conexion;
import com.example.anime.ui.anime.Anime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeFragment extends Fragment {

    private WebView mwv;
    private ImageButton btniskai, btndoro, btna3;

    private Statement st;
    private ResultSet rs;
    private String a;
    private String b;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        btniskai = root.findViewById(R.id.btniq2s);
        btndoro = root.findViewById(R.id.btndhd);
        btna3 = root.findViewById(R.id.btnA3s);

        btniskai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = btniskai.getContentDescription().toString();
                b = "p";
                SegundoPlanoAnime s = new SegundoPlanoAnime(a);
                s.execute();
            }
        });
        btndoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = btndoro.getContentDescription().toString();
                b = "doro";
                SegundoPlanoAnime s1 = new SegundoPlanoAnime(a);
                s1.execute();
            }
        });
        btna3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = btna3.getContentDescription().toString();
                b = "a3";
                SegundoPlanoAnime s2 = new SegundoPlanoAnime(a);
                s2.execute();
            }
        });




        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


       /* mwv = root.findViewById(R.id.webview);
        mwv.getSettings().setJavaScriptEnabled(true);
        mwv.loadUrl("https://animeflv.net/ver/53753/tsugumomo-ova-1");*/
        return root;
    }

    public void cambio(String nombre, String sinops){
        Intent intent = new Intent(getActivity(), Anime.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("sinop", sinops);
        intent.putExtra("img", b);
        startActivity(intent);
    }


    public class SegundoPlanoAnime extends AsyncTask<String,Void, ResultSet> {


        String a;
        String nom;
        String sinop;

        public SegundoPlanoAnime(String a) {
            this.a = a;
        }

        @Override
        protected ResultSet doInBackground(String... strings) {

            try {
                Connection conn = Conexion.getConnection();
                Statement estado = conn.createStatement();
                String peticion = "select * from anime where idanime = " + a;
                ResultSet result = estado.executeQuery(peticion);
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ResultSet result) {

            try {
                if (result.first()) {
                    nom = result.getString("nombre");
                    sinop = result.getString("sinopsis");
                    cambio(nom, sinop);
                } else Log.d("Alert: ", "Resultset in first is empty");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}

