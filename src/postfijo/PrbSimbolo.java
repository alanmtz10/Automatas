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
 * @author Alan
 */
public class PrbSimbolo {

    public static void main(String[] args) {

        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("declaraciones.txt");

        ArrayList<Simbolo> tablaSimbolos = Simbolo.getTablaSimbolos(tablaLexema);

        for (Simbolo tablaSimbolo : tablaSimbolos) {
            System.out.println(tablaSimbolo);
        }
//        for (Lexema l : tablaLexema) {
//            System.out.println(l);
//        }

    }

}