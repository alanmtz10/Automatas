/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensamblador;

import intermedio.Cuadrupla;
import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alanm
 */
public class PrbAssembly {

    public static void main(String[] args) {
        ArrayList<Lexema> fuente = Lexema.getTablaLexema("post");
        fuente = Postfijo.convertirPostfijo(fuente);
        ArrayList<Cuadrupla> cuadruplas = Cuadrupla.generaCuadrupla(fuente);
        
        Assembly.toAssembly(cuadruplas);
    }
}
