package xyz.korayucar.algorithmstudy.maxpathsum;

/**
 * Created by koray on 23/04/17.
 */
public class BruteForceMaxPathSum implements MaximumPathSum {


    @Override
    public long getMaximumPathSum(long[][] numberTriangle) {
        MaximumPathSumValidators.validateMaximumPathSumTriangle(numberTriangle);
        return getMaximumPathSum(numberTriangle, 0,0);
    }


    private long getMaximumPathSum(long [][] numberTriangle,  int row , int column){
        if(row == numberTriangle.length -1)
            return numberTriangle[row][column];
        return numberTriangle[row][column] +    Math.max(
                getMaximumPathSum(numberTriangle,row+1,column+1),
                getMaximumPathSum(numberTriangle,row+1,column)
        );
    }


}
