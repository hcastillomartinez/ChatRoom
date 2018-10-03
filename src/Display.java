package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author Hector Castillo Martinez
 *
 */
public class Display {

    private AnchorPane root=new AnchorPane();
    private  MenuBar menuBar=new MenuBar();
    private Menu menu=new Menu("Menu");
    private MenuItem addUser=new MenuItem("Add User");
    private Button activeButton=new Button("ACTIVE");
    private Button allButton =new Button("ALL");
    private Button sendButton= new Button("SEND");
    private TextField textField= new TextField();
    private ScrollPane messageHolder= new ScrollPane();
    private ListView<String> userList=new ListView<>();
    private Pane userHolder=new Pane();
    private Text currentUserName=new Text("No User");

    /**
     * Gets the pane where userName is displayed with a Text.
     * @return Returns a Pane.
     */
    public Pane getUserHolder(){
        return userHolder;
    }

    /**
     * Gets the button that will show only active users on the display.
     * @return Returns a Button.
     */
    public Button getActiveButton(){
        return activeButton;
    }

    /**
     * Gets the a text that is used to display users name.
     * @return Returns a Text.
     */
    public Text getCurrentUserName(){
        return currentUserName;
    }

    /**
     * Gets a Button that will send message
     * @return Returns a Button.
     */
    public Button getSendButton(){
        return sendButton;
    }

    /**
     * Gets the textField where messages are typed
     * @return Returns a TextField.
     */
    public TextField getTextField(){
        return textField;
    }

    /**
     * Gets the ListView<String> where the users are displayed.
     * @return Returns a ListView<String>.
     */
    public ListView<String> getUserList(){
        return userList;
    }

    /**
     * Updates the scrollPane used to display messages. Content set with a text that is
     * a string from Messages.
     * @param mgage a Messages object.
     */
    public void setMessage(Messages mgage){
        Text message=new Text(mgage.getMessages());
        messageHolder.setContent(message);
    }

    /**
     * Gets the menuItem that will be used to add user to total users(all).
     * @return Returns a MenuItem.
     */
    public MenuItem getAddUser(){
        return addUser;
    }

    /**
     * Gets the button that will be used to show all users in display.
     * @return Returns a Button.
     */
    public Button getAllButton(){
        return allButton;
    }

    /**
     *
     * @param primaryStage Stage
     */
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

        allButton.setLayoutX(266);
        allButton.setLayoutY(79);
        allButton.setPrefSize(90,39);
        allButton.setStyle("-fx-background-color: lightblue;"+"-fx-font-size: 13");
        allButton.wrapTextProperty().setValue(true);
        root.getChildren().add(allButton);

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

        Scene scene= new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
