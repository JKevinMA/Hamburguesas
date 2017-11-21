package com.example.kevin.hamburguesas;

import android.app.Application;
import android.util.Log;

import com.example.kevin.hamburguesas.Beans.Elemento;

import java.util.List;

/**
 * Created by kevin on 20/11/2017.
 */

public class GlobalClass extends Application {
    private static List<Elemento> ElementosTodos;
    private static List<Elemento> ElementosElegidos;

    private static List<Elemento> ElementosPanes;
    private static List<Elemento> ElementosPrincipales;
    private static List<Elemento> Elementosaniadidos;

    public static List<Elemento> getElementosTodos() {
        return ElementosTodos;
    }

    public static void setElementosTodos(List<Elemento> elementosTodos) {
        ElementosTodos = elementosTodos;
        dividir(ElementosTodos);
    }

    public static List<Elemento> getElementosElegidos() {
        return ElementosElegidos;
    }

    public static void setElementosElegidos(List<Elemento> elementosElegidos) {
        ElementosElegidos = elementosElegidos;
    }

    public static void dividir(List<Elemento> elementosTodos){
        Log.d("SizeTODO: ",""+elementosTodos.size());
        for (int i=0;i<elementosTodos.size();i++){
            if (elementosTodos.get(i).getTipo()=="Pan"){
            }
            else if (elementosTodos.get(i).getTipo()=="Principal"){
                ElementosPrincipales.add(elementosTodos.get(i));
            }
            else if (elementosTodos.get(i).getTipo()=="Añadidos"){
                Elementosaniadidos.add(elementosTodos.get(i));
            }
        }
    }

    public static List<Elemento> getElementosPanes() {
        return ElementosPanes;
    }

    public static List<Elemento> getElementosPrincipales() {
        return ElementosPrincipales;
    }

    public static List<Elemento> getElementosaniadidos() {
        return Elementosaniadidos;
    }
}
