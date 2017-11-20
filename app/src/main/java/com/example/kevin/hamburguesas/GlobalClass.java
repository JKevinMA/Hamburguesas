package com.example.kevin.hamburguesas;

import android.app.Application;

import com.example.kevin.hamburguesas.Beans.Elemento;

import java.util.List;

/**
 * Created by kevin on 20/11/2017.
 */

public class GlobalClass extends Application {
    private List<Elemento> ElementosTodos;
    private List<Elemento> ElementosElegidos;

    public List<Elemento> getElementosTodos() {
        return ElementosTodos;
    }

    public void setElementosTodos(List<Elemento> elementosTodos) {
        ElementosTodos = elementosTodos;
    }

    public List<Elemento> getElementosElegidos() {
        return ElementosElegidos;
    }

    public void setElementosElegidos(List<Elemento> elementosElegidos) {
        ElementosElegidos = elementosElegidos;
    }
}
