package xyz.korayucar.algorithmstudy.maxpathsum;

/**
 * @author koray
 * @version 4/18/17 9:13 AM.
 */
public class MaximumPathSumValidators {

    public static void validateMaximumPathSumTriangle(long[][] triangle )
    {
        if(triangle == null)
            throw new NullPointerException("Input triangle cannot be null");
        for (int i = 0; i < triangle.length; i++) {
            if(triangle[i] == null)
                throw new NullPointerException("Input triangle cannot contain null rows");
            if(triangle[i].length != i+1)
                throw new IllegalArgumentException("The first row must have length 1 and each row after that must be one longer than that");
        }
    }
}
