/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensamblador;

import intermedio.Cuadrupla;
import java.util.ArrayList;

/**
 *
 * @author alanm
 */
public class Assembly {

    public static final String encabezado = "TITLE operaciones"
            + "\n.MODEL SMALL"
            + "\n.STACK 64"
            + "\n.DATA";

    public static final String codigo = ".CODE";
    public static final String fin = ".EXIT";
    public static final String defWord = ":var DW ?";

    public static final String suma = "MOV AX, :var1"
            + "\nMOV CX, :var2"
            + "\nADD AX,CX"
            + "\nMOV :res, AX";

    public static void toAssembly(ArrayList<Cuadrupla> cuadruplas) {
        String aux;
        System.out.println(encabezado);
        for (int i = 0; i < cuadruplas.size(); i++) {
            System.out.println(defWord.replace(":var", cuadruplas.get(i).getResultado().getLexema()));
        }
        System.out.println(codigo);
        for (int i = 0; i < cuadruplas.size(); i++) {
            if (cuadruplas.get(i).getOperacion().getLexema().equals("+")) {
                aux = suma.replace(":var1", cuadruplas.get(i).getOperando1().getLexema());
                aux = aux.replace(":var2", cuadruplas.get(i).getOperando2().getLexema());
                aux = aux.replace(":res", cuadruplas.get(i).getResultado().getLexema());
                System.out.println(aux);
            }
        }
        System.out.println(fin);

    }

}
