package facebook.hard;

// https://leetcode.com/problems/integer-to-english-words/

// 273

/**
 * Created by Han on 10/11/16.
 */
public class IntegerToEnglishWords {

    public static final int BILLION = 1000000000;
    public static final int MILLION = 1000000;
    public static final int THOUSAND = 1000;
    public static final int HUNDRED = 100;
    public static final int TEN = 10;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 0) {
            return "Minus " + tenDigits(-num);
        } else {
            return tenDigits(num);
        }
    }
    private String tenDigits(int num) {
        if (num < BILLION) {
            return sevenDigits(num);
        }
        String prefix = threeDigits(num / BILLION);
        String suffix = sevenDigits(num % BILLION);
        if (prefix.isEmpty()) {
            return suffix.trim();
        }
        if (suffix.isEmpty()) {
            return prefix + " Billion";
        }
        return prefix + " Billion " + suffix;
    }
    private String sevenDigits(int num) {
        if (num < MILLION) {
            return fourDigits(num);
        }
        String prefix = threeDigits(num / MILLION);
        String suffix = fourDigits(num % MILLION);
        if (prefix.isEmpty()) {
            return suffix.trim();
        }
        if (suffix.isEmpty()) {
            return prefix + " Million";
        }
        return prefix + " Million " + suffix;
    }
    private String fourDigits(int num) {
        if (num < THOUSAND) {
            return threeDigits(num);
        }
        String prefix = threeDigits(num / THOUSAND);
        String suffix = threeDigits(num % THOUSAND);
        if (prefix.isEmpty()) {
            return suffix.trim();
        }
        if (suffix.isEmpty()) {
            return prefix + " Thousand";
        }
        return prefix + " Thousand " + suffix;
    }
    private String threeDigits(int num) {
        if (num < HUNDRED) {
            return twoDigits(num);
        }
        String prefix = oneDigit(num / HUNDRED);
        String suffix = twoDigits(num % HUNDRED);
        if (prefix.isEmpty()) {
            return suffix.trim();
        }
        if (suffix.isEmpty()) {
            return prefix + " Hundred";
        }
        return prefix + " Hundred " + suffix;
    }
    private String twoDigits(int num) {
        if (num < TEN) {
            return oneDigit(num);
        }
        String prefix = "";
        switch(num / TEN) {
            case 1: break;
            case 2: prefix += "Twenty"; break;
            case 3: prefix += "Thirty"; break;
            case 4: prefix += "Forty"; break;
            case 5: prefix += "Fifty"; break;
            case 6: prefix += "Sixty"; break;
            case 7: prefix += "Seventy"; break;
            case 8: prefix += "Eighty"; break;
            case 9: prefix += "Ninety"; break;
            default: break;
        }
        if (prefix.isEmpty()) {
            switch(num) {
                case 10: return "Ten";
                case 11: return "Eleven";
                case 12: return "Twelve";
                case 13: return "Thirteen";
                case 14: return "Fourteen";
                case 15: return "Fifteen";
                case 16: return "Sixteen";
                case 17: return "Seventeen";
                case 18: return "Eighteen";
                case 19: return "Nineteen";
                default: break;
            }
        }
        String suffix = oneDigit(num % 10);
        if (suffix.isEmpty()) {
            return prefix;
        }
        return prefix + " " + suffix;
    }
    private String oneDigit(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: break;
        }
        return "";
    }

    public static void main(String[] args) {
        IntegerToEnglishWords solution = new IntegerToEnglishWords();
        int[] inputs = {0, 1, 23, 123, 2345, 34567, 456789, 5678900, 12345678, 234567890, 2056789012, 50868};
        for (int i: inputs) {
            System.out.println(i + " -> " + solution.numberToWords(i));
        }
    }
}
