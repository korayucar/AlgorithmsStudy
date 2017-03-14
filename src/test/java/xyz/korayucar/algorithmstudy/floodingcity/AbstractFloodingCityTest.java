package xyz.korayucar.algorithmstudy.floodingcity;

import xyz.korayucar.algorithmstudy.floodingcity.FloodingCity;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * @author koray, @date 3/14/17 2:17 PM
 */
public abstract class AbstractFloodingCityTest {
    @Test
    public void testTrivialCase() {
        int [] city = { 4 , 1,3,4};
        assertCapacity(city, 4);
    }

    @Test
    public void testAlternation() {
        int [] city = { 4 , 1,4,1,4,1,4};
        assertCapacity(city, 9);
    }

    @Test
    public void testBigCity() {
        int [] city = { 2,6,3,5,2,8,1,4,2,2,5,3,5,7,4,1};
        assertCapacity(city, 9);
    }

    @Test(timeout = 3000)
    public void testVeryBigData() {
        int [] city = new int[100000];
        for(int i =1 ;i < 100000;i+=2)
            city[i] = 1;
        assertCapacity(city, 50000);
    }


    abstract FloodingCity createFloodingCity();

    private void assertCapacity(int[] city, int expected) {
        int capacity = createFloodingCity().getWaterCapacity(city);
        assertEquals(expected, capacity);
    }
}
