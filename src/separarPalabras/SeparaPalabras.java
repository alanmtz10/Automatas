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

    public static final char[] SEPARADORES = {'!', ';', ' ', '\n', '.', '=', '(', ')', '+', '-', '/', '*', '[', ']', '{', '}', '%', '&', '|', '<', '>', '\''};

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

    public static ArrayList<String> separa(ArrayList<String> lineas) {
        ArrayList<String> arr = new ArrayList<>();
        String paux = "";
        boolean bandera = true;
        for (String linea : lineas) {
            for (int i = 0; i < linea.length(); i++) {
                if (linea.charAt(i) == '"' || linea.charAt(i) == '\'') {
                    bandera = !bandera;
                }
                if (isSeparador(linea.charAt(i), SEPARADORES) && bandera) {
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
        arr = separa2(arr);
        return arr;
    }

    public static ArrayList<String> separa2(ArrayList<String> palabras) {
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < palabras.size(); i++) {
            if ((palabras.get(i).equals("<")
                    || palabras.get(i).equals(">")
                    || palabras.get(i).equals("=")
                    || palabras.get(i).equals("!")
                    || palabras.get(i).equals("+")
                    || palabras.get(i).equals("-")
                    || palabras.get(i).equals("/")
                    || palabras.get(i).equals("*"))
                    && (palabras.get(i + 1).equals("="))) {
                aux.add(palabras.get(i) + "" + palabras.get(i + 1));
                i++;
            } else {
                aux.add(palabras.get(i));
            }
        }
        return aux;
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
