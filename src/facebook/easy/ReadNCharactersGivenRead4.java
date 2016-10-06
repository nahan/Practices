package facebook.easy;

// https://leetcode.com/problems/read-n-characters-given-read4/

// 157

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        int total = 0;
        int left = 0;
        int index = 0;
        char[] temp = new char[4];
        while (total < n && (left = read4(temp)) > 0) {
            left = Math.min(left, n - total);
            total += left;
            for (int i = 0; i < left; i++) {
                buf[index++] = temp[i];
            }
        }
        return total;
    }
    
    // dummy method
    private int read4(char[] buf) {
        return 1;
    }
}
