/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Prbs {

    public static void main(String[] args) {
        ArrayList<Lexema> tabla = Lexema.getTablaLexema("operaciones.txt");
        
        tabla = Postfijo.convertirPostfijo(tabla);
        
        

        for (Lexema lexema : tabla) {
            System.out.println(lexema);
        }
        
        System.out.println("----------------------------------");
        
        System.out.println(Postfijo.evaluar(tabla));

    }

}
