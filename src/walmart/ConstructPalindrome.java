package walmart;

import java.util.*;

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=140414&highlight=walmart

//    phone:
//    1 given string, check if you can construct palindrome with it
//    aab: true (aba)
//    aabb: true (abba or baab)
//    abc: false (can not construct a palindrome)
//    follow up: return all palindrome that construct by the given str
//    onsite:
//    1 largest rectangle in histogram LC;
//    climbing stairs LC
//    2 lunch
//    3 sort colors LC;
//    design some thing
//    4 http://stackoverflow.com/questions/3810789/removal-of-every-kth-person-from-a-circle-find-the-last-remaining-person
//    follow up: improve time complexity, in only O(n) time, not O(kn)
//    5 BST node with parent and child reference, find next bigger one;
//    other one is easy, do not remember

// https://leetcode.com/problems/palindrome-permutation/

public class ConstructPalindrome {
    
    // leetcode 266
    public static boolean canPermutePalindrome(String s) {
        int[] counter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }
        int count = 0;
        for (int i: counter) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count < 2;
    }
    
    public static List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int[] counter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }
        char pivot = ' ';
        int odd = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] % 2 != 0) {
                odd++;
                pivot = (char) i;
            }
        }
        if (odd >= 2) {
            return result;
        }
        counter[pivot]--;
        List<Character> array = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 1) {
                for (int j = 0; j < counter[i] / 2; j++) {
                    array.add((char) i);
                }
            }
        }
        Set<String> set = permutation(array);
        String pivotStr = "";
        if (pivot != ' ') {
            pivotStr = String.valueOf(pivot);
        }
        for (String item: set) {
            result.add(item + pivotStr + new StringBuilder(item).reverse());
        }
        return result;
    }
    
    private static Set<String> permutation(List<Character> array) {
        Set<String> set = new HashSet<>();
        
        Collections.sort(array);
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[array.size()];
        dfs(set, builder, visited, array);
        
        return set;
    }
    
    private static void dfs(Set<String> set, StringBuilder builder, boolean[] visited, List<Character> array) {
        if (builder.length() == array.size()) {
            set.add(builder.toString());
        }
        for (int i = 0; i < array.size(); i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && array.get(i - 1) == array.get(i) && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            builder.append(array.get(i));
            dfs(set, builder, visited, array);
            builder.deleteCharAt(builder.length() - 1);
            visited[i] = false;
        }
    }
 
    
    
    public static void main(String[] args) {
        
        String[] test = {"aab", "aabb", "abc", "aaabbbbcccccc", "aabbcc", "aabbc", "aabbhijkkjih"};
        
        for (String t: test) {
            if (canPermutePalindrome(t)) {
                System.out.println("from: " + t);
                System.out.println(generatePalindromes(t));
            }
        }
        
    }
}
