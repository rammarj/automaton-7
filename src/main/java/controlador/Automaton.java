package controlador;

/**
 *
 * @author Joaquin R. Martinez
 */
public interface Automaton {
    
    public static final int AFD_I = 0;
    public static final int AFD_II = 0;
    public static final int AFD_III = 0;
    public static final int AFD_IV = 0;
    public static final int AFD_V = 0;
    public static final int AFD_VI = 0;
    public static final int AFD_VII = 0;
    
    void compile();
    boolean isAccepted();
    int getAutomatonId();
    void evaluate(String eval);
}
