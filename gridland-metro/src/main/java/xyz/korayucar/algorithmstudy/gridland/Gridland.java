package xyz.korayucar.algorithmstudy.gridland;

/**
 * Created by koray on 05/04/17.
 */
public interface Gridland {

    void init(int numberOfRows, int numberOfColumns);

    void occupy(int rowNumber, int startingColumnNumberInc, int endingColumnNumberInc );

    int getUnoccupiedArea();

}
