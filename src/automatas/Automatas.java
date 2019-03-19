/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.HashMap;

/**
 *
 * @author Alan
 */
public class Automatas {

    static String[][] table = new String[][]{
        {"S1", "S1", "S8", "S11", " ", "S3", " ", " ", "S13", " ", " ", " ", " ", "S15", "0", " "},
        {"S1", "S1", "S1", "S2", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "41"},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "44"},
        {" ", " ", " ", " ", " ", "S4", "S5", " ", " ", " ", " ", " ", " ", " ", "1", "42"},
        {"S4", "S4", "S4", " ", "S4", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "42"},
        {"S5", "S5", "S5", " ", "S5", " ", "S6", " ", " ", " ", " ", " ", " ", " ", "0", " "},
        {" ", " ", " ", " ", " ", "S7", " ", " ", " ", " ", " ", " ", " ", " ", "0", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "42"},
        {" ", " ", "S8", " ", " ", " ", " ", "S9", " ", " ", " ", " ", " ", " ", "1", "43"},
        {" ", " ", "S10", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "0", " "},
        {" ", " ", "S10", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "48"},
        {"S12", "S12", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "0", " "},
        {"S12", "S12", "S12", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "45"},
        {"S13", "S13", "S13", " ", "S13", " ", " ", " ", "S14", "S13", "S13", "S13", "S13", " ", "0", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "46"},
        {"S16", "S16", "S16", " ", "S16", " ", " ", " ", " ", "S16", "S16", " ", " ", " ", "0", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "S17", "0", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "1", "47"}
    };

    static HashMap<String, Integer> alfabetoMap = map("M,m,N,-,CE,/,*,.,\",OA,OL,OR,PR,\'");
    static HashMap<String, Integer> estadoMap = map("S0,S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17");

    public static final String MAYUS = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z";
    public static final String MINUS = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z";
    public static final String NUM = "0,1,2,3,4,5,6,7,8,9";
    public static final char[] SEPARADORES = {';', ' ', '\n', '.', '=', '(', ')', '+', '-', '/', '*', '[', ']', '{', '}', '%', '&', '|', '<', '>', '\''};

    public static final String[][] TIPOS_DATO = {
        {"1", "String"},
        {"1", "int"},
        {"1", "double"},
        {"1", "boolean"},
        {"1", "char"}
    };

    public static final String[][] PALABRAS_RES = {
        {"2", "function"},
        {"3", "absctract"},
        {"4", "boolean"},
        {"5", "if"},
        {"6", "else"},
        {"7", "for"},
        {"8", "case"},
        {"9", "catch"},
        {"10", "const"},
        {"11", "default"},
        {"12", "delete"},
        {"13", "export"},
        {"14", "false"},
        {"15", "final"},
        {"16", "this"},
        {"17", "switch"},
        {"18", "while"},
        {"19", "null"},
        {"20", "return"},
        {"21", "package"},
        {"22", "super"},
        {"23", "this"},
        {"24", "true"},
        {"25", "void"},
        {"26", "new"},
        {"27", "document"}
    };

    public static final String[][] CARACTERES_ESP = {
        {"28", "("},
        {"29", ")"},
        {"30", ","},
        {"31", ":"},
        {"32", "["},
        {"33", "]"}
    };

    public static final String[][] CLASES_PREDE = {
        {"34", "ResultSet"},
        {"34", "Connection"},
        {"34", "Statement"}
    };

    public static final String[][] FUN_DEF = {
        {"35", "execute"},
        {"35", "on"},
        {"35", "getParameter"},
        {"35", "setParameter"}
    };

    public static final String[][] OPE_ARIT = {
        {"36", "+"},
        {"36", "-"},
        {"36", "*"},
        {"36", "/"},
        {"36", "%"}
    };

    public static final String[][] OPE_LOG = {
        {"37", "%"},
        {"37", "|"},
        {"38", "~"}
    };

    public static final String[][] OPE_REL = {
        {"39", "<"},
        {"39", ">"},
        {"39", "<="},
        {"39", ">="},
        {"39", "!="},
        {"39", "=="}
    };

    public static final String[][] OPE_ASIG = {
        {"40", "="}
    };

    public static void main(String[] args) {

        String cad = "aaaabcccc";
        String estado = "s0";

        for (int i = 0; i < cad.length(); i++) {
            estado = table[estadoMap.get(estado)][alfabetoMap.get(String.valueOf(cad.charAt(i)))];
        }

        String[] s = table[estadoMap.get(estado)];
        String mensaje = (Integer.parseInt(s[s.length - 1]) == 0) ? "No es una cadena valida" : "Si es una cadena valida";
        System.out.println(mensaje);
    }

    public static HashMap<String, Integer> map(String alfabeto) {
        String[] alfabetoAux = alfabeto.split(",");
        HashMap<String, Integer> tabAux = new HashMap<>();
        int x = 0;
        for (String alfabetoAux1 : alfabetoAux) {
            tabAux.put(alfabetoAux1.trim(), x);
            x++;
        }
        return tabAux;
    }

}
