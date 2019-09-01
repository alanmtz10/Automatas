/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.Stack;

/**
 *
 * @author alan
 */
public class PrbPostifo {

    public static void main(String[] args) {
        Postfijo p = new Postfijo();

        Stack<Character> operadores = p.getOperadores();

        operadores.push('C');
        operadores.push('A');
        operadores.push('D');
        operadores.push('R');
        operadores.push('J');
        operadores.push('A');
        operadores.push('N');
        operadores.push('Q');
        operadores.push('E');
        operadores.push('H');
        operadores.push('E');
        operadores.push('G');

        Character[] operadoresArr = (Character[]) (operadores.toArray());

        for (int i = 0; i < operadoresArr.length; i++) {
            System.out.println(operadoresArr[i]);
        }
    }
}
