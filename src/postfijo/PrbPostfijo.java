/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class PrbPostfijo {

    public static void main(String[] args) {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("operaciones.txt");
        ArrayList<Lexema> tablaLexema = separarPalabras.SeparaPalabras.separa(lineas);

        Postfijo p = new Postfijo(tablaLexema);

//        p.imprimeTablaLexema();
        System.out.println(p.getPostfijoExp());
    }
}
