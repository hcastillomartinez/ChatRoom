package sample;

import java.util.Stack;

public class Messages {
    Stack<String> messages=new Stack<>();
//    String message;
//    public Messages(String message){
//        this.message=message;
//    }
    public void addMessage(String message){
        messages.push(message);
    }

    public String getMessages(){
        String message="";
        int start=messages.size();
        int diff=start-10;
        if(diff<=0) {
            System.out.println("caca");
            for (int i = 0; i < messages.size(); i++) {
                if(i!=messages.size()-1){
                    message+=messages.get(i)+"\n";
                }
                else{
                    message+=messages.get(i);
                }
            }
        }
        else{
            System.out.println("here");
            for(int i=diff;i<messages.size();i++){
                if(i!=messages.size()-1){
                    message+=messages.get(i)+"\n";
                }
                else{
                    message+=messages.get(i);
                }
            }
        }
        return message;
    }
}
