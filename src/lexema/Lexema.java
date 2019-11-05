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

}
