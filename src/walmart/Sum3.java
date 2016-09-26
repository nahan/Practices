package walmart;
import java.util.*;
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=156069&highlight=walmart

//    2015(10-12月) 码农类 硕士 全职@Walmart Lab - 内推 - Onsite |Failfresh grad应届毕业生
//    楼主上周去 walmart Lab onsite.
//    6轮面试都是印度哥哥,  结果最后一面出了个 这样的题, 一口老血吐在墙上.
//    
//    题目是  3-sum 变形. 
//    
//    给一个数组 a, 求出 里面的三个数的组合 满足以下三个条件:
//    
//    1. a[i] + a[j] + a[k] < target
//    2. a[i] < a[j] < a[k]
//    3. i < j < k    (i, j ,k 是数的index)
//    
//    要求返回所有满足条件的组合.
//    例如 a [-2, 3, 0, 4]    targt:  6   应该返回:    [ [-2, 3, 4] ]
//    如果是 [-3, 2, 0, -2, 1, 5] target: 6 应该返回 [[-3, 0, 1], [-3, 0, 5], [-3, 2, 5], [-3, 1, 5], [-2, 1, 5]]
//    
//    要求时间复杂度是 O(n^2) 的 
//    
//    楼主试了很多方法都没法用O(n^2)完成, 只给出了 O(n^3)的解法. 
//    
//    最后 面试官给了一个方法, 先排序, 保存二元元祖(a[i], i)
//    然后先取 中间元素k, 从中间往俩边遍历. 我觉得没法在O(n^2)时间内做出来, 但是因为时间不够了,所以也没法深入的聊
//    
//    楼主的其他面都很好, 但是这一轮没做出来, 最后面试官把 a[i] + a[j] + a[k] < target 改成了 a[i] + a[j] + a[k] = target.
//    楼主写了个 O(n^2)的解法.
//    
//    总之, 楼主觉得这个题目各种扯, 想了好几天都没想出来合理的解法, 有大神给一个详细的解法吗?

// https://leetcode.com/problems/3sum-smaller/

public class Sum3 {
    
    public static List<List<Integer>> threeSumSmaller(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> list = twoSumSmaller(nums, i + 1, target - nums[i]);
            for (List<Integer> item: list) {
                result.add(Arrays.asList(nums[i], item.get(0), item.get(1)));
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSumSmaller(int[] nums, int startIndex, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                for (int i = right; i > left; i--) {
                    list.add(Arrays.asList(nums[left], nums[i]));
                }
                left++;
            } else {
                right--;
            }
        }
        return list;
    }
    
    public static int threeSumSmaller1(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller1(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private static int twoSumSmaller1(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] a1 = {-2, 3, 0, 4};
        int[] a2 = {-3, 2, 0, -2, 1, 5};
        
        System.out.println(threeSumSmaller(a1, 6));
        System.out.println(threeSumSmaller(a2, 6));
        
        System.out.println(threeSumSmaller1(a1, 6));
        System.out.println(threeSumSmaller1(a2, 6));
    }
}
