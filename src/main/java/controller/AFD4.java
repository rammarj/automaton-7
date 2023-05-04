package controller;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD4 extends FiniteAutomaton{

    public AFD4() {
        super("");
        //configuracion de transitions
        this.transitions.addTransition("1", "a", "2");
        this.transitions.addTransition("1", "b", "4");
        this.transitions.addTransition("2", "a", "3");
        this.transitions.addTransition("2", "b", "1");
        this.transitions.addTransition("3", "a", "4");
        this.transitions.addTransition("3", "b", "2");
        this.transitions.addTransition("4", "a", "4");
        this.transitions.addTransition("4", "b", "4");
        
        List<String> empieza = new LinkedList<>();
        empieza.add("2");
        
        List<String> termina = new LinkedList<>();
        termina.add("2");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_IV;
    }
    
}
