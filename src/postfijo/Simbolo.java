/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Simbolo {

    private String variable;
    private String tipoDato;
    private String valor;
    private ArrayList<Lexema> valorEnLexemas;
    private boolean uso;
    private String error;

    private static final String[] ERRORES = {
        "Error variable duplicada",
        "Error variable no usada",
        "Error variable no declarada",
        "Error tipos de dato incompatibles"
    };

    public Simbolo(String variable, String tipoDato, String valor, boolean uso) {
        this.variable = variable;
        this.tipoDato = tipoDato;
        this.valor = valor;
        this.uso = uso;
    }

    public Simbolo(String variable, String tipoDato, String valor, boolean uso, String error) {
        this.variable = variable;
        this.tipoDato = tipoDato;
        this.valor = valor;
        this.uso = uso;
        this.error = error;
    }

    public Simbolo(String variable, String tipoDato, ArrayList<Lexema> valorEnLexemas, boolean uso) {
        this.variable = variable;
        this.tipoDato = tipoDato;
        this.valorEnLexemas = valorEnLexemas;
        this.uso = uso;
    }

    public boolean getUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Lexema> getValorEnLexemas() {
        return valorEnLexemas;
    }

    public void setValorEnLexemas(ArrayList<Lexema> valorEnLexemas) {
        this.valorEnLexemas = valorEnLexemas;
    }

    @Override
    public String toString() {
        return variable + "\t\t Tipo de dato: " + tipoDato + " Valor: " + valorEnLexemas;
    }

    /**
     * Obtener la tabla de simbolos
     *
     * @param tablaLexema tabla de Lexema (lexema, token, renglon, columna)
     * @return tabla de simbolos
     */
    public static ArrayList<Simbolo> getTablaSimbolos(ArrayList<Lexema> tablaLexema) {

        ArrayList<Simbolo> tabla = new ArrayList<>();

        String token;
        String lexema;

        /**
         * Recorrer la tabla de lexemas
         */
        for (int i = 0; i < tablaLexema.size(); i++) {

            lexema = tablaLexema.get(i).getLexema();
            token = tablaLexema.get(i).getToken();

            /**
             * Si el token i es de una variable, el token i-1 es un tipo de dato
             * y el token i+1 es un operador de asginacion, se comprueba que la
             * variable no exista en la tabla de simbolos y se inserta.
             */
            if (token.equals("41") && tablaLexema.get(i - 1).getToken().equals("1")
                    && tablaLexema.get(i + 1).getToken().equals("40")) {

                int posicion = buscarEnTabla(tabla, lexema);

                if (posicion == -1) {

                    ArrayList<Lexema> valorVariable = new ArrayList<>();
                    int posicionBus = i + 2;

                    /**
                     * Genera una tabla de lexema que contentra el valor de la
                     * variable
                     */
                    while (!tablaLexema.get(posicionBus).getLexema().equals(";")) {

//                        System.out.println(tablaLexema.get(posicionBus));
                        valorVariable.add(tablaLexema.get(posicionBus));

                        posicionBus++;

                    }

                    /**
                     * Agrega la variable a la tabla de simbolos
                     */
                    tabla.add(new Simbolo(lexema, tablaLexema.get(i - 1).getLexema(), valorVariable, false));

                    /**
                     * Adelanta i hasta que termine la declaracion de la
                     * variable
                     */
                    i = posicionBus;

                }

            }
        }

        return tabla;
    }

    /**
     * Busca si existe una variable en la tabla de simbolos
     *
     * @param variable variable a buscar
     * @param tablaSimbolos tabla donde se realizara la busqueda
     * @return retorna la posición de la variable si existe en la tabla de
     * simbolos, si no existe dentro de la tabla retorna -1
     */
    public static int buscarEnTabla(ArrayList<Simbolo> tablaSimbolos, String variable) {

        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getVariable().equals("variable")) {
                return i;
            }
        }

        return -1;

    }

}
