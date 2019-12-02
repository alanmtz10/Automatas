/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexema;

import java.util.ArrayList;
import separarPalabras.SeparaPalabras;

/**
 *
 * @author Alan
 */
public class Lexema implements Cloneable {

    /**
     * Constante de numero
     */
    public static final int NUMERO = 1;

    /**
     * Constante de numero entero
     */
    public static final int NUMERO_ENTERO = 2;

    /**
     * Constante de numero real
     */
    public static final int NUMERO_REAL = 3;

    /**
     * Constante de variable
     */
    public static final int VARIABLE = 4;

    /**
     * Contstante de numero o variable
     */
    public static final int NUMERO_VARIABLE = 5;

    /**
     * Constante de cadena
     */
    public static final int STRING = 6;

    /**
     * Constante de operador logico, aritmetico o relacional
     */
    public static final int OPERADOR = 7;

    /**
     * Constante de operador aritmetico / * - +
     */
    public static final int OPERADOR_ARITMETICO = 8;

    /**
     * Constante de operador logico & |
     */
    public static final int OPERADOR_LOGICO = 9;

    /**
     * Constante de operador relacional > < >= <= != ==
     */
    public static final int OPERADOR_RELACIONAL = 10;

    /**
     * Constante de operador de asignacion = += -=
     */
    public static final int OPERADOR_ASIGNACION = 11;

    /**
     * Constante de tipo de dato String int double
     */
    public static final int TIPO_DATO = 12;

    private String lexema;
    private int renglon;
    private int columna;
    private String token;
    private String error;

    public Lexema(String lexema, int renglon, int columna) {
        this.lexema = lexema;
        this.renglon = renglon;
        this.columna = columna;
        automatas.Automatas.valida(this);
    }

    public Lexema(String lexema, int renglon, int columna, String token) {
        this.lexema = lexema;
        this.renglon = renglon;
        this.columna = columna;
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        if (error == null) {
            return lexema + "\t\tToken: " + token + " Renglon: " + renglon + " Columna: " + columna;
        }
        return lexema + "\t\tError: " + error + " Renglon: " + renglon + " Columna: " + columna + " Info: " + getInfoError(error);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static String getInfoError(String error) {
        switch (error) {
            case "E0":
                return "Error carácter no valido";
            case "E1":
                return "Error se esperaba una variable";
            case "E2":
                return "Error se esperaba un nombre de clase";
            case "E3":
                return "Error se esperaba un nombre de comentario";
            case "E4":
                return "Error se esperaba un número entero";
            case "E5":
                return "Error se esperaba un número real";
            case "E6":
                return "Error se esperaba un objeto";
            case "E7":
                return "Error se esperaba una cadena";
            case "E8":
                return "Error se esperaba un carácter";
            default:
                return "Error desconocido";
        }
    }

    public static ArrayList<Lexema> getTablaLexema(String nombreArchivo) {

        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer(nombreArchivo);
        ArrayList<Lexema> temp = separarPalabras.SeparaPalabras.separa(lineas);

        return SeparaPalabras.arreglos(temp);

    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * Comprobar si un ArrayList de lexemas es igual a una cadena Ej.
     * ['h','o','l','a'] == "hola" : true
     *
     * @param lexemas Arreglo de lexemas
     * @param cadena cadena
     * @return true si son iguales
     */
    public static boolean compareTo(ArrayList<Lexema> lexemas, String cadena) {

        String cadArray = "";

        for (Lexema lexema : lexemas) {
            cadArray += lexema.getLexema();
        }

        return cadArray.equals(cadena);

    }

    public boolean isOperador() {
        if (token.equals("37") || token.equals("39") || token.equals("38") || token.equals("39")) {
            return true;
        }

        return false;
    }

    /**
     * Saber si el lexema es del tipo "that"
     *
     * @param that tipo
     *
     * Lexema.NUMERO_VARIABLE Lexema.NUMERO Lexema.STRING
     * @return true si es del tipo
     */
    public boolean is(int that) {

        if (that == NUMERO_VARIABLE && (token.equals("43") || token.equals("41") || token.equals("48"))) {
            return true;
        } else if (that == VARIABLE && token.equals("41")) {
            return true;
        } else if (that == OPERADOR && (token.equals("36") || token.equals("39") || token.equals("37"))) {
            return true;
        } else if (that == STRING && token.equals("46")) {
            return true;
        } else if (that == NUMERO && (token.equals("43") || token.equals("48"))) {
            return true;
        } else if (that == NUMERO_ENTERO && token.equals("43")) {
            return true;
        } else if (that == NUMERO_REAL && token.equals("48")) {
            return true;
        } else if (that == OPERADOR_ARITMETICO && token.equals("36")) {
            return true;
        } else if (that == OPERADOR_LOGICO && token.equals("37")) {
            return true;
        } else if (that == OPERADOR_RELACIONAL && token.equals("39")) {
            return true;
        } else if (that == OPERADOR_ASIGNACION && token.equals("40")) {
            return true;
        } else if (that == TIPO_DATO && token.equals("1")) {
            return true;
        }

        return false;
    }

    /**
     * Comparar si 2 lexemas son iguales
     *
     * @param l1 lexema 1
     * @param l2 lexema 2
     * @return true si son iguales
     */
    public static boolean compareTo(Lexema l1, Lexema l2) {
        if (l1.lexema.equals(l2.lexema)) {
            return true;
        }
        return false;
    }

}
