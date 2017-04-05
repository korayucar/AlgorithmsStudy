package xyz.korayucar.algorithmstudy.gridland;

/**
 * Created by koray on 04/04/17.
 */
public class BruteForceGridlandTest extends GridlandTest {

    @Override
    Gridland createGridland() {
        return new BruteForceGridland();
    }
}