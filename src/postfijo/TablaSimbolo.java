/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;

/**
 *
 * @author alanm
 */
public class TablaSimbolo {
    
    private ArrayList<Simbolo> variables;
    private ArrayList<TablaSimbolo> tablasHijas;

    public ArrayList<Simbolo> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Simbolo> variables) {
        this.variables = variables;
    }

    public ArrayList<TablaSimbolo> getTablasHijas() {
        return tablasHijas;
    }

    public void setTablasHijas(ArrayList<TablaSimbolo> tablasHijas) {
        this.tablasHijas = tablasHijas;
    }


        
}
