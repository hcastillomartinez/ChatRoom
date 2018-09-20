
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
        for(Iterator<Tuple> iterator=tupleList.iterator();iterator.hasNext();){
            if(iterator.next().getSize()==t.getSize()){
                t=iterator.next();
                iterator.remove();
                return t;
            }
        }
        t=null;
        return t;
    }


    public Tuple read(Object... objects){
        Tuple t=new Tuple(objects);
        for(Iterator<Tuple> iterator=tupleList.iterator();iterator.hasNext();){
//            if(iterator.next().getSize()==t.getSize()){
//                return iterator.next();
//            }
        }
        t=null;
        return t;
    }
}
