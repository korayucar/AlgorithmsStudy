package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * Created by koray on 14/03/17.
 */
public class KorayInefficientFloodingCityTest extends AbstractFloodingCityTest{

    @Override
    FloodingCity createFloodingCity() {
        return new KorayInefficientFloodingCity();
    }
}