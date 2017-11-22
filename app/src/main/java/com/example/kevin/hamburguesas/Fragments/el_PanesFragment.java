package com.example.kevin.hamburguesas.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kevin.hamburguesas.Adp_RV_elementos;
import com.example.kevin.hamburguesas.Beans.Elemento;
import com.example.kevin.hamburguesas.GlobalClass;
import com.example.kevin.hamburguesas.R;

import java.util.ArrayList;
import java.util.List;


public class el_PanesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_el_panes, container, false);

        List<Elemento> lista = GlobalClass.getElementosPanes();

        RecyclerView contenedor = (RecyclerView)v.findViewById(R.id.cont_el_panes);
        contenedor.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        contenedor.setAdapter(new Adp_RV_elementos(lista));
        contenedor.setLayoutManager(layout);
        return v;
    }
}
