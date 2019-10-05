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

        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("fuentes/cuadrupla2.txt");
        TablaSimbolo ts = Simbolo.getTablasDeSimbolos(tablaLexema);
        ArrayList<Cuadrupla> cuadruplas = Cuadrupla.getCuadruplas(ts);
        for (Cuadrupla cuadrupla : cuadruplas) {
            System.out.println(cuadrupla);
        }
        System.out.println("\n");
        CIntermedio.generaCodigoIntermedio(tablaLexema);
        CIntermedio.imprimeEtiquetas();
    }
}
