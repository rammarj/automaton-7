
package com.controlador;

import java.util.LinkedList;

/**
 *
 * @author Joaquin R. Martinez
 */
public class Transiciones {

    private LinkedList<Estado> estados;
    private LinkedList<String> empieza, termina;
    
    
    public Transiciones() {
        this.estados = new LinkedList<>();
        this.empieza = new LinkedList<>();
        this.termina = new LinkedList<>();
    }
    
    private void addTransicion(Estado estado){
        if (estado == null) {
            throw new NullPointerException("El estado no debe ser nulo");
        }
        if (this.estados.contains(estado)) {
            throw new IllegalArgumentException("El estado ya esta agregado.");
        }
        this.estados.add(estado);
    }
    
    public void addTransicion(String estado, String simbolo, String transicion){
        if (estado == null || simbolo == null || transicion == null) {
            throw new NullPointerException();
        }
        Estado es = new Estado();
        es.setNombreEstado(estado);
        es.setSimbolo(simbolo);
        es.setTransicion(transicion);
        addTransicion(es);
    }
    
    public String existeTransicion(String estado, String simbolo){
        for (Estado next : this.estados) {
            //System.out.println(next.getTransicion());
            if (next.getNombreEstado().equals(estado) && next.getSimbolo().equals(simbolo)) {
                return next.getTransicion();
            }
        }
        return "";
    }
    
    public LinkedList<Estado> getEstados() {
        return estados;
    }

    public LinkedList<String> getEmpieza() {
        return empieza;
    }

    public void setEmpieza(LinkedList<String> empieza) {
        if (empieza == null) {
            throw new NullPointerException("Em estado inicial no debe ser nulo");
        }
        for (String next : empieza) {
            boolean existe = false;
            for (Estado next1 : this.estados) {
                if (next1.getNombreEstado().equals(next)) {
                    existe = true;
                }
            }
            if (!existe) {
                throw new IllegalArgumentException("El estado inicial especificado no existe");
            }
        }
        this.empieza = empieza;
    }

    public LinkedList<String> getTermina() {
        return termina;
    }

    public void setTermina(LinkedList<String> termina) {
        if (termina == null) {
            throw new NullPointerException("Em estado inicial no debe ser nulo");
        }
        for (String next : termina) {
            boolean existe = false;
            for (Estado next1 : this.estados) {
                if (next1.getNombreEstado().equals(next)) {
                    existe = true;
                }
            }
            if (!existe) {
                throw new IllegalArgumentException("El estado terminal especificado no existe");
            }
            this.termina = termina;
        }
        
    }
    
    
    
}
