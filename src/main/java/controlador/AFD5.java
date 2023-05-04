package controlador;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFD5 extends AFD4{

    public AFD5() {
        //configuracion de transitions
        List<String> empieza = new LinkedList<>();
        empieza.add("1");
        
        List<String> termina = new LinkedList<>();
        termina.add("1");
        
        this.transitions.setStartStates(empieza);
        this.transitions.setEndStates(termina);
    }
    
    @Override
    public int getAutomatonId() {
        return AFD_V;
    }
    
}
