/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica;

/**
 *
 * @author alanm
 */
public class Gramatica2 {

    private static String[][] producciones = {
        {"a", "s3", "s2", "s1"},
        {"s1", "b"},
        {"-"},
        {"s2", "c"},
        {"-"},
        {"s3", "d"},
        {"-"}
    };

    private static int[][] tabla = {
        {1, 1, 1, 1, 0},
        {3, 2, 3, 3, 3},
        {5, 0, 4, 5, 5},
        {7, 0, 0, 6, 0}
    };

    public static void main(String[] args) {
        String pila[] = {"$", "s0"};
        String entrada[] = {"b", "b", "a", "$"};
        while (comparaArr(pila, entrada)) {

        }

    }

    private static boolean comparaArr(String[] a0, String[] a1) {
        if ((a0.length == a1.length) && a0[0].equals(a1[0])) {
            return false;
        }
        return true;
    }

    private static void imprime(String[] arr) {
        for (String arr1 : arr) {
            System.out.print(arr1 + " ");
        }
    }
}
