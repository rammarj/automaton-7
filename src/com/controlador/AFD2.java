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
public class AFD2 extends FiniteAutomaton implements Automaton{

    public AFD2() {
        super("");
        //configuracion de transitions
        this.transitions.addTransition("1", "a", "2");
        this.transitions.addTransition("1", "b", "4");
        this.transitions.addTransition("2", "a", "3");
        this.transitions.addTransition("2", "b", "1");
        this.transitions.addTransition("3", "a", "4");
        //this.transitions.addTransition("3", "b", "5");
        //this.transitions.addTransition("4", "a", "4");
        this.transitions.addTransition("4", "b", "4");
        
        LinkedList<String> empieza = new LinkedList<>();
        empieza.add("1");
        
        LinkedList<String> termina = new LinkedList<>();
        termina.add("2");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_II;
    }
    
}
