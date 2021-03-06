package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * When Run it launches GUI that is like a chatRoom.
 * User must add users to program and they will have complete control
 * of added user's actions.
 */
public class Coordinator extends Application {
    private Display display=new Display();
    private Messages messages=new Messages();
    private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    private UserList backUserList=new UserList();
    private User currentUser=null;
    private String listDisplayed="all";

    /**
     * Updates users displayed to be only the active
     * users. Clears old list prior to adding the active users.
     */
    public void resetListViewActive(){
        List<User> activeUsers=backUserList.getActiveList();
        display.getUserList().getItems().clear();
        for(int i=0;i<activeUsers.size();i++){
            display.getUserList().getItems().add(activeUsers.get(i).getName());
        }
        listDisplayed="active";
    }

    /**
     * Updates users displayed to show all users. Clears old list prior to
     * adding all users to screen.
     */
    public void resetListViewAll(){
        List<User> allUsers=backUserList.getAllList();
        display.getUserList().getItems().clear();
        for(int i=0;i<allUsers.size();i++){
            display.getUserList().getItems().add(allUsers.get(i).getName());
        }
        listDisplayed="all";
    }

    /**
     * If a user has already been added and selected when the top pane is pressed
     * the user is set online and pane turns green to show interaction. One of user Actions could be
     * to set themselves online or offline so if action already taken, does nothing but remind user to select another
     * person.
     */
    public void updateCurrentUserDisplay(){
        if(currentUser!=null && currentUser.getStatus()==false && currentUser.isActionTaken()==false){
            currentUser.setAction(true);
            currentUser.setStatus(true);
            display.getUserHolder().setStyle("-fx-background-color: lightgreen;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
        }
        else if(currentUser!=null && currentUser.getStatus()==true && currentUser.isActionTaken()==false){
            currentUser.setAction(true);
            currentUser.setStatus(false);
            //resets userList when user set offline when activeList is being currently displayed.
            if(listDisplayed.equals("active"))resetListViewActive();
            display.getUserHolder().setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
        }
        else if(currentUser!=null){
            System.out.println("Select another User.");
        }
    }

    /**
     * Gets the current time and puts in into a string. If user hasn't done its action
     * and is active it will be able to send a message and will be shown on display.
     * Once message is taken user has taken an action and resets textField to be blank.
     * If user is not active or has already taken action nothing happens, except a reminder to select
     * another user.
     */
    public void updateMessages(){
        LocalDateTime now=LocalDateTime.now();
        String time=dateTimeFormatter.format(now);
        if(currentUser!=null) {
            //only lets online users send message
            if(currentUser.getStatus()==true && currentUser.isActionTaken()==false){
                String message=display.getTextField().getText();
                if(message.equals("")==false) {
                    currentUser.setAction(true);
                    messages.addMessage(time, currentUser, message);
                    display.setMessage(messages);
                    display.getTextField().setText("");
                }
            }
            else if(currentUser.isActionTaken()==true){
                System.out.println("Select another User.");
            }
        }
    }

    @Override
    public void start(Stage primaryStage){
        display.createGUI(primaryStage);
        backUserList.addUser(new User("Terry"));
        backUserList.addUser(new User("Bob"));
        resetListViewAll();
        
        //when message button is pressed messages are handled
        display.getSendButton().setOnMousePressed(e->{
            updateMessages();
        });

        display.getActiveButton().setOnMousePressed(q->{
            resetListViewActive();
        });

        display.getUserHolder().setOnMousePressed(r->{
            updateCurrentUserDisplay();
        });
        display.getAllButton().setOnMousePressed(t->{
            resetListViewAll();
        });
        //sets action event for add user menu item
        display.getAddUser().setOnAction(event -> {
            final Stage nestStage=new Stage();
            nestStage.setResizable(false);
            Pane pane=new Pane();
            TextField userNam=new TextField();
            userNam.setLayoutX(0);
            userNam.setPrefSize(80,20);
            Button add=new Button("ADD");
            add.setLayoutX(100);
            pane.getChildren().addAll(userNam,add);
            add.setOnMousePressed(el->{
                if(!userNam.getText().equals("")) {
                    backUserList.addUser(new User(userNam.getText()));
                    userNam.setText("");
                    resetListViewAll();
                }
            });
            Scene scene = new Scene(pane);
            nestStage.setScene(scene);
            nestStage.show();
        });

        //handles selection of users from ListView
        display.getUserList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //for when user is added or list displayed is changed. keeps selected user.
                if(newValue!=null){
                    if(currentUser!=null)currentUser.setAction(false);
                    currentUser=backUserList.getUser(newValue);
                    if(currentUser.getStatus()==true)display.getUserHolder().setStyle("-fx-background-color: lightgreen;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
                    else if(currentUser.getStatus()==false)display.getUserHolder().setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
                }
                //sets userName at top of screen to user last selected
                if(currentUser!=null){
                    display.getCurrentUserName().setText(currentUser.getName());
                }
            }
        });
}

    public static void main(String[] args){
        launch(args);
    }
}
