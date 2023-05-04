package controller;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD1 extends FiniteAutomaton{

    public AFD1() {
        super("");
        //configuracion de transitions
        this.transitions.addTransition("1", "a", "1");
        this.transitions.addTransition("1", "b", "2");
        this.transitions.addTransition("2", "a", "4");
        this.transitions.addTransition("2", "b", "4");
        this.transitions.addTransition("3", "a", "1");
        this.transitions.addTransition("3", "b", "5");
        this.transitions.addTransition("4", "a", "4");
        this.transitions.addTransition("4", "b", "4");
        this.transitions.addTransition("5", "a", "4");
        this.transitions.addTransition("5", "b", "4");
        List<String> empieza = new LinkedList<>();
        empieza.add("3");
        
        List<String> termina = new LinkedList<>();
        termina.add("2");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_I;
    }
    
}
