/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Prb {

    public static void main(String[] args) {
        ArrayList<Lexema> fuente = Lexema.getTablaLexema("post");

        fuente = Postfijo.convertirPostfijo(fuente);
//        
//        for (Lexema lexema : fuente) {
//            System.out.print(lexema.getLexema()+" ");
//        }

        Arbol.construyeArbol(fuente);

    }

}
