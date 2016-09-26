import java.util.*;

public class Donson {
    
    public static List<String> filter(String s) {
        
        String[] array = s.split("\\|");
        String[] normal = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            normal[i] = normalize(array[i]);
        }
        boolean[] sub = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (normal[i].equals(normal[j])) {
                    if (array[i].length() <= array[j].length()) {
                        sub[j] = true;
                    } else {
                        sub[i] = true;
                    }
                } else if (normal[i].indexOf(normal[j]) != -1) {
                    sub[j] = true;
                } else if (normal[j].indexOf(normal[i]) != -1) {
                    sub[i] = true;
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!sub[i]) {
                result.add(array[i]);
            }
        }
        return result;
    }
    
    public static String normalize(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9 ]", "");
        s = s.replaceAll("\\s+", " ");
        return s.trim();
    }
    
    public static void main(String[] args) {
        
        String t1 = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution| ibm cognitive  computing|'IBM Cognitive Computing' is a revolution?";
        System.out.println(filter(t1));
        
        String t2 = "\"Computer Science Department\"|Computer-Science-Department|the \"computer science department\"";
        System.out.println(filter(t2));
    }

}
