package controller;

/**
 *
 * @author Joaquin R. Martinez
 */
public interface Automaton {
    
    public static final int AFD_I = 1;
    public static final int AFD_II = 2;
    public static final int AFD_III = 3;
    public static final int AFD_IV = 4;
    public static final int AFD_V = 5;
    public static final int AFD_VI = 6;
    public static final int AFD_VII = 7;
    
    void compile();
    boolean isAccepted();
    int getAutomatonId();
    void evaluate(String eval);
}
