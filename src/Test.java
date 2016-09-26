import java.util.*;


public class Test {
    public static void main(String[] args) {
        String s = "!@\" test     tester testing";
        System.out.println(s);
        s = s.replaceAll("[^A-Za-z0-9 ]", "");
        System.out.println(s);
        s = s.replaceAll("\\s+", " ");
        System.out.println(s);
        String t = "test2";
        System.out.println(s.indexOf(t));
        String test = "test|test2";
        System.out.println(Arrays.toString(test.split("\\|")));
    }
}
