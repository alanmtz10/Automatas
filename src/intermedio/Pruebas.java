/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Pruebas {

    public static void main(String[] args) {
        ArrayList<Lexema> programa = Lexema.getTablaLexema("fuentes/programa2.txt");

//        for (Lexema lexema : programa) {
//            System.out.println(lexema);
//        }
        generaCodigoIntermedio(programa);
    }

    public static void generaCodigoIntermedio(ArrayList<Lexema> programa) {
        Stack<Etiqueta> etiquetas = new Stack<>();
        ArrayList<Lexema> condicion = new ArrayList<>();
        ArrayList<Lexema> sent = new ArrayList<>();
        Etiqueta etPop = null;

        boolean sentencia = false;

        for (int i = 0; i < programa.size(); i++) {

            if (programa.get(i).getLexema().equals("else") && programa.get(i + 1).getLexema().equals("if")) {

                etiquetas.add(new Etiqueta(Etiqueta.SENT_ELSE_IF, etPop));
                sentencia = true;
                i++;

            } else if (programa.get(i).getLexema().equals("else")) {

                etiquetas.add(new Etiqueta(Etiqueta.SENT_ELSE, etPop));

            } else if (programa.get(i).getLexema().equals("if")) {

                etiquetas.add(new Etiqueta(Etiqueta.SENT_IF));
                sentencia = true;

            } else if (programa.get(i).getLexema().equals("while")) {

                etiquetas.add(new Etiqueta(Etiqueta.SENT_WHILE));
                sentencia = true;

            } else if (programa.get(i).getLexema().equals("for")) {

                ArrayList<Lexema> variableFor = new ArrayList();
                ArrayList<Lexema> condicionFor = new ArrayList();
                ArrayList<Lexema> aumentoFor = new ArrayList();

                i += 2;
                while (!programa.get(i).getLexema().equals(";")) {
                    variableFor.add(programa.get(i));
                    i++;
                }
                variableFor.add(programa.get(i));
                i++;

                while (!programa.get(i).getLexema().equals(";")) {
                    condicionFor.add(programa.get(i));
                    i++;
                }
                i++;

                while (!programa.get(i).getLexema().equals(")")) {
                    aumentoFor.add(programa.get(i));
                    i++;
                }

                etiquetas.add(new Etiqueta(variableFor, condicionFor, aumentoFor));

            } else if (sentencia && programa.get(i).getLexema().equals("(")) {
                i++;
                boolean isCondicion = true;
                while (isCondicion) {
                    if (programa.get(i + 1).getLexema().equals("{")) {
                        isCondicion = false;
                        i--;
                    } else {
                        condicion.add(programa.get(i));
                    }
                    i++;
                }
                sentencia = false;

            } else if (programa.get(i).getLexema().equals("{")) {
                etiquetas.peek().printEnc(condicion);
                condicion.clear();
            } else if (programa.get(i).getLexema().equals("}")) {
                etPop = etiquetas.pop();
                etPop.printFin(programa, i);
            } else {
                while (!programa.get(i).getLexema().equals(";")) {
                    sent.add(programa.get(i));
                    i++;
                }
                sent.add(programa.get(i));

                printSentencia(sent);
                sent.clear();
            }

        }
    }

    public static void printSentencia(ArrayList<Lexema> sentencia) {
        String sent = "";
        for (Lexema lexema : sentencia) {
            sent += lexema.getLexema();

        }
        System.out.println(sent);
    }

}
