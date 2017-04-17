package xyz.korayucar.algorithmstudy.gcd;

/**
 * Created by koray on 18/04/17.
 */
public class BruteForceMaximumPathSum implements MaximumPathSum {

    @Override
    public long getMaximumPathSum(long[][] numberTriangle) {
        return getMaximumPathSum(numberTriangle, 0, 0);
    }

    private long getMaximumPathSum(long[][] numberTriangle, int row, int column) {
        if (row == numberTriangle.length-1)
            return numberTriangle[row][column];
        return numberTriangle[row][column] +
                Math.max(getMaximumPathSum(numberTriangle, row + 1, column),
                        getMaximumPathSum(numberTriangle, row + 1, column + 1));
    }


}
