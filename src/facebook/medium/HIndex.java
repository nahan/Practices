package facebook.medium;

import java.util.*;

// https://leetcode.com/problems/h-index/

// 274

public class HIndex {

    // 1. sort the array -> O(NlgN)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
    
    // 2. use extra space
    // The idea is to see that the result can only range from 0 to the length of the array 
    // (because we can't have h-index greater than the total papers published). 
    // So we create an array "arr" which acts like a HashMap (using pigeon hole principle) 
    // and loop backwards from the highest element, then 
    // we find "tot" which is the total number of papers that has more than i citations, 
    // and we stop when tot>=i (total number of papers with more than i citations >= i). 
    // We don't need to keep going because we are trying the biggest i possible, 
    // we we stop and return the result.
    
    // The idea is to use another array, index is the citation and value is the number of papers 
    // that has at least the citation. Since the h-index can only be n, 
    // the new array will only need the index to be at most n, 
    // thus the array size will only need n+1. 
    // Papers that have more than n citations will store in array[n].
    // Go through the array based on h index definition: array[i]>=i, find the max value of i.
    public int hIndexII(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        // create an array to count the number for same frequency citation
        int[] count = new int[citations.length + 1];
        for (int cite: citations) {
            // if the cite number is larger than the length, accelerate the last node
            if (cite >= citations.length) {
                count[count.length - 1]++;
            } else {
                count[cite]++;
            }
        }
        int h = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            h += count[i];
            if (h >= i) {
                return i;
            }
        }
        return h;
    }
}
