package sample;

/**
 * Has a main class that method used for testing can be called with users
 * choice of # of tuples and the implementation of their choosing.
 */
public class TupleSpaceTesting {
    /**
     * Tuples of size 1, 5, and 6 are added each numOfTuples times. Space is then searched numOfTuples/10 times
     * and also removed from numOfTuples/10 times. Prints out runtime of all the operations at the end of the
     * method.
     * @param numOfTuples Int
     * @param tupleSpace TupleSpace
     */
    public static void spaceTesting(int numOfTuples,TupleSpace tupleSpace){
        int i=0;
        TupleSpace map=tupleSpace;
        long runTime=System.currentTimeMillis();
        while(i<numOfTuples){
            Tuple tuple=new Tuple(i);
            map.add(tuple);
            i++;
        }
        i=0;
        while(i<numOfTuples){
            Tuple tuple=new Tuple(i,"this",false,44.4,"string"+i,'c');
            map.add(tuple);
            i++;
        }
        i=0;
        while(i<numOfTuples){
            Tuple tuple=new Tuple("string",false,true,10.0,i);
            map.add(tuple);
            i++;
        }
        i=0;
        while(i<numOfTuples/10){
            Tuple tuple=new Tuple(i);
            map.remove(i);
            i++;
        }
        i=0;
        while(i<numOfTuples/10){
            Tuple tuple=map.read("*","this",false,44.4,"*",'c');
            i++;
        }
        runTime=System.currentTimeMillis()-runTime;
        System.out.println(runTime+" milliseconds");
    }

    public static void main(String[]args){
//        spaceTesting(30000,new LinkedListTupleSpace());
//        spaceTesting(30000,new HashMapTupleSpace());
    }
}
