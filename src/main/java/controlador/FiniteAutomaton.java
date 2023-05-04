package controlador;

/**
 *
 * @author Joaquin R. Martinez
 */
public class FiniteAutomaton implements Automaton{
    
    protected boolean accepted;
    protected String evaluatedString;
    protected Transition transitions;
    protected int errorSimbol;
    protected String errorMessage;
    
    FiniteAutomaton(String eval) {
        this.evaluatedString = "";
        this.errorMessage = "";
        this.accepted = true;
        this.transitions = new Transition();
        this.errorSimbol = 0;
    }
    
    @Override
    public boolean isAccepted() {
        return accepted;
    }

    @Override
    public void compile() {
        for (String empieza : this.transitions.getStartStates()) {
            boolean compile_ = compile_(empieza);
            if (compile_) {
                break;
            }
        }
    }

    private boolean compile_(String empieza){
        int i = 0;
        String[] split = this.evaluatedString.split("");
        boolean end_ok = false;
        for (String simbolo : split) {      
            i++;
            empieza = this.transitions.existTransition(empieza, simbolo);
            if ("".equals(empieza)) {
                this.accepted = false;
                this.errorSimbol = i;
                this.errorMessage = "The simbol '"+split[i-1]+"' has an error."
                        + " line 1, simbol "+this.errorSimbol;
                return false;
            }
        }
        for (String termina: this.transitions.getEndStates()) {
            if (empieza.equals(termina)) {
                end_ok = true;
            }            
        }
        if (!end_ok) {
            this.accepted = false;
            this.errorSimbol = i;
            if (this.errorMessage=="") {
                this.errorMessage = "El lenguaje no termina con el simbolo especificado"
                        + " linea 1, simbolo "+this.errorSimbol;
            }
            return false;
        }
        return true;
    }
    
    @Override
    public void evaluate(String eval) {
        if (eval == null) {
            throw  new NullPointerException("The evaluated language does not be null");
        }
        this.evaluatedString = eval;
    }

    @Override
    public int getAutomatonId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }    

    public String getEvaluatedString() {
        return evaluatedString;
    }

    public int getErrorSimbol() {
        return errorSimbol;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
}
