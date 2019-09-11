/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alanm
 */
public class Postfijo {

    private static final HashMap<String, Integer> JERARQUIA = new HashMap<>();

    private static final Object[][] MAP_JER = {
        {"|", 1},
        {"&", 2},
        {"!", 3},
        {"=", 4},
        {"==", 4},
        {">", 4},
        {"<", 4},
        {">=", 4},
        {"<=", 4},
        {"!=", 4},
        {"+", 5},
        {"-", 5},
        {"*", 6},
        {"/", 6},
        {"^", 7},
        {"(", 9},
        {")", 9}
    };

    /**
     * Metodo que convierte una exprecion infija a postfija
     *
     * @param expresion Arraylist que contiene los lexemas con su numero de
     * token, renglon y columna
     * @return retorna el ArrayList ordenado para evaluarlo
     */
    public static ArrayList<Lexema> convertirPostfijo(ArrayList<Lexema> expresion) {

        if (expresion.get(0).getToken().equals("46")) {
            return expresion;
        }

        /**
         * Asignar a un HashMap la jerarquia de cada operador
         */
        mapJerarquia();

        /**
         * Pila donde se amacenaran temporalmente los operadores y lista donde
         * se almacenara la salida
         */
        Stack<Lexema> operadores = new Stack<>();
        ArrayList<Lexema> salida = new ArrayList<>();

        /**
         * Temporal token, lexema
         */
        String lexema;
        String token;

        /**
         * Recorrer la tabla para convertir a notación postfija la expresión
         */
        for (Lexema simbolo : expresion) {

            lexema = simbolo.getLexema();
            token = simbolo.getToken();

            /**
             * Si el token es un numero o una variable lo inserta en la lista de
             * salida
             */
            if (token.equals("43") || token.equals("48") || token.equals("41")) {

                salida.add(simbolo);

                /**
                 * Si el token es un parentesis de apertura "(" lo inserta en la
                 * pila de operadores
                 */
            } else if (token.equals("28")) {

                operadores.push(simbolo);

                /**
                 * Si el token es un operador, comprobar los operadores que hay
                 * en la pila e irlos sacando
                 */
            } else if (token.equals("36") || token.equals("39") || token.equals("37")) {

                while (!operadores.isEmpty() && !operadores.peek().getLexema().equals("(")
                        && esDeMayorPre(lexema, operadores.peek().getLexema())) {
                    salida.add(operadores.pop());
                }

                operadores.add(simbolo);

                /**
                 * Si el token es un parentesis de cierre ")" sacar hasta que el
                 * primer elemento de la pila sea un parentesis de apertura o
                 * hasta que la pila este vacia
                 */
            } else if (token.equals("29")) {

                while (!operadores.isEmpty() && !operadores.peek().getLexema().equals("(")) {
                    salida.add(operadores.pop());
                }

                if (!operadores.isEmpty()) {
                    if (operadores.peek().getLexema().equals("(")) {
                        operadores.pop();
                    }
                }

            }

        }

        /**
         * Mientras la pila de operadores no este vacia sacar los operadores y
         * meterlos a la lista de salida
         */
        while (!operadores.isEmpty()) {
            salida.add(operadores.pop());
        }

        return salida;

    }

    /**
     * Compara si el operador2 es de mayor precedencia que el operador1.
     *
     * @param operador1 operador 1
     * @param operador2 operador 2
     * @return true si el operador2 es de mayor o igual precedencia, false si
     * no.
     */
    private static boolean esDeMayorPre(String operador1, String operador2) {
        int precedenciaOperador1 = JERARQUIA.get(operador1);
        int precedenciaOperador2 = JERARQUIA.get(operador2);

        if (precedenciaOperador1 <= precedenciaOperador2) {
            return true;
        }
        return false;

    }

    /**
     * Evalua operaciones en notacion postfija
     *
     * @param expresionPostfija
     * @return
     */
    public static Lexema evaluar(ArrayList<Lexema> expresionPostfija) {

        /**
         * Pila de operadores y operandos
         */
        Stack<Lexema> operadores = new Stack<>();
        Stack<Lexema> operandos = new Stack<>();

        for (Lexema termino : expresionPostfija) {

            if (termino.getToken().equals("43") || termino.getToken().equals("48")) {
                operandos.push(termino);
            } else if (termino.getToken().equals("36")) {
                operadores.push(termino);

                if (operandos.size() >= 2) {

                    Lexema terminoDerecha = operandos.pop();
                    Lexema terminoIzquierda = operandos.pop();
                    Lexema operador = operadores.pop();

                    Lexema resultado = operacion(terminoIzquierda, terminoDerecha, operador);
                    operandos.push(resultado);

                }

            }

        }

        return operandos.pop();
    }

    private static void mapJerarquia() {
        for (Object[] op : MAP_JER) {
            JERARQUIA.put((String) op[0], (Integer) op[1]);
        }
    }

    private static Lexema operacion(Lexema operadorIzquierda, Lexema operadorDerecha, Lexema operador) {
        String ope = operador.getLexema();
        double opeI = Double.parseDouble(operadorIzquierda.getLexema());
        double opeD = Double.parseDouble(operadorDerecha.getLexema());

        double res;

        switch (ope) {
            case "+":
                res = opeI + opeD;
                break;
            case "-":
                res = opeI - opeD;
                break;
            case "*":
                res = opeI * opeD;
                break;
            case "/":
                res = opeI / opeD;
                break;
            default:
                System.err.println("Error al evaluar");
                return null;
        }

        if (res % 1 == 0) {
            int res2 = (int) (res);
            return new Lexema(Integer.toString(res2), operadorIzquierda.getRenglon(), operadorIzquierda.getRenglon(), "43");
        }

        return new Lexema(Double.toString(res), operadorIzquierda.getRenglon(), operadorIzquierda.getRenglon(), "48");

    }

}
