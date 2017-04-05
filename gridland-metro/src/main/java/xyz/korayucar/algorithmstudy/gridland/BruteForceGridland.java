package xyz.korayucar.algorithmstudy.gridland;

/**
 * @author osmanalper
 * @version 27/03/2017.
 */
public class BruteForceGridland implements Gridland {

    boolean[][] gridland;

    @Override
    public void init(int numberOfRows, int numberOfColumns) {
        validateNotInitialized();
        gridland = new boolean[numberOfRows][numberOfColumns];
    }

    @Override
    public void occupy(int rowNumber, int startingColumnNumberInc, int endingColumnNumberInc) {
        validateOccupy(rowNumber, startingColumnNumberInc, endingColumnNumberInc);
        for (int i = startingColumnNumberInc; i <= endingColumnNumberInc; i++)
            gridland[rowNumber][i] = true;
    }

    @Override
    public int getUnoccupiedArea() {
        validateInitialized();
        int unoccupiedArea = 0;
        for (boolean[] row : gridland) {
            for (boolean cell : row) {
                if (!cell)
                    unoccupiedArea++;
            }
        }
        return unoccupiedArea;
    }

    private void validateNotInitialized() {
        if (gridland != null)
            throw new IllegalStateException("Already initialized.");
    }

    private void validateOccupy(int rowNumber, int startingColumnNumberInc, int endingColumnNumberInc) {
        validateInitialized();
        if (rowNumber < 0 || rowNumber >= gridland.length)
            throw new IndexOutOfBoundsException("row number is out of grid");
        int length = gridland[rowNumber].length;
        if (startingColumnNumberInc < 0 || startingColumnNumberInc >= length)
            throw new IndexOutOfBoundsException("starting column number is out of grid");
        if (endingColumnNumberInc < 0 || endingColumnNumberInc >= length)
            throw new IndexOutOfBoundsException("ending column number is out of grid");
        if (startingColumnNumberInc > endingColumnNumberInc)
            throw new IllegalArgumentException("end column can not be before start column");
    }

    private void validateInitialized() {
        if (gridland == null)
            throw new IllegalStateException(getClass().getName() + " not initialized");
    }

}
