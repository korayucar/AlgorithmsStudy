package xyz.korayucar.algorithmstudy.floodingcity;

/**
 * Created by koray on 14/03/17.
 */
public class ParallelizedFloodingCityTest extends AbstractFloodingCityTest{

    @Override
    FloodingCity createFloodingCity() {
        return new ParallelizedFloodingCity();
    }
}