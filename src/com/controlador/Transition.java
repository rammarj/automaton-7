
package com.controlador;

import java.util.LinkedList;

/**
 *
 * @author Joaquin R. Martinez
 */
public class Transition {

    private LinkedList<State> states;
    private LinkedList<String> startStates, endStates;
    
    
    public Transition() {
        this.states = new LinkedList<>();
        this.startStates = new LinkedList<>();
        this.endStates = new LinkedList<>();
    }
    
    private void addTransition(State state){
        if (state == null) {
            throw new NullPointerException("The state cannot be null.");
        }
        if (this.states.contains(state)) {
            throw new IllegalArgumentException("This state is already added.");
        }
        this.states.add(state);
    }
    
    public void addTransition(String state, String simbol, String transition){
        if (state == null || simbol == null || transition == null) {
            throw new NullPointerException();
        }
        State newState = new State();
        newState.setName(state);
        newState.setSimbol(simbol);
        newState.setTransition(transition);
        this.addTransition(newState);
    }
    
    public String existTransition(String state, String simbol){
        for (State currentSimbol : this.states) {
            //System.out.println(currentSimbol.getTransition());
            if (currentSimbol.getName().equals(state) 
                    && currentSimbol.getSimbol().equals(simbol)) {
                return currentSimbol.getTransition();
            }
        }
        return "";
    }
    
    public LinkedList<State> getStates() {
        return states;
    }

    public LinkedList<String> getStartStates() {
        return startStates;
    }

    public void setStartStates(LinkedList<String> startStates) {
        if (startStates == null) {
            throw new NullPointerException("The startStates parameter must not be null");
        }
        for (String nextStartState : startStates) {
            boolean exist = false;
            for (State nextState : this.states) {
                if (nextState.getName().equals(nextStartState)) {
                    exist = true;
                }
            }
            if (!exist) {
                throw new IllegalArgumentException("The start state does not exist!.");
            }
        }
        this.startStates = startStates;
    }

    public LinkedList<String> getEndStates() {
        return endStates;
    }

    public void setEndStates(LinkedList<String> endStates) {
        if (endStates == null) {
            throw new NullPointerException("Initial states must not be null");
        }
        for (String next : endStates) {
            boolean existe = false;
            for (State next1 : this.states) {
                if (next1.getName().equals(next)) {
                    existe = true;
                }
            }
            if (!existe) {
                throw new IllegalArgumentException("The end state does not exist");
            }
            this.endStates = endStates;
        }
        
    }
    
    
    
}
