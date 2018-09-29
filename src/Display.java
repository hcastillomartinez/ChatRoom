package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display {

    private AnchorPane root=new AnchorPane();
    private  MenuBar menuBar=new MenuBar();
    private Menu menu=new Menu("Menu");
    private MenuItem addUser=new MenuItem("Add User");
    private Button activeButton=new Button("ACTIVE");
    private Button setOnlineButton =new Button("Set Online");
    private Button sendButton= new Button("SEND");
    private TextField textField= new TextField();
    private ScrollPane messageHolder= new ScrollPane();
    private ListView<String> userList=new ListView<>();
    private Pane userHolder=new Pane();
    private Text currentUserName=new Text("No User");
    public Button getActiveButton(){
        return activeButton;
    }
    public Text getCurrentUserName(){
        return currentUserName;
    }
    public Button getSendButton(){
        return sendButton;
    }
    public TextField getTextField(){
        return textField;
    }
    public ListView<String> getUserList(){
        return userList;
    }
    public void setMessage(Messages mgage){
        Text message=new Text(mgage.getMessages());
        messageHolder.setContent(message);
    }
    public MenuItem getAddUser(){
        return addUser;
    }
    public Button getSetOnlineButton(){
        return setOnlineButton;
    }
    public void createGUI(Stage primaryStage){
        root.setPrefSize(380,500);
        root.setStyle("-fx-background-color: #3333ff");

        menuBar.setPrefSize(380,25);
        menuBar.setLayoutX(0);
        menuBar.setLayoutY(0);
        menu.getItems().add(addUser);
        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);

        activeButton.setLayoutX(24);
        activeButton.setLayoutY(79);
        activeButton.setPrefSize(90,39);
        activeButton.setStyle("-fx-background-color: lightblue;"+"-fx-font-size: 13");
        root.getChildren().add(activeButton);

        setOnlineButton.setLayoutX(266);
        setOnlineButton.setLayoutY(79);
        setOnlineButton.setPrefSize(90,39);
        setOnlineButton.setStyle("-fx-background-color: lightblue;"+"-fx-font-size: 13");
        setOnlineButton.wrapTextProperty().setValue(true);
        root.getChildren().add(setOnlineButton);

        textField.setLayoutX(14);
        textField.setLayoutY(434);
        textField.setPrefSize(252,52);
        textField.setText("Type Message");
        root.getChildren().add(textField);

        sendButton.setLayoutY(434);
        sendButton.setLayoutX(285);
        sendButton.setPrefSize(69,52);
        sendButton.setStyle("-fx-font-size: 18;"+"-fx-background-color: yellow");
        root.getChildren().add(sendButton);

        messageHolder.setLayoutX(11);
        messageHolder.setLayoutY(226);
        messageHolder.setPrefSize(360,200);
        messageHolder.setStyle("-fx-background-color: white");
        messageHolder.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.getChildren().add(messageHolder);

        userList.setLayoutX(11);
        userList.setLayoutY(128);
        userList.setPrefSize(360,88);
        userList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        root.getChildren().add(userList);

        userHolder.setLayoutX(24);
        userHolder.setLayoutY(25);
        userHolder.setPrefSize(336,52);
        userHolder.setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
        currentUserName.setLayoutX(145);
        currentUserName.setLayoutY(30);
        currentUserName.setStyle("-fx-font-size: 16");
        userHolder.getChildren().add(currentUserName);
        root.getChildren().add(userHolder);
//        addUser.setOnAction(e->{
//            System.out.println("adduser");
//            final Stage nestStage=new Stage();
//            nestStage.setResizable(false);
//            Pane pane=new Pane();
//            TextField userNam=new TextField();
//            userNam.setLayoutX(0);
//            userNam.setPrefSize(80,20);
//            Button add=new Button("ADD");
//            add.setLayoutX(100);
//            pane.getChildren().addAll(userNam,add);
//            add.setOnMousePressed(el->{
//                uList.addUser(new User(userNam.getText()));
//                List<User> allUsers=uList.getAllList();
//                userList.getItems().clear();
//                for(int i=0;i<allUsers.size();i++){
//                    userList.getItems().add(allUsers.get(i).getName());
//                }
//            });
//            Scene scene = new Scene(pane);
//            nestStage.setScene(scene);
//            nestStage.show();
//        });
//
//
//
//        Messages messages=new Messages();
//        sendButton.setOnMousePressed(e->{
//            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
//            LocalDateTime now=LocalDateTime.now();
//            String time=dateTimeFormatter.format(now);
//            messages.addMessage(time,new User("alex"),textField.getText());
//            Text message=new Text(messages.getMessages());
//            messageHolder.setContent(message);
//        });
        Scene scene= new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
