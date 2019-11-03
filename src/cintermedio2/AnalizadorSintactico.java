/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedio2;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class AnalizadorSintactico {

    public static ArrayList<Etiqueta> etiquetas = new ArrayList<>();
    public static boolean isCondicion = false;
    public static boolean isSent = false;

    private static ArrayList<Lexema> condicion = new ArrayList<>();

    private static Object[][] sentIf = {
        {"if", new CallBack() {
            public void rutinaS() {
                getEtiquetas().add(new Etiqueta(0));
            }
        }},
        {"(", new CallBack() {
            @Override
            public void rutinaS() {
                isCondicion = true;
            }
        }},
        {"<condicion>", null},
        {")", new CallBack() {
            @Override
            public void rutinaS() {
                condicion = Postfijo.convertirPostfijo(condicion);
            }
        }},
        {"{", new CallBack() {
            @Override
            public void rutinaS() {
                printEncabezado();
                System.out.println(etiquetas.get(0).geteTrue() + ":");
            }
        }},
        {"<sentencias>", null},
        {"}", new CallBack() {
            @Override
            public void rutinaS() {
                System.out.println(etiquetas.get(0).geteFasle() + ":");
            }
        }}
    };

    private static Object[][] sentWhile = {
        {"while", new CallBack() {
            public void rutinaS() {
                getEtiquetas().add(new Etiqueta(1));
                System.out.println(etiquetas.get(0).geteInicio() + ":");
            }
        }},
        {"(", new CallBack() {
            @Override
            public void rutinaS() {
                isCondicion = true;
            }
        }},
        {"<condicion>", null},
        {")", new CallBack() {
            @Override
            public void rutinaS() {
                condicion = Postfijo.convertirPostfijo(condicion);
            }
        }},
        {"{", new CallBack() {
            @Override
            public void rutinaS() {
                printEncabezado();
                System.out.println(etiquetas.get(0).geteTrue() + ":");
            }
        }},
        {"<sentencias>", new CallBack() {
            @Override
            public void rutinaS() {
                System.out.println("goto " + etiquetas.get(0).geteInicio());
            }
        }},
        {"}", new CallBack() {
            @Override
            public void rutinaS() {
                System.out.println(etiquetas.get(0).geteFasle() + ":");
            }
        }}
    };

    public static ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public static void setEtiquetas(ArrayList<Etiqueta> aEtiquetas) {
        etiquetas = aEtiquetas;
    }

    public static void analiza(ArrayList<Lexema> lexema) {
        Object arr[][] = {};
        for (int i = 0; i < lexema.size(); i++) {
            if (lexema.get(i).getLexema().equals("if")) {
                arr = sentIf;
                isSent = true;
            } else if (lexema.get(i).getLexema().equals("while")) {
                arr = sentWhile;
                isSent = true;
            }

            if (isSent) {
                for (int j = 0; j < arr.length; j++) {
                    if (!isCondicion) {
                        CallBack cb = (CallBack) arr[j][1];
                        if (cb != null) {
                            cb.rutinaS();
                        }
                        i++;
                    } else {
                        while (isCondicion) {
                            if (lexema.get(i + 1).getLexema().equals("{")) {
                                isCondicion = false;
                            } else {
                                addLexToCondArr(lexema.get(i));
                                i++;
                            }
                        }
                    }
                }
            }

        }
    }

    /**
     * Agregar lexema a array de condicion
     */
    private static void addLexToCondArr(Lexema l) {
        Lexema aux = (Lexema) l.clone();
        condicion.add(aux);
    }

    private static void printEtiquetas() {
        for (Etiqueta etiqueta : etiquetas) {
            System.out.println(etiqueta);
        }
    }

    private static String getCondicion() {
        String cond = "";
        for (Lexema lexema : condicion) {
            cond += lexema.getLexema();
        }

        return cond;
    }

    private static void printEncabezado() {
        System.out.println("IF " + getCondicion() + " goto " + etiquetas.get(0).geteTrue() + "\n"
                + "goto " + etiquetas.get(0).geteFasle());
    }
}
