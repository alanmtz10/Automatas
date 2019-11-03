/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio2;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Prb {
    
    public static void main(String[] args) {
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("fuentes/programa2.txt");
        
        for (Lexema lexema : tablaLexema) {
            System.out.println(lexema);
        }
        
        AnalizadorSintactico.analiza(tablaLexema);
    }
}
