package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Display extends Application {

    @Override
    public void start(Stage primaryStage){
        AnchorPane root=new AnchorPane();
        root.setPrefSize(380,500);
        root.setStyle("-fx-background-color: #3333ff");

        MenuBar menuBar=new MenuBar();
        menuBar.setPrefSize(380,25);
        menuBar.setLayoutX(0);
        menuBar.setLayoutY(0);
        Menu menu=new Menu("Menu");
        MenuItem addUser=new MenuItem("Add User");
        menu.getItems().add(addUser);
        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);
        UserList uList=new UserList();

        Button activeButton=new Button("ACTIVE");
        activeButton.setLayoutX(24);
        activeButton.setLayoutY(79);
        activeButton.setPrefSize(90,39);
        activeButton.setStyle("-fx-background-color: lightblue;"+"-fx-font-size: 17");
        root.getChildren().add(activeButton);

        Button allButton=new Button("ALL");
        allButton.setLayoutX(266);
        allButton.setLayoutY(79);
        allButton.setPrefSize(90,39);
        allButton.setStyle("-fx-background-color: lightblue;"+"-fx-font-size: 17");
        root.getChildren().add(allButton);

        TextField textField= new TextField();
        textField.setLayoutX(14);
        textField.setLayoutY(434);
        textField.setPrefSize(252,52);
        textField.setText("Type Message");
        root.getChildren().add(textField);

        Button sendButton= new Button("SEND");
        sendButton.setLayoutY(434);
        sendButton.setLayoutX(285);
        sendButton.setPrefSize(69,52);
        sendButton.setStyle("-fx-font-size: 18;"+"-fx-background-color: yellow");
        root.getChildren().add(sendButton);

        ScrollPane messageHolder= new ScrollPane();
        messageHolder.setLayoutX(11);
        messageHolder.setLayoutY(226);
        messageHolder.setPrefSize(360,200);
        messageHolder.setStyle("-fx-background-color: white");
        messageHolder.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.getChildren().add(messageHolder);

        ListView<String> userList=new ListView<>();
        userList.setLayoutX(11);
        userList.setLayoutY(128);
        userList.setPrefSize(360,88);
        userList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        root.getChildren().add(userList);

        Pane userHolder=new Pane();
        userHolder.setLayoutX(24);
        userHolder.setLayoutY(25);
        userHolder.setPrefSize(336,52);
        userHolder.setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
        Text userName=new Text("name");
        userName.setLayoutX(145);
        userName.setLayoutY(30);
        userName.setStyle("-fx-font-size: 16");
        userHolder.getChildren().add(userName);
        root.getChildren().add(userHolder);
        addUser.setOnAction(e->{
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
                uList.addUser(new User(userNam.getText()));
                List<User> allUsers=uList.getAllList();
                userList.getItems().clear();
                for(int i=0;i<allUsers.size();i++){
                    userList.getItems().add(allUsers.get(i).getName());
                }
            });
            Scene scene = new Scene(pane);
            nestStage.setScene(scene);
            nestStage.show();
        });



        Messages messages=new Messages();
        sendButton.setOnMousePressed(e->{
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now=LocalDateTime.now();
            String time=dateTimeFormatter.format(now);
            messages.addMessage(time,new User("alex"),textField.getText());
            Text message=new Text(messages.getMessages());
            messageHolder.setContent(message);
        });

        ObservableList selectedUser=userList.getSelectionModel().getSelectedIndices();
        for(Object s: selectedUser){
            userName.setText((String)s);
        }

        Scene scene= new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
