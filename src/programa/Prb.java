/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;

/**
 *
 * @author Alan
 */
public class Prb {

    public static void main(String[] args) {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("programa.txt");
        ArrayList<String> palabras = separarPalabras.SeparaPalabras.separa(lineas, automatas.Automatas.SEPARADORES);

//        palabras.forEach((String x) -> {
//            System.out.println(x);
//        });
        token(palabras);

    }

    public static void token(ArrayList<String> palabras) {
        palabras.forEach((String palabra) -> {
            boolean tabla = true;
            for (String[][] conjuntos : automatas.Automatas.TOKEN_FIJOS) {
                for (String[] conjunto : conjuntos) {
                    if (palabra.equals(conjunto[1])) {
                        System.out.println(palabra + " Token: " + conjunto[0]);
                        tabla = false;
                        break;
                    }
                }
            }
            if (tabla) {
                automatas.Automatas.recorreTabla(palabra);
            }
        });
    }
}
