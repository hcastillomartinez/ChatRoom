package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Hector Castillo Martinez
 *
 */
public class UserList {
    private List<User> users;

    public UserList(){
        users=new ArrayList<>();
    }

    /**
     * Adds a user to the list that contains all users.
     * @param user User object to be added to list.
     */
    public void addUser(User user){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(user.getName()))return;
        }
        users.add(user);
    }

    /**
     * Used to find a specific in the list of all users.
     * @param userName String of user to be searched for
     * @return Returns a User that matched with searched username.
     */
    public User getUser(String userName){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(userName))return users.get(i);
        }
        return null;
    }

    /**
     * Gets the list that contains all users.
     * @return Returns a list of all users.
     */
    public List getAllList(){
        return users;
    }

    /**
     * Gets a user list of only the active users.
     * @return Returns a list of users.
     */
    public List<User> getActiveList(){
        List<User> active=new ArrayList<>();
        for(Iterator<User> iterator=users.iterator();iterator.hasNext();){
            User user=iterator.next();
            if(user.getStatus()==true){
                active.add(user);
            }
        }
        return active;
    }

}
