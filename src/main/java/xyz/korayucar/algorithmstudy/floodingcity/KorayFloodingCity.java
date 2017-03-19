package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * The basic idea;
 *
 * For each building the height when flooded will reach either the maximum height to the left of it
 * or the maximum value to the right. The height will be minimum of both. The water colum height is
 * found by subtracting the building height itself. The water column height is accumulated for each
 * building.
 *
 * This is an O(n) time, O(n) space implementation of the basic idea.
 *
 * Created by koray on 14/03/17.
 *
 */
public class KorayFloodingCity implements FloodingCity {

    @Override
    public int getWaterCapacity(int[] city) {

        //make input checks
        if(city == null)
            throw new NullPointerException();
        if(city.length <= 2)
            return 0;

        //keep the maximum height to the left of the building at index(exclusive)
        int[] maxToLeft = new int[city.length];
        int[] maxToRight = new int[city.length];

        //calculate the height of the maximum buildig to left
        for(int i = 1 ; i < city.length ; i++)
            maxToLeft[i] = Math.max(city[i-1],maxToLeft[i-1]);


        for(int i = city.length -2 ; i >=0; i--)
            maxToRight[i] = Math.max(city[i+1],maxToRight[i+1]);

        //iterate from right to left find the amount of water in column.
        int capacity = 0;
        for(int i = city.length -1 ; i >=0; i--) {
            capacity += Math.max(Math.min(maxToLeft[i], maxToRight[i]) - city[i], 0);
        }

        return capacity;
    }
}
