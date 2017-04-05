package xyz.korayucar.algorithmstudy.gridland;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koray on 05/04/17.
 */
abstract class GridlandTest {

    abstract Gridland createGridland();

    @Test(expected = IllegalStateException.class)
    public void unitializedGridland_Occupy_FailsWithException() throws Exception {
        createGridland().occupy(0, 0, 0);
    }

    @Test(expected = IllegalStateException.class)
    public void unitializedGridland_GetUnoccupiedArea_FailsWithException() throws Exception {
        createGridland().getUnoccupiedArea();
    }

    @Test(expected = IllegalArgumentException.class)
    public void simpleSmallGridland_IllegalColumnNumbers_FailsWithException() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        gridland.occupy(0, 4, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void simpleSmallGridland_OutOfBoundColumnNumbers_FailsWithException() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        gridland.occupy(0, -1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void simpleSmallGridland_OutOfBoundColumnNumbers_FailsWithException2() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        gridland.occupy(0, 0, 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void simpleSmallGridland_OutOfBoundRowNumbers_FailsWithException2() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        gridland.occupy(-1, 0, 8);
    }

    @Test
    public void zeroSizedGrid_NoOccupations_GivesZeroUnoccupiedArea() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(0, 0);
        assertEquals(0, gridland.getUnoccupiedArea());
    }

    @Test
    public void simpleSmallGridland_OccupyFewAreas_GivesExpectedUnoccupiedArea() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        gridland.occupy(0, 0, 4);
        gridland.occupy(0, 0, 2);
        gridland.occupy(1, 1, 2);
        gridland.occupy(1, 0, 3);
        assertEquals(16, gridland.getUnoccupiedArea());
    }

    @Test
    public void simpleSmallGridland_TwoDisjointOccupationsInSameRow_GivesExpectedUnoccupiedArea() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        gridland.occupy(0, 0, 1);
        gridland.occupy(0, 3, 4);
        assertEquals(21, gridland.getUnoccupiedArea());
    }

    @Test
    public void simpleSmallGridland_OccupyAllTwice_GivesZeroUnoccupiedArea() throws Exception {
        Gridland gridland = createGridland();
        gridland.init(5, 5);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                gridland.occupy(i, 0, 4);
            }
        }
        assertEquals(0, gridland.getUnoccupiedArea());
    }
}
