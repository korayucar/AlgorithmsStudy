package main;

/**
 * @author osmanalper
 * @version 27/03/2017.
 */
public class InefficientSolution {

    public static void main(String[] args) {

        //expected 200
        int[][] inputParams = {{0,1,100}, {1,4,100}, {2,3,100}};

        System.out.println(findMaxValueAfterInc(5, inputParams));

        //expected 882
        inputParams = new int[][]{{1, 2, 603}, {0, 0, 286}, {3, 3, 882}};

        System.out.println(findMaxValueAfterInc(4, inputParams));
    }

    private static int findMaxValueAfterInc(int arraySize, int[][] inputParams) {
        int array[] = new int[arraySize];
        for(int i=0; i<inputParams.length; i++) {
            int startIndex = inputParams[i][0];
            int endIndex = inputParams[i][1];
            while(startIndex <= endIndex) {
                array[startIndex]+=inputParams[i][2];
                startIndex++;
            }
        }
        int maxValueOfArray = 0;
        for (int i : array) {
            if(maxValueOfArray<i){
                maxValueOfArray=i;
            }
        }
        return maxValueOfArray;
    }
}
