package controlador;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD6 extends FiniteAutomaton{

    public AFD6() {
        super("");
        //configuracion de transitions
        this.transitions.addTransition("1", "a", "4");
        this.transitions.addTransition("1", "b", "2");
        this.transitions.addTransition("2", "a", "4");
        this.transitions.addTransition("2", "b", "3");
        this.transitions.addTransition("3", "a", "4");
        //this.transitions.addTransition("3", "b", "5");
        this.transitions.addTransition("4", "a", "1");
        this.transitions.addTransition("4", "b", "5");
        this.transitions.addTransition("5", "a", "1");
        this.transitions.addTransition("5", "b", "6");
        this.transitions.addTransition("6", "a", "1");
        
        List<String> empieza = new LinkedList<>();
        empieza.add("1");
        
        List<String> termina = new LinkedList<>();
        termina.add("1");
        termina.add("2");
        termina.add("3");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_VI;
    }
    
}
