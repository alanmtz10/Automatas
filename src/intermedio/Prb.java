/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.StringTokenizer;

/**
 *
 * @author alan
 */
public class Prb {

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("for(int i = 0; i>= 20; i++){", "(;){");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken().replace(" ", ""));
        }
    }

}
