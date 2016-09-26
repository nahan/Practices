package walmart;

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=183670&highlight=walmart

//    2016(1-3月) 码农类 博士 全职@Walmart Labs - 猎头 - 技术电面 |Pass在职跳槽
//    问了两题，一道算法，一道database
//    
//    #1:
//    Given two strings A and B, find if B can be formed with letters in A.
//    
//    #2: 
//    Suppose you have a website like imdb.com. How do you design the database schema? Say you need to store movie and actor,
//    describe the schema 
//    Follow up: what if you need to information like producer, director, screenplay writer, etc., how would you modify your schema?

public class FormString {
    public static boolean formString(String a, String b) {
        int[] counter = new int[256];
        for (int i = 0; i < a.length(); i++) {
            counter[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            counter[b.charAt(i)]--;
        }
        for (int i = 0; i < b.length(); i++) {
            if (counter[b.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String a1 = "abcd";
        String b1 = "cabd";
        String a2 = "abcdef";
        String b2 = "cabd";
        String a3 = "addb";
        String b3 = "cd";
        
        System.out.println(formString(a1, b1));
        System.out.println(formString(a2, b2));
        System.out.println(formString(a3, b3));
    }
}
