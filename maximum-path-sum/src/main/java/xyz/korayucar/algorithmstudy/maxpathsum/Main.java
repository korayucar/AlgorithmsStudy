package xyz.korayucar.algorithmstudy.maxpathsum;

import com.google.common.base.Stopwatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by koray on 16/04/17.
 */
public class Main {

    private static final boolean INTERACTIVE = false;
    public static final List<String> INPUT_FILE_NAMES = Arrays.asList(
            "very_small_input.txt",
            "small_input.txt",
            "big_input.txt"
    );

    public static void main(String[] args) {
        MaximumPathSum maximumPathSum = new BottomupMaxPathSum();
        if (INTERACTIVE) {
            Scanner scanner = new Scanner(System.in);
            List<String> inputLines = new ArrayList<>();
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;
                inputLines.add(line);
            }
            processInputLines(maximumPathSum, inputLines);

        } else {
            INPUT_FILE_NAMES.forEach(fileName -> {
                try {
                    System.out.println("Processing "+fileName);
                    processInputLines(maximumPathSum, Files.lines(Paths.get(fileName)).collect(Collectors.toList()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void processInputLines(MaximumPathSum maximumPathSum, List<String> inputLines) {
        long[][] data = new long[inputLines.size()][];
        for (int i = 0; i < inputLines.size(); i++)
            data[i] = lineToLongArray(inputLines.get(i));
        timeMaximumPathSum(maximumPathSum, data);
    }

    public static long[] lineToLongArray(String s) {
        return Arrays.stream(s.split("\\s")).map(Long::valueOf).mapToLong(l -> l).toArray();
    }

    private static void timeMaximumPathSum(MaximumPathSum maximumPathSum, long[][] data) {
        Stopwatch timer = new Stopwatch().start();
        long sum = maximumPathSum.getMaximumPathSum(data);
        System.out.println("Maximum sum is: " + sum + ". Execution took " + timer.stop());
    }
}
