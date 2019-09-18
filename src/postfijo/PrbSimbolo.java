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

        /**
         * Tabla de lexemas
         */
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("declaraciones.txt");

        /**
         * Tabla de simbolos
         */
//        ArrayList<Simbolo> tablaSimbolos = Simbolo.getTablaSimbolos(tablaLexema);
//        Simbolo.convertirValorPostfijo(tablaSimbolos);
//        Postfijo.evaluarTabla(tablaSimbolos);
        for (Lexema lexema : tablaLexema) {
            System.out.println(lexema);
        }

        Simbolo.getTablasDeSimbolos(tablaLexema);
    }

}
