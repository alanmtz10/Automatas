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
 * @author alan
 */
public class PrbPostfijo {

    public static void main(String[] args) {
        
        /**
         * Tabla de lexemas
         */
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("operaciones.txt");

        /***
         * Tabla de lexemas en notacion postfija
         */
        ArrayList<Lexema> tablaOrdenada = Postfijo.convertirPostfijo(tablaLexema);

        for (Lexema lexema : tablaOrdenada) {
            System.out.print(lexema.getLexema());
        }
        System.out.println("----------------");

        Lexema res = Postfijo.evaluar(tablaOrdenada);

        System.out.println(res);

    }
}
