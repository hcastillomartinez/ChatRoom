package sample;

public class Tuple {
    private Object[] pattern;
    private int size;
    public Tuple(Object... objects){
        pattern =objects;
        size=objects.length;
    }

    public int getSize(){
        return size;
    }

    public String stringTuple(){
        String tupleString="";
        for(int i=0;i<size;i++){
            tupleString+=pattern[i]+" ";
        }
        tupleString+="\n";
        return tupleString;
    }

    public boolean isEqual(Tuple t){
        Object[] temp=t.getPattern();
        if(t.getSize()!=size)return false;
        else {
            for(int i=0;i<size;i++){
                if(pattern[i].equals(temp[i])==false && temp[i]!="*"){
                    return false;
                }
            }
        }
        return true;
    }
    public Object getFirst(){
        return pattern[0];
    }
    public Object[] getPattern(){
        return pattern;
    }

}
