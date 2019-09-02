/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alanm
 */
public class Postfijo {

    private Stack<String> operadores = new Stack<>();
    private Stack<String> operandos = new Stack<>();
    private String expresion;
    private ArrayList<Lexema> tablaLexema;
    private ArrayList<Simbolo> tablaSimbolos;

    public static final String[][] JER_OPE = {
        {"1", "||"},
        {"2", "&&"},
        {"3", "!"},
        {"4", "="},
        {"4", ">"},
        {"4", "<"},
        {"4", ">="},
        {"4", "<="},
        {"4", "!="},
        {"5", "+"},
        {"5", "-"},
        {"6", "*"},
        {"6", "/"},
        {"9", "("},
        {"9", ")"}
    };

    public Postfijo(String expresion) {
        this.expresion = expresion;
    }

    public Postfijo(ArrayList<Lexema> tablaLexema) {
        this.tablaLexema = tablaLexema;
    }

    public Stack<String> getOperadores() {
        return operadores;
    }

    public Stack<String> getOperandos() {
        return operandos;
    }

    public void setOperadores(Stack<String> operadores) {
        this.operadores = operadores;
    }

    public void setOperandos(Stack<String> operandos) {
        this.operandos = operandos;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public ArrayList<Lexema> getTablaLexema() {
        return tablaLexema;
    }

    public void setTablaLexema(ArrayList<Lexema> tablaLexema) {
        this.tablaLexema = tablaLexema;
    }

    public String getPostfijo() {
        return "";
    }

    public String getPostfijoExp() {
        for (int i = 0; i < tablaLexema.size(); i++) {

            String termino = tablaLexema.get(i).getLexema();
            String token = tablaLexema.get(i).getToken();

            switch (token) {
                case "43":
                    operandos.push(termino);
                    break;
                case "41":
                    operandos.push(termino);
                    break;
                case "28":
                    operadores.push(termino);
                    break;
                case "29":
                    while (!operadores.empty() && !operadores.peek().equals("(")) {
                        operandos.push(operadores.pop());
                    }
                    if (operadores.peek().equals("(")) {
                        operadores.pop();
                    } else {
                        System.out.println("ERROR");
                        i = tablaLexema.size() + 1;
                    }
                    termino = "";
                    break;
                case "36":
                    while (!operadores.empty() && !esDeMayorPrioridad(operadores.peek(), termino)) {
                        operandos.push(operadores.pop());
                    }
                    operandos.push(termino);
                    break;
            }
        }
        while (!operadores.empty()) {
            operandos.push(operadores.pop());
        }
        return operandos.toString();
    }

    /**
     * @param variable
     *
     * Busca si la variable esta en la tabla de simbolos
     *
     * @return true si esta en la tabla, false si no.
     */
    public boolean existeEnTablaDeSimbolos(String variable) {
        for (Simbolo s : tablaSimbolos) {
            if (s.getVariable().equals(variable)) {
                return true;
            }
        }
        return false;
    }

    public void imprimeTablaLexema() {
        for (Lexema l : tablaLexema) {
            System.out.println(l);
        }

    }

    /**
     * @param operador1
     * @param operador2
     * @return Devuelve true si el operador1 de mayor o igual prioridad que el
     * operador 2
     */
    public boolean esDeMayorPrioridad(String operador1, String operador2) {
        int prioridadOp1 = getPrioridad(operador1);
        int prioridadOp2 = getPrioridad(operador2);

        if (prioridadOp1 >= prioridadOp2) {
            return true;
        }

        return false;
    }

    private int getPrioridad(String operador) {
        for (String[] operador0 : JER_OPE) {
            if (operador0[1].equals(operador)) {
                return Integer.parseInt(operador0[0]);
            }
        }
        return -1;
    }

}
