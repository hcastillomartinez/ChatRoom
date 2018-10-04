package sample;

import java.util.*;

/**
 * HashMap implementation, the key is the size of the tuples pattern and the value is a list pertaining to
 * tuples of key's size.
 */
public class HashMapTupleSpace extends TupleSpace{

    private HashMap<Integer,List<Tuple>>map=new HashMap<>();

//    /**
//     * Adds tuple to Tuple space first checking if List of the tuples size already
//     * exists. If it doesn't then key is size of Tuple(number of objects in pattern) and value
//     * is a List is then added to HashMap. If it already exists then simply added to
//     * List.
//     * @param tuple The Tuple to be added to the tuple space
//     */
    public void add(Tuple tuple) {
        //list of tuple size doesn't exist yet
        if (map.containsKey(tuple.getSize()) == false) {
            List<Tuple> list = new ArrayList<>();
            map.put(tuple.getSize(), list);
            map.get(tuple.getSize()).add(tuple);
        }
        else {
            //if tuple doesn't exist in list then add it
            if (map.get(tuple.getSize()).contains(tuple) == false) {
                map.get(tuple.getSize()).add(tuple);
            }
        }
    }

//    /**
//     * Removes a Tuple that matches the pattern passed in as argument from TupleSpace.
//     * @param pattern Tuple's objects
//     * @return Returns Tuple that was removed from TupleSpace, if not found returns null.
//     */
    public Tuple remove(Object... pattern){
        Tuple p=new Tuple(pattern);
        if(map.containsKey(p.getSize())==true){
            List<Tuple> list=map.get(p.getSize());
            Collections.shuffle(list);
            for(Iterator<Tuple> iterator=list.iterator();iterator.hasNext();){
                Tuple temp=iterator.next();
                if(temp.isEqual(p)==true){
                    iterator.remove();
                    return temp;
                }
            }
        }
        p=null;
        return p;
    }

//    /**
//     *Checks if pattern exists in a Tuple in the TupleSpace
//     * @param pattern Tuple's objects
//     * @return Returns A Tuple that matches pattern with pattern in parameter, else returns null.
//     */
    public  Tuple read(Object... pattern){
        Tuple p=new Tuple(pattern);
        if(map.containsKey(p.getSize())==true){
            List<Tuple> list=map.get(p.getSize());
            Collections.shuffle(list);
            for(Iterator<Tuple> iterator=list.iterator();iterator.hasNext();){
                Tuple temp=iterator.next();
                if(temp.isEqual(p)==true){
                    return temp;
                }
            }
        }
        p=null;
        return p;
    }
}