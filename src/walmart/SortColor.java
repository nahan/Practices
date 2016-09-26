package walmart;

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

// https://leetcode.com/problems/sort-colors/

public class SortColor {

    public void sortColors(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, index++, i);
            }
        }
        index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                swap(nums, index--, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
