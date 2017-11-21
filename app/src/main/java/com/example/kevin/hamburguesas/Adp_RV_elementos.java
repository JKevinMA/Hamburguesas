package com.example.kevin.hamburguesas;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kevin.hamburguesas.Beans.Elemento;

import java.util.List;

/**
 * Created by kevin on 15/11/2017.
 */

public class Adp_RV_elementos extends RecyclerView.Adapter<ViewHolder>{

    List<Elemento> ListaObjeto;

    public Adp_RV_elementos(List<Elemento> listaObjeto) {
        ListaObjeto = listaObjeto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        Log.d("LONGITUD",""+ListaObjeto.size());
        return new ViewHolder(vista,ListaObjeto) ;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(ListaObjeto.get(position).getNombre());
        holder.tv_descripcion.setText(ListaObjeto.get(position).getDescripcion());
        holder.tv_tipo.setText(ListaObjeto.get(position).getTipo());

        holder.tv_precio.setText(String.format("%.2f", ListaObjeto.get(position).getPrecio()));
        holder.imagen.setImageBitmap(ListaObjeto.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return ListaObjeto.size();
    }
}
