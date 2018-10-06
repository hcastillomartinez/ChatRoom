package sample;

/**
 *Tuples are immutable when created. Can contain any size ellipse of Objects.
 */
public class Tuple {
    private Object[] pattern;
    private int size;

    /**
     * Creates tuple with pattern passed into arguments and size is length of this pattern.
     * @param objects
     */
    public Tuple(Object... objects){
        pattern =objects;
        size=objects.length;
    }

    /**
     * Gets the length of the Tuple's pattern.
     * @return Returns an Int
     */
    public int getSize(){
        return size;
    }


    /**
     * Checks tuple and another tuple to see if they are equal based on their
     * patterns. Account for wildcards, "*", and continues checking through pattern if found in any
     * part in pattern, unless the end of pattern.
     * @param t A Tuple
     * @return Returns true if tuples are equal to one another, otherwise returns false.
     */
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

    /**
     * Gets the first object in Tuple's pattern.
     * @return Returns an Object.
     */
    public Object getFirst(){
        return pattern[0];
    }

    /**
     * Gets the Tuple's pattern.
     * @return Returns an Object[].
     */
    public Object[] getPattern(){
        return pattern;
    }

}
