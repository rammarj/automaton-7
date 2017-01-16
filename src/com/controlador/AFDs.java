/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

/**
 *
 * @author Joaquin R. Martinez
 */
public class AFDs implements Automata{
    
    protected boolean accepted;
    protected String eval;
    protected Transiciones transiciones;
    protected int simbolo_error;
    protected String msg_error;
    
    AFDs(String eval) {
        this.eval = "";
        this.msg_error = "";
        this.accepted = true;
        this.transiciones = new Transiciones();
        this.simbolo_error = 0;
    }
    
    @Override
    public boolean isAccepted() {
        return accepted;
    }

    @Override
    public void compile() {
        for (String empieza : this.transiciones.getEmpieza()) {
            boolean compile_ = compile_(empieza);
            if (compile_) {
                break;
            }
        }
    }

    private boolean compile_(String empieza){
        int i = 0;
        String[] split = this.eval.split("");
        boolean end_ok = false;
        for (String simbolo : split) {      
            i++;
            empieza = this.transiciones.existeTransicion(empieza, simbolo);
            if ("".equals(empieza)) {
                this.accepted = false;
                this.simbolo_error = i;
                this.msg_error = "El simbolo '"+split[i-1]+"' no concuerda con una transicion."
                        + " linea 1, simbolo "+this.simbolo_error;
                return false;
            }
        }
        for (String termina: this.transiciones.getTermina()) {
            if (empieza.equals(termina)) {
                end_ok = true;
            }            
        }
        if (!end_ok) {
            this.accepted = false;
            this.simbolo_error = i;
            if (this.msg_error=="") {
                this.msg_error = "El lenguaje no termina con el simbolo especificado"
                        + " linea 1, simbolo "+this.simbolo_error;
            }
            return false;
        }
        return true;
    }
    
    @Override
    public void setEval(String eval) {
        if (eval == null) {
            throw  new NullPointerException("El lenguahe a evaluar no debe ser nulo");
        }
        this.eval = eval;
    }

    @Override
    public int getAL_ID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }    

    public String getEval() {
        return eval;
    }

    public int getSimbolo_error() {
        return simbolo_error;
    }

    public String getMsg_error() {
        return msg_error;
    }
    
}
