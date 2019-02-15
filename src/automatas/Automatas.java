/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

/**
 *
 * @author Alan
 */
public class Automatas {

    public static void main(String[] args) {
        int estado = 0;
        String cad = "abbbbb";
        Integer[][] tabla = {
            {0, 1, 2, -2},
            {null, 1, 2, -2},
            {null, null, 2, -1}
        };
        int aux;
        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i) == 'a') {
                aux = 0;
            } else if (cad.charAt(i) == 'b') {
                aux = 1;
            } else {
                aux = 2;
            }
            estado = tabla[estado][aux];
        }
        System.out.println(tabla[estado][3]);
    }

}
