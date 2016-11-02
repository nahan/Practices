package facebook.point;


//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206905&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D6%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3087%5D%5Bvalue%5D%3D4%26searchoption%5B3087%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//    
//    2016(10-12月) 码农类 硕士 全职@Facebook - 内推 - Onsite |Passfresh grad应届毕业生
//    今天刚收到fb的offer。进度条：8.23内推 - 9.20约 on campus - 9.23 on campus面试 - 9.26 通知onsit - 10.14 on site - 10.21 收到offer
//    由于签了NDA，这里就只说一下我个人觉得比较有意思的题目。
//    climbing stairs， rotate matrix
//    Populating Next Right Pointers in Each Node II, regex matching, decoding ways, two sums
//    我碰到了两轮behavior...应该有一轮是加面
//    ----------------------------------------
//    其实完全没想到能拿到Offer，只能说感谢behavior的三哥没有黑我吧，当然还有其他的面试官手下留情。

public class RotateMatrix {

    // a naive solution
    // 1. up side down swap
    // 2. diagonal swap
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int up = 0;
        int down = matrix.length - 1;
        while (up < down) {
            for (int k = 0; k < matrix[0].length; k++) {
                swap(matrix, up, down, k);
            }
            up++;
            down--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swap(matrix, i, j);
            }
        }
    }
    private void swap(int[][] matrix, int i, int j, int k) {
        int temp = matrix[i][k];
        matrix[i][k] = matrix[j][k];
        matrix[j][k] = temp;
    }
    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    // a tricky solution
    // swap four elements layer by layer
    public void rotateII(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // save top
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
    }
}
