package facebook.medium;

public class FindTheCelebrity {

    public int findCelebrity(int n) {
        int i = 0;
        // filter out whom is not the celebrity
        for (int j = 1; j < n; j++) {
            if (knows(i, j)) {
                i = j;
            }
        }
        for (int j = 0; j < n; j++) {
            // anyone who doesn't know i or anyone who is known by i
            // is not the celebrity
            if (j != i && (!knows(j, i) || knows(i, j))) {
                return -1;
            }
        }
        return i;
    }
    
    // dummy method
    private boolean knows(int a, int b) {
        return false;
    }
}
