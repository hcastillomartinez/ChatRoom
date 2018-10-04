package sample;

/**
 * @author Hector Castillo Martinez
 * User has 3 member variables whether its active, has it taken an action, and its name.
 * Can access these variables through getters and setters.
 */
public class User {
    private boolean active;
    private boolean action;
    private String name;

    /**
     * Creates user with given name and is set to not active and has not taken
     * an action.
     * @param name
     */
    public User(String name){
        this.name=name;
        this.active=false;
        this.action=false;
    }

    /**
     * Checks if User has taken an action yet.
     * @return Returns a Boolean.
     */
    public boolean isActionTaken(){
        return action;
    }

    /**
     * Sets whether user has taken action or not.
     * @param action boolean
     */
    public void setAction(boolean action){
        this.action=action;
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

    /**
     * Sets whether user is active or not.
     * @param action boolean
     */
    public void setStatus(boolean action){
        active=action;
    }

}
