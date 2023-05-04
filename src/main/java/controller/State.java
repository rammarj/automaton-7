package controller;

import java.util.Arrays;

/**
 *  The representation of an state
 * @author Joaquin R. Martinez
 */
class State {
    private String[] transition;   
    
    public State() {
        this.transition = new String[3]; /*From generated table*/
    }
    /**
     * Gets the name of this state
     */
    public String getName(){
        return this.transition[0];
    }
    /**
     * Gets the next transition
     */
    public String getTransition(){
        return this.transition[2];
    }
    /**
     * Gets the simbol
     */
    public String getSimbol(){
        return this.transition[1];
    }
    /**
     * Sets the name of this state
     */
    public void setName(String estado){
        this.transition[0] = estado;
    }
    /**
     * Set the next transition
     */
    public void setTransition(String transition){
        this.transition[2] = transition;
    }
    /**
     * Sets the simbol that contains this state
     */
    public void setSimbol(String simbol){
        this.transition[1] = simbol;
    }
    
    @Override
    public boolean equals(Object object) {
        State state = (State) object;
        return (getName().equals(state.getName()) 
                && getSimbol().equals(state.getSimbol())
                && getTransition().equals(state.getTransition())); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Arrays.deepHashCode(this.transition);
        return hash;
    }
    
}
