package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * Created by koray on 17/03/17.
 */
public class VeryInefficientFloodingCityTest extends AbstractFloodingCityTest {

    @Override
    FloodingCity createFloodingCity() {
        return new VeryInefficientFloodingCity();
    }
}