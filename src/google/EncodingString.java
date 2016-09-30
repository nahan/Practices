package google;

public class EncodingString {
    
    public static String encode(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pre) {
                count++;
            } else {
                builder.append(count);
                builder.append('x');
                builder.append(pre);
                pre = c;
                count = 1;
            }
        }
        builder.append(count);
        builder.append('x');
        builder.append(pre);
        return builder.toString();
    }
    
    public static String decode(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i + 3;
            while (j < s.length() && (s.charAt(j) < '0' || s.charAt(j) > '9')) {
                j++;
            }
            char c = s.charAt(j - 1);
            int count = Integer.parseInt(s.substring(i, j - 2));
            for (int k = 0; k < count; k++) {
                builder.append(c);
            }
            i = j;
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        String s1 = "aaaabb";
        String s2 = "a";
        String s3 = "aaabbcce";
        String s4 = "nahan";
        String s5 = "";
        String s6 = "aaaaaaaaaaaaaabbbc";
        System.out.println(encode(s1));
        System.out.println(encode(s2));
        System.out.println(encode(s3));
        System.out.println(encode(s4));
        System.out.println(encode(s5));
        System.out.println(encode(s6));
        
        System.out.println(decode(encode(s1)));
        System.out.println(decode(encode(s2)));
        System.out.println(decode(encode(s3)));
        System.out.println(decode(encode(s4)));
        System.out.println(decode(encode(s5)));
        System.out.println(decode(encode(s6)));
    }

}
