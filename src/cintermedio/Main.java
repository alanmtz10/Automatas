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

        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("fuentes/cuadruplas.txt");
        TablaSimbolo tablaGlobal = Simbolo.getTablasDeSimbolos(tablaLexema);

        ArrayList<Cuadrupla> cuadruplas = Cuadrupla.getCuadruplas(tablaGlobal);
        System.out.println("(Operacion, Operando1, Operando2, Resultado)");

        for (Cuadrupla cuadrupla : cuadruplas) {
            System.out.println(cuadrupla);
        }

    }
}
