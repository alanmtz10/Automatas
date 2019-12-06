/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fix;

import java.util.ArrayList;
import lexema.Lexema;
import intermedio.Cuadrupla;

/**
 *
 * @author Alan
 */
public class Prb {

    private static ArrayList<Lexema> listaLexemas;
    private static ArrayList<Cuadrupla> listaCuadruplas;
    private static ArrayList<Variable> listaVariables;

    public static void main(String[] args) {
        listaLexemas = Lexema.getTablaLexema("fuentes/codinter.txt");
        Object[] objs = CodigoIntermedio.generaCodigoIntermedio(listaLexemas);
        listaCuadruplas = (ArrayList<Cuadrupla>) objs[0];
        listaVariables = (ArrayList<Variable>) objs[1];
        Ensamblador.toAssembly(listaVariables, listaCuadruplas);
    }
}
