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
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class SeparaPalabras {

    public static final char[] SEPARADORES = {'$','!', ';', ' ', '\n', '=', '(', ')', '+', '-', '/', '*', '[', ']', '{', '}', '%', '&', '|', '<', '>', '\'', '.'};

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

    public static ArrayList<Lexema> separa(ArrayList<String> lineas) {
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Lexema> arr2 = new ArrayList<>();
        String paux = "";
        boolean bandera = true;
        int nLinea = 1;
        for (String linea : lineas) {
            linea = linea.trim();
            if (linea.startsWith("//")) {
                arr2.add(new Lexema(linea, nLinea, 0, "42"));
            } else {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == '"' || linea.charAt(i) == '\'') {
                        bandera = !bandera;
                    }
                    if (isSeparador(linea.charAt(i), SEPARADORES) && bandera) {
                        if (!paux.equals("")) {
                            arr.add(paux.trim());
                            arr2.add(new Lexema(paux, nLinea, i + 1));
                            paux = "";
                        }
                        if (linea.charAt(i) != ' ') {
                            arr.add(String.valueOf(linea.charAt(i)).trim());
                            arr2.add(new Lexema(String.valueOf(linea.charAt(i)).trim(), nLinea, i + 1));
                        }
                    } else if (i == linea.length() - 1) {
                        arr.add((paux + linea.charAt(i)).trim());
                        arr2.add(new Lexema((paux + linea.charAt(i)).trim(), nLinea, i + 1));
                        paux = "";
                    } else {
                        paux += linea.charAt(i);
                    }
                    if (i == linea.length() - 1 && (linea.length() - 1) != '"' && !bandera) {
                        bandera = true;
                        System.out.println("Error se esperaba una cadena");
                    }
                }
            }
            nLinea++;
        }
        arr2 = separa2(arr2);
        return arr2;
    }

    public static ArrayList<Lexema> separa2(ArrayList<Lexema> palabras) {
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<Lexema> aux2 = new ArrayList<>();
        for (int i = 0; i < palabras.size(); i++) {
            if ((i + 1) < palabras.size()) {
                if ((palabras.get(i).getLexema().equals("<")
                        || palabras.get(i).getLexema().equals(">")
                        || palabras.get(i).getLexema().equals("=")
                        || palabras.get(i).getLexema().equals("!")
                        || palabras.get(i).getLexema().equals("+")
                        || palabras.get(i).getLexema().equals("-")
                        || palabras.get(i).getLexema().equals("/")
                        || palabras.get(i).getLexema().equals("*"))
                        && (palabras.get(i + 1).getLexema().equals("="))) {
                    aux.add(palabras.get(i) + "" + palabras.get(i + 1));
                    aux2.add(new Lexema(palabras.get(i).getLexema() + "" + palabras.get(i + 1).getLexema(), palabras.get(i).getRenglon(), palabras.get(i).getColumna()));
                    i++;
                } else if (palabras.get(i).getLexema().equals("/") && palabras.get(i + 1).getLexema().equals("/")) {
                    aux.add(palabras.get(i) + "" + palabras.get(i + 1));
                    aux2.add(new Lexema(palabras.get(i).getLexema() + "" + palabras.get(i + 1).getLexema(), palabras.get(i).getRenglon(), palabras.get(i).getColumna()));
                    i++;
                } else {
//                aux.add(palabras.get(i));
                    aux2.add(palabras.get(i));
                }
            }
        }
        return aux2;
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
