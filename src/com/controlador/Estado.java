/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.util.Arrays;

/**
 *
 * @author Joaquin R. Martinez
 */
class Estado {
    private String[] transicion;   
    
    public Estado() {
        this.transicion = new String[3];
    }
    
    public String getNombreEstado(){
        return this.transicion[0];
    }
    
    public String getTransicion(){
        return this.transicion[2];
    }
    
    public String getSimbolo(){
        return this.transicion[1];
    }
    
    public void setNombreEstado(String estado){
        this.transicion[0] = estado;
    }
    
    public void setTransicion(String trancicion){
        this.transicion[2] = trancicion;
    }
    
    public void setSimbolo(String simbolo){
        this.transicion[1] = simbolo;
    }

    @Override
    public boolean equals(Object obj) {
        Estado es = (Estado) obj;
        return (getNombreEstado().equals(es.getNombreEstado()) && getSimbolo().equals(es.getSimbolo())
                && getTransicion().equals(es.getTransicion())); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Arrays.deepHashCode(this.transicion);
        return hash;
    }
    
}
