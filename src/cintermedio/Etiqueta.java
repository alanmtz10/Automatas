/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Etiqueta {

    private int btrue;
    private int bfalse;
    private int bsiguiente;
    private ArrayList<Lexema> condicion;
    private ArrayList<Lexema> codigo;
    private String pertenece;

    public Etiqueta(int btrue, int bfalse, int bsiguiente, String pertenece) {
        this.btrue = btrue;
        this.bfalse = bfalse;
        this.bsiguiente = bsiguiente;
        this.pertenece = pertenece;
    }

    public Etiqueta(int btrue, int bfalse, int bsiguiente) {
        this.btrue = btrue;
        this.bfalse = bfalse;
        this.bsiguiente = bsiguiente;
    }

    public String getPertenece() {
        return pertenece;
    }

    public void setPertenece(String pertenece) {
        this.pertenece = pertenece;
    }

    public int getBtrue() {
        return btrue;
    }

    public void setBtrue(int btrue) {
        this.btrue = btrue;
    }

    public int getBfalse() {
        return bfalse;
    }

    public void setBfalse(int bfalse) {
        this.bfalse = bfalse;
    }

    public int getBsiguiente() {
        return bsiguiente;
    }

    public void setBsiguiente(int bsiguiente) {
        this.bsiguiente = bsiguiente;
    }

    public ArrayList<Lexema> getCondicion() {
        return condicion;
    }

    public void setCondicion(ArrayList<Lexema> condicion) {
        this.condicion = condicion;
    }

    public ArrayList<Lexema> getCodigo() {
        return codigo;
    }

    public void setCodigo(ArrayList<Lexema> codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "true: " + btrue + " false: " + bfalse + " siguiente: " + bsiguiente + " condicion: " + this.getCondicionStrig();
    }

    public String getCondicionStrig() {
        String aux = "";

        if (condicion != null) {
            for (Lexema c : condicion) {
                aux += c.getLexema();
            }
        }

        return aux;

    }

    public String getCodigoString() {
        String cod = "";

        for (Lexema c : codigo) {
            cod += c.getLexema();
        }

        return cod;
    }

    public String getCondicionOnPostfijo() {
        ArrayList<Lexema> postfijo = Postfijo.convertirPostfijo(this.condicion);
        String cond = "";
        for (Lexema lexema : postfijo) {
            cond += lexema.getLexema();
        }
        return cond;
    }

}
