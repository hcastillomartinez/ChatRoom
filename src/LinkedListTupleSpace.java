package sample;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTupleSpace extends TupleSpace {
    List<Tuple> tupleList=new LinkedList<>();

    public void add(Tuple tuple){
        tupleList.add(tuple);
    }

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
        System.out.println("not found");
        t=null;
        return t;
    }


    public Tuple read(Object... objects){
        Tuple t=new Tuple(objects);
        Collections.shuffle(tupleList);
        for(Iterator<Tuple> iterator=tupleList.iterator();iterator.hasNext();){
            Tuple temp=iterator.next();
            if(temp.isEqual(t)==true){
                return temp;
            }
        }
        System.out.println("not found");
        t=null;
        return t;
    }
}
