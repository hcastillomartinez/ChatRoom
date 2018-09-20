package sample;

public class TupleSpaceTesting {
    public static void main(String[]args){
        int i=0;
        TupleSpace map=new HashMapTupleSpace();
        long runTime=System.currentTimeMillis();
        while(i<1000){
            Tuple tuple=new Tuple(i);
            map.add(tuple);
            i++;
        }
        i=0;
        while(i<1000){
            Tuple tuple=new Tuple(i,"this");
            map.add(tuple);
            i++;
        }
        i=0;
        while(i<500){
            Tuple tuple=new Tuple(i);
            map.remove(i);
            i++;
        }
        Tuple tuple=new Tuple(3);
        map.read(3).printTuple();
        map.remove(2,"apple");
        map.remove(3,"*");
        runTime=System.currentTimeMillis()-runTime;
        System.out.println(runTime+" millis");
        System.out.println(((HashMapTupleSpace) map).map.get(1).size());
        System.out.println(((HashMapTupleSpace) map).map.get(2).size());

    }
}
