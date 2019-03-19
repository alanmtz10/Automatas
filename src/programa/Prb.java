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
        
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}
