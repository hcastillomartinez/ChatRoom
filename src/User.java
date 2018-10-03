package sample;

/**
 * @author Hector Castillo Martinez
 * When new User is created the tuple Info contains all of user's information in the pattern.
 * The first index is boolean to whether user is online or not. Second index is the users name.
 * Any index after that is the users messages with the last index being the latest message.
 */
public class User {
    private boolean active;
    private boolean action;
    private String lastMessage;
    private String name;

    public User(String name){
        this.name=name;
        this.active=false;
        this.action=false;
    }

//    public void setMessageSent(boolean action){
//        messageSent=action;
//    }
//    public boolean isMessageSent(){
//        return messageSent;
//    }
    public boolean isActionTaken(){
        return action;
    }
    public void setAction(){
        this.action=true;
    }
    /**
     * Gets name of user.
     * @return String that is name of user.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets status of whether user is online or not. This flag exists in the first
     * index of the tuple Info's pattern.
     * @return Returns boolean that indicates if user is online or not.
     */
    public boolean getStatus(){
        return active;
    }
    public void setStatus(boolean action){
        active=action;
    }

    /**
     * Grabs the last message from user
     * @return Returns String that is users last message
     */
    public String lastMessage(){
        return lastMessage;
    }

    public void updateLastMessage(String message){
        lastMessage=message;
    }
}
