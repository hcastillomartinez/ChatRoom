package sample;
/**
 * When Messages is created the time array is of size 10, and the tupleSpace uses the
 * HashMapTupleSpace implementation. Also has a count to use as modulus for when looking for last 10 to print.
 */
public class Messages {
    private String[] times;
    private TupleSpace allMessages;
    private int count;

    /**
     * Creates new Messages with array of size 10 and implementing TupleSpace with the HashMapTupleSpace version.
     */
    public Messages(){
        times=new String[10];
        allMessages=new HashMapTupleSpace();
        count=0;
    }

    /**
     * Adds message to the tupleSpace that all user's messages go to. Also adds timestamp to
     * an array to find latest messages printed when using "read" from tupleSpace.
     * @param time String representing the time message was sent
     * @param user User object
     * @param message String representing message user specifies.
     */
    public void addMessage(String time, User user, String message) {
        Tuple t = new Tuple(time, user, message);
        times[count%10]=time;
        count++;
        allMessages.add(t);
    }

    /**
     * Uses search from tupleSpace to find last 10 messages with the times saved in addMessage method.
     * @return Returns a String that is the last ten messages sent by users.
     */
    public String getMessages() {
        String message="";
        for(String s: times){
            if(s!=null) {
                Tuple tuple = allMessages.read(s, "*", "*");
                message += messageToString(tuple.getPattern());
            }
        }
        return message;
    }
    //converts tuples pattern into a string(the message)
    private String messageToString(Object[] objects){
        String tupleString="";
        for(int i=0;i<objects.length;i++){
            if(objects[i].getClass()==new User("temp").getClass()){
                User temp=(User) objects[i];
                tupleString+=temp.getName()+": ";
            }
            else tupleString+=objects[i]+" ";
        }
        tupleString+="\n";
        return tupleString;
    }
}
