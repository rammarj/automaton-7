package controlador;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Joaquin R. Martinez
 */
public class Util {

    public static String serializar(LinkedList<String> str) {
        StringBuffer a = new StringBuffer();
        a.append("{ ");
        str.stream().forEach((next) -> {
            a.append(next).append(", ");
        });
        a.delete(a.length() - 2, a.length());
        a.append(" }");
        return a.toString();
    }

    public static LinkedList<String> dividir(String input) {
        LinkedList<String> a = new LinkedList<>();
        String[] split = input.split("\n");
        a.addAll(Arrays.asList(split));
        return a;
    }
    
    public static LinkedList<String> reversa(LinkedList<String> in){
        LinkedList<String> rev = new LinkedList<>();
        in.stream().map((next) -> new StringBuffer(next)).map((stringBuffer) -> {
            stringBuffer.reverse();
            return stringBuffer;
        }).forEach((stringBuffer) -> {
            rev.add(stringBuffer.toString());
        });
        return rev;
    }
    
    public static LinkedList<String> prefijos(String in){
        LinkedList<String> lista = new LinkedList<>();
        for (int i = 0; i <= in.length(); i++) {
            lista.add((i+1)+") "+in.substring(0, i));            
        }
        return lista;
    }
    
    public static LinkedList<String> sufijos(String in){
        LinkedList<String> lista = new LinkedList<>();
        for (int i = in.length(); i >=0; i--) {
            lista.add((i+1)+") "+in.substring(i, in.length()));            
        }
        return lista;
    }
    
}
