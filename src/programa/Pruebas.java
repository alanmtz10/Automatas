/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import automatas.Automatas;
import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("programa2.txt");
        ArrayList<Lexema> palabras = separarPalabras.SeparaPalabras.separa(lineas);
        
        for (Lexema palabra : palabras) {
            System.out.println(palabra);
        }

        

    }
}
