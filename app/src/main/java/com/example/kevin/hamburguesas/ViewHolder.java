package com.example.kevin.hamburguesas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevin.hamburguesas.Beans.Elemento;

import java.util.List;

/**
 * Created by kevin on 15/11/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title,tv_precio,tv_descripcion,tv_tipo;
    ImageView imagen;
    List<Elemento> ListaObjeto;

    public ViewHolder(View itemView, List<Elemento> datos) {
        super(itemView);

        title = (TextView)itemView.findViewById(R.id.title);
        tv_precio = (TextView)itemView.findViewById(R.id.tv_precio);
        tv_descripcion = (TextView)itemView.findViewById(R.id.tv_descripcion);
        tv_tipo=(TextView)itemView.findViewById(R.id.tv_tipo);
        imagen = (ImageView)itemView.findViewById(R.id.imagen);
        ListaObjeto = datos;
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
//        Fuente objeto = ListaObjeto.get(position);
//        if (view.getId()==btn1.getId()){
//            Toast.makeText(btn1.getContext(), "Seleccionó el botón 1 del Item "+position+" correspondiente al título "+objeto.getTitulo() , Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(btn1.getContext(), "Seleccionó el botón 2 del Item "+position+" correspondiente al título "+objeto.getTitulo(), Toast.LENGTH_SHORT).show();
//        }
    }
}
