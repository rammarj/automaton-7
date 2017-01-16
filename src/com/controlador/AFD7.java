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
public class AFD7 extends AFDs{

    public AFD7() {
        super("");
        //configuracion de transiciones
        this.transiciones.addTransicion("1", "a", "2");
        this.transiciones.addTransicion("1", "b", "1");
        this.transiciones.addTransicion("2", "a", "4");
        this.transiciones.addTransicion("2", "b", "2");
        this.transiciones.addTransicion("3", "a", "2");
        this.transiciones.addTransicion("3", "b", "4");
        this.transiciones.addTransicion("4", "a", "3");
        this.transiciones.addTransicion("4", "b", "1");
        
        LinkedList<String> empieza = new LinkedList<>();
        empieza.add("1");
        
        LinkedList<String> termina = new LinkedList<>();
        termina.add("1");
        termina.add("2");
        termina.add("4");
        
        this.transiciones.setEmpieza(empieza);
        this.transiciones.setTermina(termina);
    }
    
    @Override
    public int getAL_ID() {
        return AFD_VII;
    }
    
}
