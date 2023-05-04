package controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joaquin R. Martinez
 */
public class Util {

    public static String serializar(List<String> str) {
        return String.format("{ %s }", String.join(", ", str));
    }

    public static List<String> dividir(String input) {
        String[] split = input.split("\n");
        return Arrays.asList(split);
    }
    
    public static List<String> reversa(List<String> in){
        List<String> rev = in.stream().map((next) -> new StringBuffer(next)).map((stringBuffer) -> {
            stringBuffer.reverse();
            return stringBuffer.toString();
        }).toList();
        return rev;
    }
    
    public static List<String> prefijos(String in){
        LinkedList<String> lista = new LinkedList<>();
        for (int i = 0; i <= in.length(); i++) {
            lista.add((i+1)+") "+in.substring(0, i));            
        }
        return lista;
    }
    
    public static List<String> sufijos(String in){
        LinkedList<String> lista = new LinkedList<>();
        for (int i = in.length(); i >=0; i--) {
            lista.add((i+1)+") "+in.substring(i, in.length()));            
        }
        return lista;
    }
    
}
