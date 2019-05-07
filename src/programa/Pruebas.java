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

    public static String[] prbs;

    public static void main(String[] args) {
        getPalabras();
        for (String arg : prbs) {
            System.out.println(arg);
        }
    }

    public static String[] getPalabras() {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("pro.txt");
        ArrayList<Lexema> palabras = separarPalabras.SeparaPalabras.separa(lineas);

        prbs = new String[palabras.size()+2];

        for (int i = 0; i < palabras.size(); i++) {
            prbs[i] = palabras.get(i).getLexema().trim();
        }
        
        prbs[prbs.length-2] = "}";
        prbs[prbs.length-1] = "$";
        
        

        return prbs;
    }
}
