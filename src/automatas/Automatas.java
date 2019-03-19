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

    public static String[][] table = new String[][]{
        {"S1", "S1", "S8", "S11", "E0", "S3", "E0", "E0", "S13", "E0", "E0", "E0", "E0", "S15", "0", "E0"},
        {"S1", "S1", "S1", "S2", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "1", "41"}, // Variables
        {"E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "1", "44"}, // Clases
        {"E3 ", "E3", "E3", "E3", "E3", "S4", "S5", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "1", "42"}, // Comentarios
        {"S4", "S4", "S4", "E3", "S4", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "1", "42"}, // Comentarios
        {"S5", "S5", "S5", "E0", "S5", "E0", "S6", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "S7", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "1", "42"}, // Comentarios
        {"E4", "E4", "S8", "E4", "E4", "E4", "E4", "S9", "E4", "E4", "E4", "E4", "E4", "E4", "1", "43"}, // Numeros
        {"E0", "E0", "S10", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E5", "E5", "S10", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "1", "48"}, // Numeros reales
        {"S12", "S12", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"S12", "S12", "S12", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "1", "45"}, // Objetos
        {"S13", "S13", "S13", "E0", "S13", "E0", "E0", "E0", "S14", "S13", "S13", "S13", "S13", "E0", "0", "E0"},
        {"E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "1", "46"}, // Cadenas
        {"S16", "S16", "S16", "E0", "S16", "E0", "E0", "E0", "E0", "S16", "S16", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "S17", "0", "E0"},
        {"E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "1", "47"} // Caracteres
    };

    // E0 Caracter no valido
    // E1 Error se esperaba una variable
    // E2 Error se esperaba un nombre de clase
    // E3 Error se esperaba un nombre de comentario
    // E4 Error se esperaba un numero
    // E5 Error se esperaba un numero real
    // E6 Error se esperaba un objeto
    // E7 Error se esperaba una cadena
    // E8 Error se esperaba un caracter
    static HashMap<String, Integer> alfabetoMap = map("M,m,N,-,CE,/,*,.,\",OA,OL,OR,PR,\'");
    static HashMap<String, Integer> estadoMap = map("S0,S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17");

    public static final String MAYUS = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z";
    public static final String MINUS = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z";
    public static final String NUMBER = "0,1,2,3,4,5,6,7,8,9";
    public static final char[] SEPARADORES = {'!', ';', ' ', '\n', '.', '=', '(', ')', '+', '-', '/', '*', '[', ']', '{', '}', '%', '&', '|', '<', '>', '\''};

    private static final String[][] TIPOS_DATO = {
        {"1", "String"},
        {"1", "int"},
        {"1", "double"},
        {"1", "boolean"},
        {"1", "char"}
    };

    private static final String[][] PALABRAS_RES = {
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

    private static final String[][] CARACTERES_ESP = {
        {"28", "("},
        {"29", ")"},
        {"30", ","},
        {"31", ":"},
        {"32", "["},
        {"33", "]"},
        {"33", "{"},
        {"33", "}"},
        {"33", ";"}
    };

    private static final String[][] CLASES_PREDE = {
        {"34", "ResultSet"},
        {"34", "Connection"},
        {"34", "Statement"}
    };

    private static final String[][] FUN_DEF = {
        {"35", "execute"},
        {"35", "on"},
        {"35", "getParameter"},
        {"35", "setParameter"}
    };

    private static final String[][] OPE_ARIT = {
        {"36", "+"},
        {"36", "-"},
        {"36", "*"},
        {"36", "/"},
        {"36", "%"}
    };

    private static final String[][] OPE_LOG = {
        {"37", "%"},
        {"37", "|"},
        {"38", "~"},
        {"38", "!"}
    };

    private static final String[][] OPE_REL = {
        {"39", "<"},
        {"39", ">"},
        {"39", "<="},
        {"39", ">="},
        {"39", "!="},
        {"39", "=="}
    };

    private static final String[][] OPE_ASIG = {
        {"40", "="}
    };

    public static final String[][][] TOKEN_FIJOS = {TIPOS_DATO, PALABRAS_RES, CARACTERES_ESP, CLASES_PREDE, FUN_DEF, OPE_ARIT, OPE_LOG,
        OPE_REL, OPE_ASIG};

    public static void recorreTabla(String cad) {
        String estado = "S0";
        int e2 = 0;
        for (int i = 0; i < cad.length(); i++) {
            if (is(cad.charAt(i), "mayus")) {
                e2 = 0;
            } else if (is(cad.charAt(i), "minus")) {
                e2 = 1;
            } else if (is(cad.charAt(i), "number")) {
                e2 = 2;
            } else if (is(cad.charAt(i), "car_es")) {
                e2 = 4;
            } else if (is(cad.charAt(i), "ope_ar")) {
                e2 = 9;
            } else if (is(cad.charAt(i), "ope_lo")) {
                e2 = 10;
            } else if (is(cad.charAt(i), "ope_re")) {
                e2 = 11;
            } else if (is(cad.charAt(i), "pa_re")) {
                e2 = 12;
            } else {
                e2 = alfabetoMap.get(String.valueOf(cad.charAt(i)));
            }
            estado = table[estadoMap.get(estado)][e2];
            if (estado.contains("E")) {
                System.out.println(estado);
                i = cad.length() + 1;
            }
        }
        if (estado.contains("E") || table[estadoMap.get(estado)][15].contains("E")) {
            String ea = table[estadoMap.get(estado)][15];
            String msg = "";
            if (estado.equalsIgnoreCase("E0") || ea.equalsIgnoreCase("E0")) {
                msg = "Error caracter no valido";
            } else if (estado.equalsIgnoreCase("E1") || ea.equalsIgnoreCase("E1")) {
                msg = "Error se esperaba una variable";
            } else if (estado.equalsIgnoreCase("E2") || ea.equalsIgnoreCase("E2")) {
                msg = "Error se esperaba un nombre de clase";
            } else if (estado.equalsIgnoreCase("E3") || ea.equalsIgnoreCase("E3")) {
                msg = "Error se esperaba un nombre de comentario";
            } else if (estado.equalsIgnoreCase("E4") || ea.equalsIgnoreCase("E4")) {
                msg = "Error se esperaba un numero";
            } else if (estado.equalsIgnoreCase("E5") || ea.equalsIgnoreCase("E5")) {
                msg = "Error se esperaba un numero real";
            } else if (estado.equalsIgnoreCase("E6") || ea.equalsIgnoreCase("E6")) {
                msg = "Error se esperaba un objeto";
            } else if (estado.equalsIgnoreCase("E7") || ea.equalsIgnoreCase("E7")) {
                msg = "Error se esperaba una cadena";
            } else if (estado.equalsIgnoreCase("E8") || ea.equalsIgnoreCase("E8")) {
                msg = "Error se esperaba un caracter";
            }
            System.err.println(msg + " ---------- Renglon: " + estadoMap.get(estado) + " Columna: " + e2);
        } else {
            System.out.println(cad + " Token: " + table[estadoMap.get(estado)][15]);
        }

    }

    public static boolean is(char c, String type) {
        if (type.equalsIgnoreCase("minus") && MINUS.contains(String.valueOf(c))) {

        } else if (type.equalsIgnoreCase("mayus") && MAYUS.contains(String.valueOf(c))) {

        } else if (type.equalsIgnoreCase("number") && NUMBER.contains(String.valueOf(c))) {

        } else if (type.equalsIgnoreCase("car_es")) {
            for (String[] car : CARACTERES_ESP) {
                if (car[1].equals(String.valueOf(c))) {
                    return true;
                }
            }
            return false;
        } else if (type.equalsIgnoreCase("ope_ar")) {
            for (String[] car : OPE_ARIT) {
                if (car[1].equals(String.valueOf(c))) {
                    return true;
                }
            }
            return false;
        } else if (type.equalsIgnoreCase("ope_lo")) {
            for (String[] car : OPE_LOG) {
                if (car[1].equals(String.valueOf(c))) {
                    return true;
                }
            }
            return false;
        } else if (type.equalsIgnoreCase("ope_re")) {
            for (String[] car : OPE_REL) {
                if (car[1].equals(String.valueOf(c))) {
                    return true;
                }
            }
            return false;
        } else if (type.equalsIgnoreCase("pa_re")) {
            for (String[] car : PALABRAS_RES) {
                if (car[1].equals(String.valueOf(c))) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
        return true;
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
