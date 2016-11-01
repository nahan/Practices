package facebook.hard;

// https://leetcode.com/problems/text-justification/
// 68

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 11/1/16.
 */
public class TextJustification {

    // dirty work
    // keep in mind that:
    // 1. Extra spaces between words should be distributed as evenly as possible.
    // 2. For the last line of text, it should be left justified and no extra space is inserted between words.
    // 3. A line other than the last line might contain only one word. In this case, that line should be left-justified.
    //
    // so,
    // 1. add all same line possible words into a list
    // 2. so we can form a list in which each element is a list containing all same line words
    // 3. go through this list
    // 4. for each line words list, count the length
    // 5. if the list has only one element, keep adding space to the tail
    // 6. if this list is the last line, keep adding space to the last word
    // 7. otherwise, keep adding space to each word except the last word
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        int index = 0;
        int length = 0;
        for (String word: words) {
            if (length + word.length() <= maxWidth) {
                lists.get(index).add(word);
                length += word.length() + 1;
            } else {
                lists.add(new ArrayList<>());
                index++;
                lists.get(index).add(word);
                length = word.length() + 1;
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            length = 0;
            for (String word: list) {
                length += word.length();
            }
            if (list.size() == 1) {
                while (list.get(0).length() < maxWidth) {
                    list.set(0, list.get(0) + " ");
                }
            } else if (i == lists.size() - 1) {
                for (int j = 0; j < list.size() - 1; j++) {
                    list.set(j, list.get(j) + " ");
                    length++;
                }
                while (length < maxWidth) {
                    list.set(list.size() - 1, list.get(list.size() - 1) + " ");
                    length++;
                }
            } else {
                int j = 0;
                while (length < maxWidth) {
                    list.set(j, list.get(j) + " ");
                    length++;
                    j++;
                    if (j == list.size() - 1) {
                        j = 0;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (String word: list) {
                builder.append(word);
            }
            result.add(builder.toString());
        }
        return result;
    }
}
