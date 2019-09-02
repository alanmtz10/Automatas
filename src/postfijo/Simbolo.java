/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

/**
 *
 * @author Alan
 */
public class Simbolo {

    private String variable;
    private String tipoDato;
    private String valor;
    private boolean uso;

    public Simbolo(String variable, String tipoDato, String valor, boolean uso) {
        this.variable = variable;
        this.tipoDato = tipoDato;
        this.valor = valor;
        this.uso = uso;
    }

    public boolean isUso() {
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
}
