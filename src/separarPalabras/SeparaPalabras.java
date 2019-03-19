/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package separarPalabras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Alan
 */
public class SeparaPalabras {

    public static ArrayList<String> leer(String archivo) {
        String txt = "";
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((txt = br.readLine()) != null) {
                lineas.add(txt);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public static ArrayList<String> separa(ArrayList<String> lineas, char... separadores) {
        ArrayList<String> arr = new ArrayList<>();
        String paux = "";
        for (String linea : lineas) {
            for (int i = 0; i < linea.length(); i++) {
                if (isSeparador(linea.charAt(i), separadores)) {
                    if (!paux.equals("")) {
                        arr.add(paux.trim());
                        paux = "";
                    }
                    if (linea.charAt(i) != ' ') {
                        arr.add(String.valueOf(linea.charAt(i)).trim());
                    }
                } else if (i == linea.length() - 1) {
                    arr.add((paux + linea.charAt(i)).trim());
                    paux = "";
                } else {
                    paux += linea.charAt(i);
                }
            }
        }
        return arr;
    }

    public static boolean isSeparador(char c, char... separadores) {
        for (char t : separadores) {
            if (t == c) {
                return true;
            }
        }
        return false;
    }

    public static void guardar(ArrayList<String> palabrasSeparadas) {
        String nom = new Timestamp(System.currentTimeMillis()).toString().replace(' ', '_').replace(":", ".");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nom + ".txt"));
            for (String palabrasSeparada : palabrasSeparadas) {
                bw.write(palabrasSeparada + "\r\n");
            }
            bw.close();
        } catch (Exception e) {

        }
    }

}
