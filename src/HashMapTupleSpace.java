
import java.util.HashMap;

public class HashMapTupleSpace extends TupleSpace{

    HashMap<Tuple,Integer>map=new HashMap<>();


    public void add(Tuple tuple){
        map.put(tuple,tuple.getSize());
    }
    public Tuple remove(Object... pattern){
        Tuple p=new Tuple();
        return p;
    }
    public  Tuple read(Object... pattern){
        Tuple p=new Tuple();
        return p;
    }
}