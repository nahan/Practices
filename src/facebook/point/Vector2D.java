package facebook.point;

// https://leetcode.com/problems/flatten-2d-vector/
// 251

import java.util.Iterator;
import java.util.List;

/**
 * Created by Han on 11/2/16.
 */
public class Vector2D implements Iterator<Integer> {

    private int i;
    private int j;
    private List<List<Integer>> list;

    public Vector2D(List<List<Integer>> vec2d) {
        i = 0;
        j = 0;
        list = vec2d;
    }

    @Override
    public Integer next() {
        List<Integer> item = list.get(i);
        while (i < list.size() && (item == null || item.isEmpty() || j == item.size())) {
            i++;
            j = 0;
            if (i < list.size()) {
                item = list.get(i);
            }
        }
        Integer result = item.get(j);
        j++;
        return result;
    }

    @Override
    public boolean hasNext() {
        int m = i;
        int n = j;
        if (m >= list.size()) {
            return false;
        }
        List<Integer> item = list.get(m);
        while (m < list.size() && (item == null || item.isEmpty() || n == item.size())) {
            m++;
            n = 0;
            if (m < list.size()) {
                item = list.get(m);
            }
        }
        return m < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
