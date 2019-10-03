/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio;

/**
 *
 * @author alan
 */
public class Cuadrupla {

    private String operacion;
    private String operando1;
    private String operando2;
    private String resultado;

    public Cuadrupla(String operacion, String operando1, String operando2, String resultado) {
        this.operacion = operacion;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperando1() {
        return operando1;
    }

    public void setOperando1(String operando1) {
        this.operando1 = operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public void setOperando2(String operando2) {
        this.operando2 = operando2;
    }

    @Override
    public String toString() {
        return "Operacion: " + this.operacion + " operando 1: " + this.operando1 + " operando 2: " + this.operando2 + " resultado: " + this.resultado;
    }

}
