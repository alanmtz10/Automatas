/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio3;

import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class CodInter {

    public static void main(String[] args) {
        ArrayList<Lexema> programa = Lexema.getTablaLexema("fuentes/programa2.txt");

//        for (Lexema lexema : programa) {
//            System.out.println(lexema);
//        }
        getCodigoIntermedio(programa);
    }

    public static void getCodigoIntermedio(ArrayList<Lexema> programa) {

        Stack<Etiqueta> pilaEtiquetas = new Stack<>();
        ArrayList<Lexema> condicionAux = new ArrayList<>();

        Lexema aux;

        for (int i = 0; i < programa.size(); i++) {
            aux = programa.get(i);
            /**
             * Si el lexema es un while genera nuevas etiquetas de while e
             * inserta las etiquetas en la pila
             */
            if (aux.getLexema().equals("while")) {
                pilaEtiquetas.add(new Etiqueta(1, "while"));
                i++;
                while (!programa.get(i + 1).getLexema().equals("{")) {
                    i++;
                    condicionAux.add(programa.get(i));

                }
                /**
                 * Si el lexema es un if genera etiquetas de if e inserta
                 * etiquetas en la pila
                 */
            } else if (aux.getLexema().equals("if")) {
                pilaEtiquetas.add(new Etiqueta(0, "if"));
                i++;
                while (!programa.get(i + 1).getLexema().equals("{")) {
                    i++;
                    condicionAux.add(programa.get(i));

                }
            } else if (aux.getLexema().equals("{")) {
                pilaEtiquetas.peek().printEncabezadoEtiqueta(condicionAux);
                condicionAux.clear();
            } else if (aux.getLexema().equals("}")) {
                pilaEtiquetas.pop().printFinEtiqueta();
            } else {
                String sent = "";
                while (!aux.getLexema().equals(";")) {
                    aux = programa.get(i);
                    sent += aux.getLexema();
                    i++;
                }
                i--;
                System.out.println(sent);
                sent = "";
            }
        }

    }
}
