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

        ArrayList<Lexema> tablaOrdenada = Postfijo.convertirPostfijo(tablaLexema);

        for (Lexema lexema : tablaOrdenada) {
            System.out.println(lexema);
        }

        Lexema res = Postfijo.evaluar(tablaOrdenada);

        System.out.println(res);

    }
}
