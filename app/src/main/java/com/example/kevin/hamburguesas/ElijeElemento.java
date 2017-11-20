package com.example.kevin.hamburguesas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kevin.hamburguesas.Beans.Elemento;

import java.util.ArrayList;
import java.util.List;

public class ElijeElemento extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elije_elemento);
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        List<Elemento> lista = globalVariable.getElementosTodos();

        RecyclerView contenedor = (RecyclerView)findViewById(R.id.contenedor);
        contenedor.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        contenedor.setAdapter(new Adp_RV_elementos(lista));
        contenedor.setLayoutManager(layout);
    }


}
