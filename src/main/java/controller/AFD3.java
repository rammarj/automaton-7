package controller;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD3 extends FiniteAutomaton implements Automaton{

    public AFD3() {
        super("");
        //configuracion de transitions
        this.transitions.addTransition("1", "a", "1");
        this.transitions.addTransition("1", "b", "2");
        this.transitions.addTransition("2", "a", "3");
        this.transitions.addTransition("2", "b", "2");
        this.transitions.addTransition("3", "a", "3");
        this.transitions.addTransition("3", "b", "3");
        
        List<String> empieza = new LinkedList<>();
        empieza.add("1");
        
        List<String> termina = new LinkedList<>();
        termina.add("1");
        termina.add("2");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_III;
    }
    
}
