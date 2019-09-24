/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Operaciones {

    /**
     * Evaluar tabla simbolo
     */
    public static void evaluarTabla(TablaSimbolo tabla) {
        Stack<Lexema> operadores = new Stack<>();
        Stack<Lexema> operandos = new Stack<>();

        for (Simbolo var : tabla.getVariables()) {

            for (Lexema l : var.getValorEnLexemas()) {

                if (l.getToken().equals("43") || l.getToken().equals("48") || l.getToken().equals("41")) {

                    operandos.push(l);

                } else if (l.getToken().equals("36") || l.getToken().equals("39") || l.getToken().equals("37")) {

                    operadores.push(l);

                    if (operandos.size() >= 2) {

                        Lexema operadorDerecha = operandos.pop();
                        Lexema operadorIzquierda = operandos.pop();
                        Lexema operador = operadores.pop();

                        if (operadorDerecha.getToken().equals("41")) {
                            operadorDerecha = buscarVariable(tabla, operadorDerecha);
                        }

                        if (operadorIzquierda.getToken().equals("41")) {
                            operadorIzquierda = buscarVariable(tabla, operadorIzquierda);
                        }

                    } else {
                        System.err.println("Error en la operacion");
                    }

                }

            }

        }

        /**
         * Evaluar las tablas hijas
         */
        for (TablaSimbolo tablaHija : tabla.getTablasHijas()) {
            evaluarTabla(tablaHija);
        }
    }

    private static Lexema buscarVariable(TablaSimbolo tabla, Lexema l) {

        for (Simbolo var : tabla.getVariables()) {
            if (var.getVariable().equals(l.getLexema())) {
                return var.getValorEvaluado();
            }
        }

        return null;
    }

}
