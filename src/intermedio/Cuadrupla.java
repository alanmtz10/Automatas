/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Cuadrupla {

    private static int contadorTemporales = 1;

    public static int getContadorTemporales() {
        return contadorTemporales;
    }

    public static void setContadorTemporales(int aContadorTemporales) {
        contadorTemporales = aContadorTemporales;
    }

    private Lexema operacion;
    private Lexema operando1;
    private Lexema operando2;
    private Lexema resultado;

    public Cuadrupla(Lexema operacion, Lexema operando1, Lexema operando2, Lexema resultado) {
        this.operacion = operacion;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }

    public Lexema getOperacion() {
        return operacion;
    }

    public void setOperacion(Lexema operacion) {
        this.operacion = operacion;
    }

    public Lexema getOperando1() {
        return operando1;
    }

    public void setOperando1(Lexema operando1) {
        this.operando1 = operando1;
    }

    public Lexema getOperando2() {
        return operando2;
    }

    public void setOperando2(Lexema operando2) {
        this.operando2 = operando2;
    }

    public Lexema getResultado() {
        return resultado;
    }

    public void setResultado(Lexema resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "(" + operacion.getLexema() + "," + operando1.getLexema() + "," + operando2.getLexema() + "," + resultado.getLexema() + ")";
    }

    /**
     * Generar un ArrayList con las cuadruplas de une expresion
     *
     * @param expresion condicion en postfijo de la que se obtendren las
     * cuadruplas
     * @return ArrayList con las cuadruplas de la expresion
     */
    public static ArrayList<Cuadrupla> generaCuadrupla(ArrayList<Lexema> expresion) {

        /**
         * Copia de la condicion
         *
         * ArrayList de cuadruplas a generar
         */
        ArrayList<Lexema> expresionCopy = (ArrayList<Lexema>) expresion.clone();
        ArrayList<Cuadrupla> cuadruplas = new ArrayList<>();

        /**
         * Pila de operadores y operandos
         */
        Stack<Lexema> operadores = new Stack<>();
        Stack<Lexema> operandos = new Stack<>();

        Lexema operadorIzquierda;
        Lexema operadorDerecha;
        Lexema operador;
        Lexema aux;

        for (Lexema lexema : expresionCopy) {

            if (lexema.is(Lexema.NUMERO_VARIABLE)) {

                operandos.push(lexema);

            } else if (lexema.is(Lexema.OPERADOR)) {

                operadores.push(lexema);

                if (operandos.size() >= 2) {

                    operador = operadores.pop();
                    operadorDerecha = operandos.pop();
                    operadorIzquierda = operandos.pop();

                    aux = new Lexema("T" + contadorTemporales, 0, 0, "41");
                    operandos.push(aux);
                    cuadruplas.add(new Cuadrupla(operador, operadorIzquierda, operadorDerecha, aux));

                    contadorTemporales++;

                }

            }
        }

        return cuadruplas;

    }

    public static void printCuadruplas(ArrayList<Cuadrupla> cuadruplas) {
        for (Cuadrupla cuadrupla : cuadruplas) {
            System.out.println(cuadrupla);
        }
    }
}
