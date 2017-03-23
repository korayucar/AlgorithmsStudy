package xyz.korayucar.algorithmstudy.floodingcity;

import org.junit.Test;

/**
 * @author koray
 * @version 3/23/17 7:44 PM.
 */
abstract class AbstractPerformantFloodingCityTest extends AbstractFloodingCityTest {


    @Test
    public void testVeryBigData() {
        int[] city = new int[100000];
        for (int i = 1; i < city.length; i += 2)
            city[i] = 1;
        assertCapacity(city, 49999);
    }

}
