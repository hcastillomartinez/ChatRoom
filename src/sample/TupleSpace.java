package sample;
import java.util.HashMap;
import java.util.Map;

public abstract class TupleSpace {
    public abstract void add(Tuple tuple);
    public abstract Tuple remove(Object... pattern);
    public abstract Tuple read(Object... pattern);
}
