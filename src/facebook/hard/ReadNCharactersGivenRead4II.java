package facebook.hard;

// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
// 158

// https://leetcode.com/problems/read-n-characters-given-read4/
// 157
/**
 * Created by Han on 10/31/16.
 */
public class ReadNCharactersGivenRead4II {

    // dummy method
    private int read4(char[] buf) {
        return 0;
    }

    // 157
    // use a 4 length char array as a cup to take characters from the file
    // int total as the total reading number
    // int read as the current reading number when calling read4
    // when total < n and read4 still has info,
    // keep reading
    // only copy the amount we need from cup to the buf
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int total = 0;
        int read = 0;
        while (total < n && (read = read4(temp)) > 0) {
            read = Math.min(read, n - total);
            for (int i = 0; i < read; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }

    // 158
    // use a temp array to store elements read from file
    private char[] temp = new char[4];
    // keep tracking how many elements read in the temp
    private int tempRead = 0;
    // keep tracking the stop index from last reading
    private int tempIndex = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int readII(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            // there is no element left in the temp array
            // so we can read new from file
            if (tempIndex == 0) {
                tempRead = read4(temp);
            }
            // there is nothing read
            if (tempRead == 0) {
                break;
            }
            // 1. if there are elements left in the temp array, copy them into the buf, or
            // 2. copy the copied element into the buf
            while (total < n && tempIndex < tempRead) {
                buf[total++] = temp[tempIndex++];
            }
            // if copied all the element, which means no element left in the temp array,
            // then set temp index as 0
            if (tempIndex == tempRead) {
                tempIndex = 0;
            }
        }
        return total;
    }
}
