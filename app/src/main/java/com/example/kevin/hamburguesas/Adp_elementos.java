package com.example.kevin.hamburguesas;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevin.hamburguesas.Beans.Elemento;

import java.util.List;

public class Adp_elementos extends ArrayAdapter {

	public Adp_elementos(Context context, int resource, List datos) {
		super(context, resource, datos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	if(convertView==null){
	//no hay ningun item en el adaptador-vista
	LayoutInflater inflar=(LayoutInflater)parent.getContext().
			getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//relacionarlo con la vista que contiene los controles
	convertView=inflar.inflate(R.layout.elemento, null);
	}
	//relacionar con los datos o registros 
	Elemento item=(Elemento) getItem(position);
	//mapea o castea los controles para asignar los datos en cada control
	TextView tv_nombre=(TextView)convertView.findViewById(R.id.tv_nombre);
	TextView tv_precio=(TextView)convertView.findViewById(R.id.tv_precio);
	TextView tv_tipo=(TextView)convertView.findViewById(R.id.tv_tipo);
	TextView tv_descripcion=(TextView)convertView.findViewById(R.id.tv_descripcion);
	ImageView imgv=(ImageView)convertView.findViewById(R.id.imgv);

		//asignar los datos
		tv_nombre.setText(item.getNombre());
		tv_precio.setText(""+item.getPrecio());
		tv_tipo.setText(item.getTipo());
		tv_descripcion.setText(item.getDescripcion());
		imgv.setImageBitmap(item.getImagen());
		return convertView;
	}

}
