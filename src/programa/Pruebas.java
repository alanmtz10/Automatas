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
public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("programa.txt");

        for (String linea : lineas) {
            for (int i = 0; i < linea.length(); i++) {
                if ((linea.charAt(i) + "").equals("\n")) {
                    System.out.println("si");
                }
            }
        }

    }

}
