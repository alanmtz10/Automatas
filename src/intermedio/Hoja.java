/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Hoja {

    private Lexema valor;

    private Hoja padre;
    private Hoja izquierda;
    private Hoja derecha;

    /**
     * Izquierda -- Derecha
     */
    private ArrayList<Etiqueta> etiquetas;

    public Hoja(Lexema h, Hoja izquierda, Hoja derecha) {
        this.valor = h;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Hoja(Lexema h, Hoja padre) {
        this.valor = h;
        this.padre = padre;
    }

    public Lexema getValor() {
        return valor;
    }

    public void setValor(Lexema h) {
        this.valor = h;
    }

    public Hoja getPadre() {
        return padre;
    }

    public void setPadre(Hoja padre) {
        this.padre = padre;
    }

    public Hoja getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Hoja izquierda) {
        this.izquierda = izquierda;
    }

    public Hoja getDerecha() {
        return derecha;
    }

    public void setDerecha(Hoja derecha) {
        this.derecha = derecha;
    }

}
