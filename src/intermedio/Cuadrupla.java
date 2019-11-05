/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

/**
 *
 * @author alan
 */
public class Cuadrupla {

    private static int contadorTemporales = 0;

    String operacion;
    String operando1;
    String operando2;
    String resultado;

    public Cuadrupla(String operacion, String operando1, String operando2, String resultado) {
        this.operacion = operacion;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }
}
