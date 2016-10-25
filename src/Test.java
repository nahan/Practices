import java.util.*;


public class Test {
    public static void main(String[] args) {
//        String s = "!@\" test     tester testing";
//        System.out.println(s);
//        s = s.replaceAll("[^A-Za-z0-9 ]", "");
//        System.out.println(s);
//        s = s.replaceAll("\\s+", " ");
//        System.out.println(s);
//        String t = "test2";
//        System.out.println(s.indexOf(t));
//        String test = "test|test2";
//        System.out.println(Arrays.toString(test.split("\\|")));
//        System.out.println(Math.sqrt(2));

        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");
        String s4 = new String("a");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

    }
}
