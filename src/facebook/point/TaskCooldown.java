package facebook.point;

// http://www.1point3acres.com/bbs/thread-188881-1-1.html

//        # Tasks: 1, 1, 2, 1
//        # Recovery interva (cooldown): 2
//        # Output: 7  (order is 1 _ _ 1 2 _ 1)
//
//        # Example 2
//
//        # Tasks: 1, 2, 3, 1, 2, 3
//        # Recovery interval (cooldown): 3
//        # Output: 7  (order is 1 2 3 _ 1 2 3)
//
//        # Example 3
//
//        # Tasks: 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4
//        # Recovery interval (cooldown): 6
//        # Output: 18  (1 2 3 4 5 6 _ _ 2 _ 4 _ 6 1 _ 2 _ 4)

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Han on 11/2/16.
 */
public class TaskCooldown {

    // a O(N * cooldown) solution
    public int timeNeeded(int[] tasks, int cooldown) {
        if (tasks == null) {
            return 0;
        }
        if (tasks.length < 2 || cooldown == 0) {
            return tasks.length;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(tasks[0]);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(tasks[0], cooldown);
        int index = 1;
        for (int i = 1; i < tasks.length; i++) {
            if (map.containsKey(tasks[i]) && map.get(tasks[i]) >= index) {
                int length = map.get(tasks[i]) - index + 1;
                for (int j = 0; j < length; j++) {
                    builder.append('_');
                }
                index += map.get(tasks[i]) - index + 1;
            }
            map.put(tasks[i], index + cooldown);
            index++;
            builder.append(tasks[i]);
        }
        System.out.println(builder.toString());
        return index;
    }

    public static void main(String[] args) {
        TaskCooldown solution = new TaskCooldown();
        int[] t1 = {1, 1, 2, 1};
        int[] t2 = {1, 2, 3, 1, 2, 3};
        int[] t3 = {1, 2, 3, 4, 5, 6, 2, 4, 6, 1, 2, 4};
        int[] t4 = {1, 2, 3};
        int[] t5 = {1, 2, 3, 1};
        int[] t6 = {1, 2, 3, 1, 2};
        System.out.println(solution.timeNeeded(t1, 2));
        System.out.println(solution.timeNeeded(t2, 3));
        System.out.println(solution.timeNeeded(t3, 6));
        System.out.println(solution.timeNeeded(t4, 3));
        System.out.println(solution.timeNeeded(t5, 3));
        System.out.println(solution.timeNeeded(t6, 3));
    }
}
