package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * Created by koray on 17/03/17.
 */
public class KorayVeryInefficientFloodingCity implements FloodingCity{

    @Override
    public int getWaterCapacity(int[] city) {
        if(city == null)
            throw new NullPointerException();
        if(city.length < 2)
            return 0;
        int capacity = 0;
        for(int i = 0; i < city.length ; i++)
        {
            int maxToLeft = getMaxInRange(city, 0,i);
            int maxToRight = getMaxInRange(city, i+1,city.length);
            capacity += Math.max(0, Math.min(maxToLeft,maxToRight) - city[i]);
        }

        return capacity;
    }

    private int getMaxInRange(int[] city, int rangeStartInclusive, int rangeEndExclusive) {
        int maxInrange = 0;
        for (int j = rangeStartInclusive; j < rangeEndExclusive; j++) {
            maxInrange = Math.max(maxInrange, city[j]);
        }
        return maxInrange;
    }
}
