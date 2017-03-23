package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * Created by koray on 14/03/17.
 */
public class InefficientFloodingCityTest extends AbstractPerformantFloodingCityTest{

    @Override
    FloodingCity createFloodingCity() {
        return new InefficientFloodingCity();
    }
}