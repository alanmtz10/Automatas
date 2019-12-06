/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fix;

import intermedio.Cuadrupla;
import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class CodigoIntermedio {

    /**
     * Bandera para saber si se esta dentro de una condicion de if, for, while
     */
    private static boolean condicion = false;

    public static Stack<Etiqueta> etiquetas = new Stack();
    public static ArrayList<Variable> variables = new ArrayList();
    public static ArrayList<Cuadrupla> cuadruplas = new ArrayList();

    public static ArrayList<Lexema> valorAuxiliar;
    public static ArrayList<Cuadrupla> cuadruplasAuxiliar;

    public static Lexema id;
    public static Lexema head;

    public static Etiqueta temporal;
    public static Cuadrupla cuadruplaAux;

    public static void generaCodigoIntermedio(ArrayList<Lexema> listaLexemas) {

        for (int i = 0; i < listaLexemas.size(); i++) {
            head = listaLexemas.get(i);

            /**
             * Si head es un tipo de dato
             */
            if (head.is(Lexema.TIPO_DATO)) {

                /**
                 * Si viene un tipo de dato y despues del identificador no viene
                 * un ;
                 */
                id = listaLexemas.get(i + 1);
                if (!listaLexemas.get(i + 2).getLexema().equals(";")) {

                    i = identificaValorVariables(listaLexemas, i, true);
                    /**
                     * Si despues del identificador viene un ;
                     */
                } else {
                    variables.add(new Variable(id, null));
                }

                /**
                 * Si head es una variable y no se esta dentro de una condicion
                 */
            } else if (head.is(Lexema.VARIABLE) && !condicion) {
                id = listaLexemas.get(i);
                i = identificaValorVariables(listaLexemas, i, false);
            } else if (head.is(Lexema.SENT_IF)) {
                temporal = new Etiqueta(Etiqueta.IF, null);
                etiquetas.add(temporal);
                i += 1;
                valorAuxiliar = new ArrayList<>();
                while (!listaLexemas.get(i).getLexema().equals(")")) {
                    valorAuxiliar.add(listaLexemas.get(i));
                    i++;
                }
                i--;
                valorAuxiliar = postfijo.Postfijo.convertirPostfijo(valorAuxiliar);
                cuadruplasAuxiliar = Cuadrupla.generaCuadrupla(valorAuxiliar);
                /**
                 * Remover la ultima cuadrupla para generar una cuadrupla de
                 * condicion
                 */
                cuadruplaAux = cuadruplasAuxiliar.remove(cuadruplasAuxiliar.size() - 1);
                cuadruplasAuxiliar.add(new Cuadrupla(
                        cuadruplaAux.getOperacion(),
                        cuadruplaAux.getOperando1(),
                        cuadruplaAux.getOperando2(),
                        "gt e" + temporal.geteTrue()
                ));
                cuadruplasAuxiliar.add(new Cuadrupla("gt e" + temporal.geteFalse()));
                cuadruplasAuxiliar.add(new Cuadrupla("e" + temporal.geteTrue()));
                cuadruplas.addAll(cuadruplasAuxiliar);
                i += 1;
            } else if (head.is(Lexema.LLAVE_CIERRE)) {

                temporal = etiquetas.pop();

                if (i == listaLexemas.size() - 1) {

                    if (temporal.getTipoSent() == Etiqueta.IF) {

                        cuadruplas.add(new Cuadrupla("e" + temporal.geteFalse()));

                    } else if (temporal.getTipoSent() == Etiqueta.ELSE) {
                        cuadruplas.add(new Cuadrupla("e" + temporal.geteSig()));
                    }
                } else {

                    if (temporal.getTipoSent() == Etiqueta.IF) {

                        if (listaLexemas.get(i + 1).is(Lexema.SENT_ELSE)) {

                            temporal = new Etiqueta(Etiqueta.ELSE, temporal);
                            etiquetas.add(temporal);
                            cuadruplas.add(new Cuadrupla("gt e" + temporal.geteSig()));
                            cuadruplas.add(new Cuadrupla("e" + temporal.geteFalse()));

                        } else {
                            cuadruplas.add(new Cuadrupla("e" + temporal.geteFalse()));
                        }
                    } else if (temporal.getTipoSent() == Etiqueta.ELSE) {
                        cuadruplas.add(new Cuadrupla("e" + temporal.geteSig()));
                    }

                }

            }

        }

        generaVariablesTemporales();

        for (Cuadrupla cuadrupla : cuadruplas) {
            System.out.println(cuadrupla);
        }

//        for (Variable variable : variables) {
//            System.out.println(variable);
//        }
    }

    /**
     * Itentificar el valor de las variables
     *
     * @param i posicion del recorrido
     * @param nuevaVariable bandera para identificar si la variable no se a
     * declarado
     * @return la ulitma posicion del recorrido
     */
    public static int identificaValorVariables(ArrayList<Lexema> listaLexemas, int i, boolean nuevaVariable) {
        valorAuxiliar = new ArrayList<>();

        if (nuevaVariable) {
            i += 3;
        } else {
            i += 2;
        }

        while (!listaLexemas.get(i).getLexema().equals(";")) {
            valorAuxiliar.add(listaLexemas.get(i));
            i++;
        }
        valorAuxiliar.size();

        if (valorAuxiliar.size() == 1) {
            if (nuevaVariable) {
                variables.add(new Variable(id, null));
            }
            cuadruplasAuxiliar = new ArrayList<>();
            cuadruplasAuxiliar.add(new Cuadrupla(
                    new Lexema("=", 0, 0, "40"),
                    valorAuxiliar.get(0),
                    null,
                    id
            ));
            cuadruplas.addAll(cuadruplasAuxiliar);
        } else {
            if (nuevaVariable) {
                variables.add(new Variable(id, null));
            }
            /*Convertir a postfijo y sacar cuadruplas*/
            valorAuxiliar = postfijo.Postfijo.convertirPostfijo(valorAuxiliar);
            cuadruplasAuxiliar = Cuadrupla.generaCuadrupla(valorAuxiliar);
            cuadruplasAuxiliar.add(new Cuadrupla(
                    new Lexema("=", 0, 0, "40"), /* Operacion */
                    cuadruplasAuxiliar.get(cuadruplasAuxiliar.size() - 1).getResultado(), /* Operando 1 */
                    null, /* Operando 2 */
                    id /* Resultado */
            ));
            cuadruplas.addAll(cuadruplasAuxiliar);
        }
        valorAuxiliar = null;
        return i;
    }

    /**
     * Remplazar el valor de una variable
     *
     * @param variable variable
     * @param nuevoValor nuevo valor
     */
    public static void remplazarValorVariable(Lexema variable, Lexema nuevoValor) {
        for (Variable v : variables) {
            if (v.getId().getLexema().equals(variable.getLexema())) {
                v.setValor(nuevoValor);
                return;
            }
        }
    }

    /**
     * Generar las variables temporales
     */
    public static void generaVariablesTemporales() {
        int nTemporales = Cuadrupla.getContadorTemporales();
        for (int i = 1; i < nTemporales; i++) {
            variables.add(new Variable(new Lexema("T" + i, 0, 0, "41"), null));
        }

    }

}
