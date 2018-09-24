package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application {

    @Override
    public void start(Stage primaryStage){
        AnchorPane root=new AnchorPane();
        root.setPrefSize(380,467);
        root.setStyle("-fx-background-color: #3333ff");

        Label status= new Label();
        status.setLayoutX(30);
        status.setLayoutY(63);
        status.setPrefSize(81,42);
        status.setStyle("-fx-background-color: lightBlue; -fx-background-radius: 10;"+"-fx-font-size: 16");
        status.setText("Active");
        status.setPadding(new Insets(0,0,0,15));

        Label userView=new Label();
        userView.setLayoutX(278);
        userView.setLayoutY(63);
        userView.setPrefSize(81,42);
        userView.setStyle("-fx-background-color: lightBlue; -fx-background-radius: 10;"+"-fx-font-size: 16");
        userView.setText("All");
        userView.setPadding(new Insets(0,0,0,30));
        root.getChildren().add(userView);
        root.getChildren().add(status);

        TextField textField= new TextField();
        textField.setLayoutX(14);
        textField.setLayoutY(401);
        textField.setPrefSize(252,52);
        textField.setText("Type Message");
        root.getChildren().add(textField);

        Button sendButton= new Button("SEND");
        sendButton.setLayoutY(401);
        sendButton.setLayoutX(284);
        sendButton.setPrefSize(69,52);
        sendButton.setStyle("-fx-font-size: 18;"+"-fx-background-color: yellow");
        root.getChildren().add(sendButton);

        VBox messageHolder= new VBox();
        messageHolder.setLayoutX(10);
        messageHolder.setLayoutY(206);
        messageHolder.setPrefSize(360,188);
        messageHolder.setStyle("-fx-background-color: white;"+"-fx-background-radius: 10");
        root.getChildren().add(messageHolder);

        ScrollPane userList=new ScrollPane();
        userList.setLayoutX(10);
        userList.setLayoutY(112);
        userList.setPrefSize(360,88);
        userList.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.getChildren().add(userList);

        Pane userHolder=new Pane();
        userHolder.setLayoutX(90);
        userHolder.setLayoutY(14);
        userHolder.setPrefSize(210,42);
        userHolder.setStyle("-fx-background-color: lightblue;"+"-fx-border-radius: 10;"+"-fx-background-radius: 10");
        Text userName=new Text("name");
        userName.setLayoutX(90);
        userName.setLayoutY(27);
        userName.setStyle("-fx-font-size: 16");
        userHolder.getChildren().add(userName);
        root.getChildren().add(userHolder);

        TupleSpace users=new HashMapTupleSpace();





        Scene scene= new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
