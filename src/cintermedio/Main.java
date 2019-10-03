/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Simbolo;
import postfijo.TablaSimbolo;

/**
 *
 * @author alan
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Programa fuente en lexemas
         */
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("declaraciones.txt");

        /**
         * Tablas de variables globales y locales en notacion postfija
         */
        TablaSimbolo tablaGlobal = Simbolo.getTablasDeSimbolos(tablaLexema);

        tablaGlobal.imprime(0);
    }
}
