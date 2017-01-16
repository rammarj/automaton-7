/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.util.LinkedList;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD1 extends AFDs{

    public AFD1() {
        super("");
        //configuracion de transiciones
        this.transiciones.addTransicion("1", "a", "1");
        this.transiciones.addTransicion("1", "b", "2");
        this.transiciones.addTransicion("2", "a", "4");
        this.transiciones.addTransicion("2", "b", "4");
        this.transiciones.addTransicion("3", "a", "1");
        this.transiciones.addTransicion("3", "b", "5");
        this.transiciones.addTransicion("4", "a", "4");
        this.transiciones.addTransicion("4", "b", "4");
        this.transiciones.addTransicion("5", "a", "4");
        this.transiciones.addTransicion("5", "b", "4");
        LinkedList<String> empieza = new LinkedList<>();
        empieza.add("3");
        
        LinkedList<String> termina = new LinkedList<>();
        termina.add("2");
        
        this.transiciones.setEmpieza(empieza);
        this.transiciones.setTermina(termina);
    }
    
    @Override
    public int getAL_ID() {
        return AFD_I;
    }
    
}
