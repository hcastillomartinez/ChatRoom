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

public class Coordinator extends Application {
    Display display=new Display();
    Messages messages=new Messages();
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    UserList backUserList=new UserList();
    User currentUser=null;
    @Override
    public void start(Stage primaryStage){
        display.createGUI(primaryStage);
        display.getSendButton().setOnMousePressed(e->{
            LocalDateTime now=LocalDateTime.now();
            String time=dateTimeFormatter.format(now);
            if(currentUser!=null) {
                //only lets online users send message
                if(currentUser.getStatus()==true){
                    messages.addMessage(time, currentUser, display.getTextField().getText());
                    display.setMessage(messages);
                }
            }
        });
//        display.getActiveButton().setOnMousePressed(q->{
//            List<User> activeUsers=backUserList.getActiveList();
//            display.getUserList().getItems().clear();
//            for(int i=0;i<activeUsers.size();i++){
//                display.getUserList().getItems().add(activeUsers.get(i).getName());
//            }
//        });

        //sets action event for add user menu item
        display.getAddUser().setOnAction(event -> {
            System.out.println("adduser");
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
                backUserList.addUser(new User(userNam.getText()));
                List<User> allUsers=backUserList.getAllList();
                display.getUserList().getItems().clear();
                for(int i=0;i<allUsers.size();i++){
                    display.getUserList().getItems().add(allUsers.get(i).getName());
                }
            });
            Scene scene = new Scene(pane);
            nestStage.setScene(scene);
            nestStage.show();
        });
        display.getSetOnlineButton().setOnMousePressed(r->{
            if(currentUser!=null){
                currentUser.setStatus(true);
            }
        });
//        currentUser=display.getUserList().get
        display.getUserList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);
                //for when user is added or list displayed is changed. keeps selected user.
                if(newValue!=null)currentUser=backUserList.getUser(newValue);
                if(currentUser!=null)display.getCurrentUserName().setText(currentUser.getName());
                else display.getCurrentUserName().setText("No User");
            }
        });
//        if(currentUser!=null)display.getCurrentUserName().setText(currentUser.getName());
}

    public static void main(String[] args){
        launch(args);
    }
}
