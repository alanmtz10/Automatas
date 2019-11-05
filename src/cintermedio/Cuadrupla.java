/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio;

import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;
import postfijo.Simbolo;
import postfijo.TablaSimbolo;

/**
 *
 * @author alan
 */
public class Cuadrupla {

    private String operacion;
    private String operando1;
    private String operando2;
    private String resultado;

    public static ArrayList<Cuadrupla> cuadruplas = new ArrayList<>();
    private static int nTemps = 0;

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
        return "(" + this.operacion + ", " + this.operando1
                + ", " + this.operando2 + ", " + this.resultado + ")";
    }

    public static ArrayList<Cuadrupla> getCuadruplas(TablaSimbolo tablaGlobal) {

        int sizeValorVariable;

        for (Simbolo variable : tablaGlobal.getVariables()) {
            sizeValorVariable = variable.getValorEnLexemas().size();
            if (sizeValorVariable == 1) {
                cuadruplas.add(
                        new Cuadrupla("=", variable.getValorEnLexemas().get(0).getLexema(), null, variable.getVariable())
                );
            } else {
                cuadruplas.addAll(getCuadruplasVariable(variable));
            }
        }

        return cuadruplas;
    }

    private static ArrayList<Cuadrupla> getCuadruplasVariable(Simbolo s) {

        ArrayList<Cuadrupla> cuadruplas = new ArrayList<>();
        Stack<Lexema> operadores = new Stack<>();
        Stack<Lexema> operandos = new Stack<>();

        for (Lexema valorEnLexema : s.getValorEnLexemas()) {
            if (valorEnLexema.getToken().equals("43") || valorEnLexema.getToken().equals("48")
                    || valorEnLexema.getToken().equals("14") || valorEnLexema.getToken().equals("24")
                    || valorEnLexema.getToken().equals("41")) {
                operandos.push(valorEnLexema);
            } else if (valorEnLexema.getToken().equals("36") || valorEnLexema.getToken().equals("39")
                    || valorEnLexema.getToken().equals("37")) {
                operadores.push(valorEnLexema);

                if (operandos.size() >= 2) {

                    Lexema temp = new Lexema("t" + nTemps, 0, 0, "41");
                    String der = operandos.pop().getLexema();
                    String iz = operandos.pop().getLexema();

                    cuadruplas.add(
                            new Cuadrupla(
                                    operadores.pop().getLexema(),
                                    iz,
                                    der,
                                    "t" + nTemps
                            )
                    );
                    operandos.push(temp);
                    nTemps++;
                }
            }
        }

        cuadruplas.add(
                new Cuadrupla("=", operandos.pop().getLexema(), null, s.getVariable())
        );

        return cuadruplas;
    }

}
