package main;

/**
 * @author osmanalper
 * @version 27/03/2017.
 */
public class InefficientSolution {

    public static void main(String[] args) {
        //expected 9
        int[][] inputParams = {{4,4,3}, {2,2,3}, {3,1,4}, {4,4,4}};

        System.out.println(calculateLampPostCount(inputParams));

        //ecpected 8
        inputParams = new int[][]{{4, 5, 7}, {1, 1, 2}, {1, 4, 4}, {2, 1, 2}, {2, 2, 3}, {2, 4, 5}, {4, 1, 2}, {4, 4, 5}};

        System.out.println(calculateLampPostCount(inputParams));
    }

    private static int calculateLampPostCount(int[][] inputParams) {
        int numberOfRows = inputParams[0][0];
        int numberOfCols = inputParams[0][1];
        int numberOfTracks = inputParams[0][2];
        int trackArray[][] = new int[numberOfRows][numberOfCols];

        for(int i=1; i<=numberOfTracks; i++) {
            int row[] = inputParams[i];
            int rowIndexOfTrack = row[0]-1;
            int colStartOfTrack = row[1]-1;
            int colEndOfTrack = row[2]-1;
            for(int j=colStartOfTrack; j<=colEndOfTrack; j++) {
                trackArray[rowIndexOfTrack][j] = 1;
            }
        }

        int lamppostCount = 0;
        for(int i=0; i<trackArray.length; i++) {
            for(int j=0; j<trackArray[i].length; j++) {
                if(trackArray[i][j] == 0) {
                    lamppostCount++;
                }
            }
        }
        return  lamppostCount;
    }
}
