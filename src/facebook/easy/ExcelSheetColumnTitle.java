package facebook.easy;

// https://leetcode.com/problems/excel-sheet-column-title/

// 168

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        convert(n, builder);
        return builder.toString();
    }
    private void convert(int n, StringBuilder builder) {
        if (n <= 26) {
            builder.append((char) ('A' - 1 + n));
        } else {
            convert((n - 1) / 26, builder);
            n = n % 26;
            if (n == 0) {
                n = 26;
            }
            convert(n, builder);
        }
    }
}
