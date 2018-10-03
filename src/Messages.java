package sample;
/**
 * @author Hector Castillo Martinez
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
                message += tuple.stringTuple();
            }
        }
        return message;
    }
}
