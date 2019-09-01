/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.Stack;

/**
 *
 * @author alanm
 */
public class Postfijo {

    private Stack<Character> operadores = new Stack<>();
    private Stack<Character> operandos = new Stack<>();

    public Postfijo() {
    }

    public Stack<Character> getOperadores() {
        return operadores;
    }

    public Stack<Character> getOperandos() {
        return operandos;
    }

    public void setOperadores(Stack<Character> operadores) {
        this.operadores = operadores;
    }

    public void setOperandos(Stack<Character> operandos) {
        this.operandos = operandos;
    }

}
