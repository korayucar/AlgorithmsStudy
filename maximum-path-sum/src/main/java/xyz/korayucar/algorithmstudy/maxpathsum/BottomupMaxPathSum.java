package xyz.korayucar.algorithmstudy.maxpathsum;

/**
 * Created by koray on 23/04/17.
 */
public class BottomupMaxPathSum implements MaximumPathSum {
    @Override
    public long getMaximumPathSum(long[][] numberTriangle) {
        MaximumPathSumValidators.validateMaximumPathSumTriangle(numberTriangle);
        int length = numberTriangle.length;
        for (int i = length - 2; i >= 0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                numberTriangle[i][j] += Math.max(numberTriangle[i+1][j], numberTriangle[i+1][j+1]);
            }
        }
        return numberTriangle[0][0];
    }
}
