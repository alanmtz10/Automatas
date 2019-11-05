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
public class Arbol {

    private Hoja raizArbol;

    public Arbol() {
    }

    public Hoja getRaiz() {
        return raizArbol;
    }

    public void setRaiz(Hoja raiz) {
        this.raizArbol = raiz;
    }

    public static Arbol construyeArbol(ArrayList<Lexema> fuente) {
        Arbol arbol = new Arbol();
        Hoja raiz = null;

        for (int i = (fuente.size() - 1); i >= 0; i--) {

            raiz = arbol.addNodo(fuente.get(i), raiz);

        }

        return arbol;
    }

    public Hoja addNodo(Lexema c, Hoja raiz) {
        Hoja aux;

        if (raiz == null) {
            raizArbol = new Hoja(c, null);
            return raizArbol;
        } else {
            if (raiz.getValor().isOperador() && raiz.getDerecha() == null) {
                aux = new Hoja(c, raiz);
                raiz.setDerecha(aux);
                return aux;
            } else if (raiz.getValor().isOperador() && raiz.getIzquierda() == null) {
                aux = new Hoja(c, raiz);
                raiz.setIzquierda(aux);
                return aux;
            } else {
                return addNodo(c, raiz.getPadre());
            }
        }
    }

    public void imprimeArbol(Hoja inicio) {
        if (inicio.getIzquierda() != null) {
            imprimeArbol(inicio.getIzquierda());
        }
        System.out.println(inicio.getValor());
        if (inicio.getDerecha() != null) {
            imprimeArbol(inicio.getDerecha());
        }
    }

    

}
