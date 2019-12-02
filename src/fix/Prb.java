/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fix;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Prb {

    private static ArrayList<Lexema> listaLexemas;

    public static void main(String[] args) {
        listaLexemas = Lexema.getTablaLexema("fuentes/codinter.txt");
        for (Lexema l : listaLexemas) {
            System.out.println(l);
        }
    }
}
