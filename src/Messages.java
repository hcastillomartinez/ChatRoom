package sample;

public class Messages {
    private String[] times;
    private TupleSpace allMessages;
    private int count;
    public Messages(){
        times=new String[10];
        allMessages=new HashMapTupleSpace();
        count=0;
    }

    public void addMessage(String time, User user, String message) {
        Tuple t = new Tuple(time, user, message);
        times[count%10]=time;
        count++;
        allMessages.add(t);
    }

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
