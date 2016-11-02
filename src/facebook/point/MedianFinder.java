package facebook.point;

// https://leetcode.com/problems/find-median-from-data-stream/
// 295

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Han on 11/2/16.
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(10);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == 0) {
            maxHeap.offer(num);
        } else if (minHeap.size() == 0) {
            if (maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() <= num) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (minHeap.peek() <= num) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2d;
        } else {
            return (double) maxHeap.peek();
        }
    }


}
