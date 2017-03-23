package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * @author koray
 * @version 3/14/17 2:43 PM.
 */
public class EfficientFloodingCityTest extends AbstractPerformantFloodingCityTest {
    @Override
    FloodingCity createFloodingCity() {
        return new EfficientFloodingCity();
    }


}
