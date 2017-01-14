package ro.mta.se.proiect.views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import java.util.Random;

/**
 * Created by Cristina on 1/8/2017.
 */
public class MainView extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 940, 600);


        VBox screen = createVBoxContainer(940,600);



        VBox statusBar = createVBoxContainer(940,50);
        statusBar.setStyle("-fx-background-color: green;\n" +
                " -fx-font-size: 15px;\n" +
                " -fx-padding: 15;");

        Text statusText = new Text("Welcome! Invite a friend and play!");
        statusText.setFont(Font.font("Tahoma", FontWeight.NORMAL,30));
        statusBar.getChildren().addAll(statusText);
        statusBar.setAlignment(Pos.CENTER);


        HBox zone = createHBoxContainer(940,550);


        zone.setStyle("-fx-background-color: #2f4f4f;\n" +
                "    -fx-padding: 15;\n" +
                "    -fx-spacing: 10;");


        GridPane connectPage = new GridPane();
        GridPane battlefieldPage = new GridPane();


        connectPage.setMinSize(350,300);
        connectPage.setStyle("-fx-background-color: red;\n" +
                " -fx-font-size: 15px;");


        //connectPage.setGridLinesVisible(true);
        connectPage.setHgap(10);
        connectPage.setVgap(10);
        connectPage.setPadding(new Insets(10,10,10,10));

        Text connectText = new Text("Welcome");
        connectText.setFont(Font.font("Tahoma", FontWeight.NORMAL,40));
        connectText.setTextAlignment(TextAlignment.RIGHT);
        connectPage.add(connectText,0,0,2,1);

        Label userIp = new Label("User IP:");
        connectPage.add(userIp,0,2);

        TextField textIp = new TextField();
        connectPage.add(textIp,1,2);

        Button connectBtn = new Button("Connect");
        HBox hbBtn = new HBox(10);

        hbBtn.getChildren().add(connectBtn);
        connectPage.add(hbBtn,1,4,1,1);



        battlefieldPage.setGridLinesVisible(true);
        battlefieldPage.setVgap(20);
        battlefieldPage.setHgap(20);
        battlefieldPage.setMinSize(550,300);
        battlefieldPage.setStyle("-fx-background-color: blue");

        int SIZE = 15;
        int length = SIZE;
        int width = SIZE;
        Paint value0 = Paint.valueOf("FFFFFF");

        GridPane battlefield = new GridPane();
        battlefield.setPadding(new Insets(10, 10, 10, 10));

        for(int y = 0; y < length; y++){
            for(int x = 0; x < width; x++){

                Random rand = new Random();
                int rand1 = rand.nextInt(2);

                // Create a new TextField in each Iteration
                TextField tf = new TextField();
                tf.setPrefHeight(20);
                tf.setPrefWidth(20);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(false);
                tf.setText("(" + rand1 + ")");

                tf.setOnMouseClicked( e -> {

                    System.out.println("Clicked");
                    tf.setStyle("-fx-control-inner-background: #000000");

                });

                // Iterate the Index using the loops
                battlefield.setRowIndex(tf,y);
                battlefield.setColumnIndex(tf,x);
                battlefield.getChildren().add(tf);

                tf.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> System.out.println( "Node: " + tf.getText() + " at " + GridPane.getRowIndex(tf) + "/" + GridPane.getColumnIndex(tf)));
                tf.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> tf.setStyle("-fx-control-inner-background: #000000"));
                tf.addEventFilter(MouseEvent.MOUSE_EXITED, event -> tf.setStyle("-fx-control-inner-background: #FFFFFF"));
                tf.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> battlefield.getChildren().get(3).setStyle("-fx-control-inner-background: #000000"));
                tf.addEventFilter(DragEvent.DRAG_DROPPED, event -> battlefield.getChildren().get(2).setStyle("-fx-control-inner-background: #000000"));


            }
        }



        Image image = new Image("/ro/mta/se/proiect/Images/plane.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        GridPane grid  = new GridPane();
        grid.setMinSize(100,100);

        grid.add(imageView,0,0);
        grid.setPadding(new Insets(10, 10, 10, 10));

        battlefieldPage.add(battlefield,0,0);
        battlefieldPage.add(grid,1,0);


        zone.getChildren().addAll(connectPage,battlefieldPage);

        screen.getChildren().addAll(statusBar,zone);


        root.getChildren().addAll(screen);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private HBox createHBoxContainer(double width,double height) {
        HBox base = new HBox(); // box
        base.setPrefWidth(width);
        base.setPrefHeight(height);
        base.setStyle("-fx-border-width: 1;-fx-border-color: red");

        return base;
    }

    private VBox createVBoxContainer(double width, double height){

        VBox base = new VBox(); // box
        base.setPrefWidth(width);
        base.setPrefHeight(height);
        base.setStyle("-fx-border-width: 1;-fx-border-color: red");

        return base;
    }


    private Node setBaseButtons() {
        return new HBox();
    }

    private Node setBaseTitle() {

        return new Label();
    }

}
