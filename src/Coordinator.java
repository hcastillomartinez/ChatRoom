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
 * @author Hector Castillo Martinez
 * When Run it launches GUI that is like a chatRoom.
 * User must add users to program and they will have complete control
 * of added user's actions.
 */
public class Coordinator extends Application {
    Display display=new Display();
    Messages messages=new Messages();
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    UserList backUserList=new UserList();
    User currentUser=null;
    @Override
    public void start(Stage primaryStage){
        display.createGUI(primaryStage);
        //when message button is pressed messages are handled
        display.getSendButton().setOnMousePressed(e->{
            LocalDateTime now=LocalDateTime.now();
            String time=dateTimeFormatter.format(now);
            if(currentUser!=null) {
                //only lets online users send message
                if(currentUser.getStatus()==true){
                    String message=display.getTextField().getText();
                    if(message.equals("")==false) {
                        messages.addMessage(time, currentUser, message);
                        display.setMessage(messages);
                        display.getTextField().setText("");
                    }
                }
            }
        });

        display.getActiveButton().setOnMousePressed(q->{
            List<User> activeUsers=backUserList.getActiveList();
            display.getUserList().getItems().clear();
            for(int i=0;i<activeUsers.size();i++){
                display.getUserList().getItems().add(activeUsers.get(i).getName());
            }
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
                    List<User> allUsers = backUserList.getAllList();
                    display.getUserList().getItems().clear();
                    for (int i = 0; i < allUsers.size(); i++) {
                        display.getUserList().getItems().add(allUsers.get(i).getName());
                    }
                }
            });
            Scene scene = new Scene(pane);
            nestStage.setScene(scene);
            nestStage.show();
        });
        display.getAllButton().setOnMousePressed(t->{
            List<User> allUsers=backUserList.getAllList();
            display.getUserList().getItems().clear();
            for(int i=0;i<allUsers.size();i++){
                display.getUserList().getItems().add(allUsers.get(i).getName());
            }
        });
        //when user is set online the pane holding userName shows green if online and blue if offline
        display.getUserHolder().setOnMousePressed(r->{
            if(currentUser!=null && currentUser.getStatus()==false){
                currentUser.setStatus(true);
                display.getUserHolder().setStyle("-fx-background-color: lightgreen;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
            }
            else if(currentUser!=null && currentUser.getStatus()==true){
                currentUser.setStatus(false);
                display.getUserHolder().setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
            }
        });
        //handles selection of users from ListView
        display.getUserList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //for when user is added or list displayed is changed. keeps selected user.
                if(newValue!=null){
                    currentUser=backUserList.getUser(newValue);
                    if(currentUser.getStatus()==true)display.getUserHolder().setStyle("-fx-background-color: lightgreen;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
                    else if(currentUser.getStatus()==false)display.getUserHolder().setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
                }
                //sets userName at top of screen to user last selected
                if(currentUser!=null){
                    display.getCurrentUserName().setText(currentUser.getName());
                }
                else display.getCurrentUserName().setText("No User");
            }
        });
}

    public static void main(String[] args){
        launch(args);
    }
}
