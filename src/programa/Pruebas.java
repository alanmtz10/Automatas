/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;
import separarPalabras.SeparaPalabras;

/**
 *
 * @author Alan
 */
public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> lineas = SeparaPalabras.leer("programa.txt");
        ArrayList<String> palabras = SeparaPalabras.separa(lineas);
        
        for (String palabra : palabras) {
            automatas.Automatas.validaPalabra(palabra);
        }
//        automatas.Automatas.validaPalabra("\"sadsad");
    }
}
