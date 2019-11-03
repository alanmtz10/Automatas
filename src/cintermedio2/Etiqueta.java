/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio2;

/**
 *
 * @author alan
 */
public class Etiqueta {

    private static int contador = 10;

    private int eInicio;
    private int eTrue;
    private int eFasle;
    private int eSiguiente;

    public Etiqueta(int sent) {

        if (sent == 1) {
            eInicio = contador;
            contador += 10;
        }
        this.eTrue = contador;
        this.eFasle = contador + 10;
        this.eSiguiente = contador + 20;
        contador += 30;
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

    public int geteFasle() {
        return eFasle;
    }

    public void seteFasle(int eFasle) {
        this.eFasle = eFasle;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int aContador) {
        contador = aContador;
    }

    @Override
    public String toString() {
        return "eTrue: " + eTrue + " eFalse: " + eFasle + " eSiguiente: " + eSiguiente;
    }

    public int geteInicio() {
        return eInicio;
    }

    public void seteInicio(int eInicio) {
        this.eInicio = eInicio;
    }

}
