package xyz.korayucar.algorithmstudy.floodingcity;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The basic idea;
 *
 * For each building the height when flooded will reach either the maximum height to the left of it
 * or the maximum value to the right. The height will be minimum of both. The water colum height is
 * found by subtracting the building height itself. The water column height is accumulated for each
 * building.
 *
 * This is an O(nlgn) time, O(n) space implementation of the basic idea.
 *
 * Created by koray on 14/03/17.
 *
 */
public class KorayInefficientFloodingCity implements FloodingCity {



    @Override
    public int getWaterCapacity(int[] city) {
        if(city == null)
            throw new NullPointerException();

        int capacity = 0;
        //using both with reverse comparators to achive max priority queue
        PriorityQueue<Integer> left = new PriorityQueue<>(city.length, Comparator.<Integer>reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>(city.length, Comparator.<Integer>reverseOrder());

        //initially add all elements to right priority queue
        for (int i : city)
            right.add(i);

        for (int i : city) {
            right.remove(i);
            left.add(i);//note that left side include building itself
            int l = left.peek() == null ? 0 : left.peek(); // max element on the left
            int r = right.peek() == null ? 0 : right.peek(); //max element on the right
            capacity += Math.max(0, Math.min(l, r) - i);
        }
        return capacity;


    }
}
