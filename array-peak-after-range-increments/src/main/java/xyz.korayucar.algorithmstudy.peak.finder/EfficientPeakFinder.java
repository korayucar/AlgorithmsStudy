package xyz.korayucar.algorithmstudy.peak.finder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by koray on 03/04/17.
 */
public class EfficientPeakFinder implements PeakFinder {

    static final Comparator<Operation> operationComparator = Comparator.comparing(Operation::getIndex)
            .thenComparing(Operation::getOperationType);

    PriorityQueue<Operation> operations;
    boolean initialized;
    int dataSize;

    @Override
    public void init(int arrayLength) {
        if (initialized)
            throw new IllegalStateException("Already initialized");
        initialized = true;
        dataSize = arrayLength;
        operations = new PriorityQueue<>(operationComparator);
    }

    @Override
    public void increment(int startIndexInc, int endIndexInc, int delta) {
        checkInitialized();
        if (startIndexInc < 0 || startIndexInc >= dataSize || endIndexInc < 0 || endIndexInc > dataSize)
            throw new IndexOutOfBoundsException("Indices are not in range.");
        if (endIndexInc <= startIndexInc)
            throw new IllegalArgumentException("End index must be bigger.");
        operations.add(new Operation(delta, OperationType.INCREMENT, startIndexInc));
        operations.add(new Operation(delta, OperationType.DECREMENT, endIndexInc));
    }

    @Override
    public int getMax() {
        checkInitialized();
        int peak = Integer.MIN_VALUE;
        int current = 0;
        while(!operations.isEmpty()) {
            Operation o = operations.poll();
            current = o.getOperationType().apply(current,o.getDelta());
            peak = Math.max(peak, current);
        }
        return peak;
    }

    private void checkInitialized() {
        if(!initialized)
            throw new IllegalStateException("EfficientPeakFinder not initialized.");
    }

    private enum OperationType {
        //we rely on the order of enum declaration via comparator.
        INCREMENT {
            @Override
            int apply(int o1, int o2) {
                return o1 + o2;
            }
        }, DECREMENT {
            @Override
            int apply(int o1, int o2) {
                return o1 - o2;
            }
        };

        abstract int apply(int o1, int o2);
    }


    private static class Operation {

        int delta;
        OperationType operationType;
        int index;

        public Operation(int delta, OperationType operationType, int index) {
            this.delta = delta;
            this.operationType = operationType;
            this.index = index;
        }

        public int getDelta() {
            return delta;
        }

        public OperationType getOperationType() {
            return operationType;
        }


        public int getIndex() {
            return index;
        }

    }
}
