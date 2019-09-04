/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class PrbPostfijo {

    public static void main(String[] args) {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("operaciones.txt");
        ArrayList<Lexema> tablaLexema = separarPalabras.SeparaPalabras.separa(lineas);

        for (Lexema tablaLexema1 : tablaLexema) {
            System.out.println(tablaLexema1);
        }

        ArrayList<Lexema> tablaOrdenada = Postfijo.convertirPostfijo(tablaLexema);

        System.out.println("---------------------");

        for (Lexema tablaOrdenada1 : tablaOrdenada) {
            System.out.println(tablaOrdenada1);
        }

    }
}
