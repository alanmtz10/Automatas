/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.HashMap;

/**
 *
 * @author Alan
 */
public class Automatas {

    public static void main(String[] args) {
        String[][] table = new String[][]{
            {"s0", "s1", "s2", "0"},
            {" ", "s1", "s2", "0"},
            {" ", " ", "s2", "1"}
        };
        HashMap<String, Integer> alfabetoMap = map("a,b,c");
        HashMap<String, Integer> estadoMap = map("s0,s1,s2");

        String cad = "aaaabcccc";
        String estado = "s0";

        for (int i = 0; i < cad.length(); i++) {
            estado = table[estadoMap.get(estado)][alfabetoMap.get(String.valueOf(cad.charAt(i)))];
        }

        String[] s = table[estadoMap.get(estado)];
        String mensaje = (Integer.parseInt(s[s.length - 1]) == 0) ? "No es una cadena valida" : "Si es una cadena valida";
        System.out.println(mensaje);
    }

    public static HashMap<String, Integer> map(String alfabeto) {
        String[] alfabetoAux = alfabeto.split(",");
        HashMap<String, Integer> tabAux = new HashMap<>();
        int x = 0;
        for (String alfabetoAux1 : alfabetoAux) {
            tabAux.put(alfabetoAux1.trim(), x);
            x++;
        }
        return tabAux;
    }

}
