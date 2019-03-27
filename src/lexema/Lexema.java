/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexema;

/**
 *
 * @author Alan
 */
public class Lexema {

    private String lexema;
    private int renglon;
    private int columna;
    private int token;
    private String error;

    public Lexema(String lexema, int renglon, int columna, int token, String error) {
        this.lexema = lexema;
        this.renglon = renglon;
        this.columna = columna;
        this.token = token;
        this.error = error;
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

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

}
