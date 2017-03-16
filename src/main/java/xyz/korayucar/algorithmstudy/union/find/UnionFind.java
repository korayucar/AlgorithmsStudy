package xyz.korayucar.algorithmstudy.union.find;

/**
 * @author koray
 * @version 3/15/17 2:41 PM.
 */
public interface UnionFind {

    /**
     * this method checks whether
     *
     * @param p the id of the first element
     * @param q the id of the second element
     */
    void addEdge(long p, long q);

    /**
     * @param p the id of the node
     * @return the component id that p node belongs
     */
    long componentOf(long p);

    default boolean isConnected(long p, long q){
        return componentOf(p)==componentOf(q);
    }

    /**
     * @return current number of connected components.
     */
    long count();
}
