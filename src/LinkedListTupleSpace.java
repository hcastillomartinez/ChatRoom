package sample;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList implementation, all tuples regardless of size or pattern are placed in one
 * list. Should be the slowest implementation as it would just be a big pile.
 */
public class LinkedListTupleSpace extends TupleSpace {
    private List<Tuple> tupleList=new LinkedList<>();

//    /**
//     * Checks if tuple exists in list yet, if not adds it.
//     * @param tuple Tuple
//     */
    public void add(Tuple tuple){
        if(!tupleList.contains(tuple))tupleList.add(tuple);
    }

//    /**
//     * Creates local tuple with ellipse passed as pattern. Then searches for that tuple in the list, returns it if found
//     * otherwise returns null.
//     * @param objects Ellipse of Objects
//     * @return Tuple that matches one searched for.
//     */
    public Tuple remove(Object... objects){
        Tuple t=new Tuple(objects);
        Collections.shuffle(tupleList);
        for(Iterator<Tuple> iterator=tupleList.iterator();iterator.hasNext();){
            Tuple temp=iterator.next();
            if(temp.isEqual(t)==true){
                iterator.remove();
                return t;
            }
        }
        t=null;
        return t;
    }

//    /**
//     * Creates local Tuple with ellipse passed as pattern and searches for this tuple in the list.
//     * If found returns matching tuple, otherwise returns null.
//     * @param objects Ellipse of Objects
//     * @return Returns Tuple if found, otherwise returns null.
//     */
    public Tuple read(Object... objects){
        Tuple t=new Tuple(objects);
        Collections.shuffle(tupleList);
        for(Iterator<Tuple> iterator=tupleList.iterator();iterator.hasNext();){
            Tuple temp=iterator.next();
            if(temp.isEqual(t)==true){
                return temp;
            }
        }
        t=null;
        return t;
    }
}
