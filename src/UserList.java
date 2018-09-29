package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserList {
    private List<User> users;

    public UserList(){
        users=new ArrayList<>();
    }

    public void addUser(User user){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(user.getName()))return;
        }
        users.add(user);
    }
    public User getUser(String userName){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(userName))return users.get(i);
        }
        return null;
    }
    public List getAllList(){
        return users;
    }

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
