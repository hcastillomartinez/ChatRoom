package sample;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hector Castillo Martinez
 * Stores Tuples of n size patterns and contains no duplicate
 * Tuples.
 */
public abstract class TupleSpace {
    /**
     * Adds tuple to the tupleSpace if it does not exist already.
     * @param tuple Tuple
     */
    public abstract void add(Tuple tuple);

    /**
     * Removes Tuple with matching pattern and returns it to the caller.
     * @param pattern Ellipse of Objects
     * @return Returns Tuple removed for if found, otherwise returns null.
     */
    public abstract Tuple remove(Object... pattern);

    /**
     * Returns the Tuple with matching pattern.
     * @param pattern Ellipse of Objects
     * @return Returns Tuple searched for if found, otherwise returns null.
     */
    public abstract Tuple read(Object... pattern);
}
