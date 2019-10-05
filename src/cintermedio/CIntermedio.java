/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class CIntermedio {

    /**
     * Variables para controlar las etiquetas
     */
    private static int contadorE = 1;
    public static ArrayList<Etiqueta> etiquetas = new ArrayList<>();

    public static void generaCodigoIntermedio(ArrayList<Lexema> programaFuente) {
        /**
         * Bandera para determinar cuando empieza la condicion, nparentesis
         * Saber los parentesis que se abren y cierran para controlar la
         * condicion, condicionLex donde se guardara la parte condicional del if
         */
        boolean condicion = false;
        boolean codigo = false;
        int nparentesis = 0;
        ArrayList<Lexema> condicionLex = new ArrayList<>();
        ArrayList<Lexema> codigoLex = new ArrayList<>();

        for (int i = 0; i < programaFuente.size(); i++) {
            /**
             * Si el lexema i es un if y el lexema i+1 es un ( activar bandera
             * de condicion
             */
            if (programaFuente.get(i).getToken().equals("5")
                    && programaFuente.get(i + 1).getToken().equals("28")) {
                condicion = true;
                etiquetas.add(
                        new Etiqueta(contadorE, ++contadorE, ++contadorE)
                );

            } else if (programaFuente.get(i).getLexema().equals("{")) {
                codigo = true;
            } else if (programaFuente.get(i).getLexema().equals("}")) {
                etiquetas.get(etiquetas.size() - 1).setCodigo(codigoLex);
                codigoLex = new ArrayList<>();
                codigo = false;
                /**
                 * Separar la parte de la condicion
                 */
            } else if (codigo) {
                codigoLex.add(programaFuente.get(i));
            } else if (condicion) {
                switch (programaFuente.get(i).getToken()) {
                    case "28":
                        nparentesis++;
                        condicionLex.add(programaFuente.get(i));
                        break;
                    case "29":
                        nparentesis--;
                        condicionLex.add(programaFuente.get(i));
                        break;
                    default:
                        condicionLex.add(programaFuente.get(i));
                        break;
                }

                if (nparentesis == 0) {
                    condicion = false;
                    etiquetas.get(etiquetas.size() - 1).setCondicion(condicionLex);
                    condicionLex = new ArrayList<>();
                }
            }

        }
    }

    public static void imprimeEtiquetas() {
        for (Etiqueta etiqueta : etiquetas) {
            System.out.println("IF " + etiqueta.getCondicionOnPostfijo() + " goto " + etiqueta.getBtrue() + "0");
            System.out.println("goto " + etiqueta.getBfalse() + "0");
            System.out.println(etiqueta.getBtrue() + "0:\n" + etiqueta.getCodigoString());
            System.out.println("goto " + etiqueta.getBfalse() + "0");
            System.out.println(etiqueta.getBfalse() + "0:");
        }
    }

}
