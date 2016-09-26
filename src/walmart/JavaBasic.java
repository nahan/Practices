package walmart;

import java.util.Arrays;

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191594&highlight=walmart

//    2016(4-6月) 码农类 硕士 全职@walmartlab - 内推 - 技术电面 |Failfresh grad应届毕业生
//    今天拿到一个offer，把之前跪的各种面试都po出来攒人品。。。
//    先问了非常多的概念：
//    继承多态
//    abstract class和interface
//    什么是deadlock，
//    怎么解决deadlock，
//    hashmap内部实现，
//    semaphore和mutex
//    还有一些很简单的我不记得了。
//    
//    然后写了一道题，merge三个数组到第一个数组，in sorted order.

// https://leetcode.com/problems/merge-sorted-array/

public class JavaBasic {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
    
    public static int[] merge2SortedArray(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int index = result.length - 1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                result[index--] = nums1[i--];
            } else {
                result[index--] = nums2[j--];
            }
        }
        while (i >= 0) {
            result[index--] = nums1[i--];
        }
        while (j >= 0) {
            result[index--] = nums2[j--];
        }
        
        return result;
    }
    
    public static int[] merge3SortedArray(int[] nums1, int[] nums2, int[] nums3) {
        return merge2SortedArray(nums1, merge2SortedArray(nums2, nums3));
    }
    
    public static void test1() {
        int[] t1 = {1, 1, 1, 1, 1};
        int[] t2 = {2, 2, 2, 2};
        int[] t3 = {3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(Arrays.toString(merge3SortedArray(t1, t2, t3)));
    }
    
    public static void test2() {
        int[] t1 = {1, 1, 2, 3, 4};
        int[] t2 = {12, 22, 32, 42};
        int[] t3 = {31, 32, 33, 34, 35, 36, 37, 38};
        System.out.println(Arrays.toString(merge3SortedArray(t1, t2, t3)));
    }
    
    public static void main(String[] args) {
        test1();
        test2();
    }
    
}
