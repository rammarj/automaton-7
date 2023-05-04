package controlador;

import java.util.LinkedList;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD5 extends AFD4{

    public AFD5() {
        //configuracion de transitions
        LinkedList<String> empieza = new LinkedList<>();
        empieza.add("1");
        
        LinkedList<String> termina = new LinkedList<>();
        termina.add("1");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_V;
    }
    
}
