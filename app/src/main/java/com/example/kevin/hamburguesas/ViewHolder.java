package com.example.kevin.hamburguesas;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    Button btn_add;
    TextView title,tv_precio,tv_descripcion,tv_tipo;
    ImageView imagen;
    List<Elemento> ListaObjeto;

    public ViewHolder(View itemView, List<Elemento> datos) {
        super(itemView);
        btn_add = (Button)itemView.findViewById(R.id.btn_add);
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
        Elemento objeto = ListaObjeto.get(position);
        Log.d("BOTON","SÍ");
        if (view.getId() == btn_add.getId()){
            Toast.makeText(btn_add.getContext(), "Seleccionó el botón 1 del Item "+position+" correspondiente al título "+objeto.getNombre()+" y al ID "+objeto.getId() , Toast.LENGTH_SHORT).show();
        }
    }
}
