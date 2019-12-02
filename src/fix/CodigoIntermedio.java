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

    public static Stack<Etiqueta> etiquetas = new Stack();
    public static ArrayList<Variable> variables = new ArrayList();
    public static ArrayList<Cuadrupla> cuadruplas = new ArrayList();

    public static void generaCodigoIntermedio(ArrayList<Lexema> listaLexemas) {

        Lexema id;
        ArrayList<Lexema> valorAuxiliar = new ArrayList<>();

        Lexema head;

        for (int i = 0; i < listaLexemas.size(); i++) {
            head = listaLexemas.get(i);

            if (head.is(Lexema.TIPO_DATO)) {

                id = listaLexemas.get(i + 1);
                i += 2;

                while (!listaLexemas.get(i).getLexema().equals(";")) {
                    valorAuxiliar.add(listaLexemas.get(i));
                    i++;
                }

                if (valorAuxiliar.size() == 1) {
                    variables.add(new Variable(id, valorAuxiliar.get(0)));
                } else {
                    variables.add(new Variable(id, null));
                }

            }

        }

    }

}
