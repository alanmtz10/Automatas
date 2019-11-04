/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio3;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Etiqueta {

    private static int contador = 5;

    private int eInicio;
    private int eTrue;
    private int eFalse;
    private int eSiguiente;

    private String sentencia;

    public Etiqueta(int sent, String sentencia) {

        if (sent == 1) {
            eInicio = contador;
            contador += 5;
        }
        this.eTrue = contador;
        this.eFalse = contador + 5;
        this.eSiguiente = contador + 10;
        contador += 15;

        this.sentencia = sentencia;
    }

    public Etiqueta(int set, String sentencia, Etiqueta anterior) {
        if (sentencia.equals("while")) {
            eInicio = contador;
            contador += 10;
        }
    }

    public int geteSiguiente() {
        return eSiguiente;
    }

    public void seteSiguiente(int eSiguiente) {
        this.eSiguiente = eSiguiente;
    }

    public int geteTrue() {
        return eTrue;
    }

    public void seteTrue(int eTrue) {
        this.eTrue = eTrue;
    }

    public int geteFalse() {
        return eFalse;
    }

    public void seteFalse(int eFasle) {
        this.eFalse = eFasle;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int aContador) {
        contador = aContador;
    }

    public int geteInicio() {
        return eInicio;
    }

    public void seteInicio(int eInicio) {
        this.eInicio = eInicio;
    }

    @Override
    public String toString() {
        return "eTrue: " + eTrue + " eFalse: " + eFalse + " eSiguiente: " + eSiguiente;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public void printEncabezadoEtiqueta(ArrayList<Lexema> condicion) {
        if (sentencia.equals("while")) {
            System.out.println(eInicio + ":");
            System.out.println("if " + getCondicionInPostfijo(condicion) + " goto " + eTrue);
            System.out.println("goto " + eFalse);
            System.out.println(eTrue + ":");
        } else if (sentencia.equals("if")) {
            System.out.println("if " + getCondicionInPostfijo(condicion) + " goto " + eTrue);
            System.out.println("goto " + eFalse);
            System.out.println(eTrue + ":");
        }
    }

    public void printFinEtiqueta() {
        if (sentencia.equals("while")) {
            System.out.println("goto " + eInicio);
            System.out.println(eFalse + ":");
        } else if (sentencia.equals("if")) {
            System.out.println(eFalse + ":");
        }
    }

    private String getCondicionInPostfijo(ArrayList<Lexema> condicion) {
        ArrayList<Lexema> aux = Postfijo.convertirPostfijo(condicion);
        String cond = "";

        for (Lexema lexema : aux) {
            cond += lexema.getLexema();
        }

        return cond;
    }

}
