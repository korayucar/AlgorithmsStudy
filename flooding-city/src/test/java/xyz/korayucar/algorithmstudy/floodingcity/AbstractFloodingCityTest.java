package xyz.korayucar.algorithmstudy.floodingcity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/*
 * @author koray, @date 3/14/17 2:17 PM
 */
public abstract class AbstractFloodingCityTest {

    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testTrivialCase() {
        int[] city = {4, 1, 3, 4};
        assertCapacity(city, 4);
    }

    @Test(expected = NullPointerException.class)
    public void testNullCheckMade() {
        createFloodingCity().getWaterCapacity(null);
    }

    @Test
    public void testAlternatingInput() {
        int[] city = {4, 1, 4, 1, 4, 1, 4};
        assertCapacity(city, 9);
    }

    @Test
    public void testVeryLongBuildings() {
        int[] city = {1, 1<<10, 1<<15, 1, 1<<15, 1<<10, 4};
        assertCapacity(city, (1<<15) -1);
    }

    @Test
    public void testBigCity() {
        int[] city = {2, 6, 3, 5, 2, 8, 1, 4, 2, 2, 5, 3, 5, 7, 4, 1};
        assertCapacity(city, 35);
    }

    protected void assertCapacity(int[] city, int expected) {
        int capacity = createFloodingCity().getWaterCapacity(city);
        assertEquals(expected, capacity);
    }

    abstract FloodingCity createFloodingCity();
}
