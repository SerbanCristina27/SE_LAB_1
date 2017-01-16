package ro.mta.se.proiect.views;

import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;


import ro.mta.se.proiect.factory.ObserverFactory;
import  ro.mta.se.proiect.utils.Constants;
import ro.mta.se.proiect.observables.ObservableBattlefield;
import java.util.Random;


/**
 * Created by Cristina on 1/8/2017.
 */
public class MainView extends Application {


    public static boolean planeOK;

    @Override
    public void start(Stage primaryStage) throws Exception {

        planeOK = false;
        Group root = new Group();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 940, 600);


        VBox screen = createVBoxContainer(940,600);





        VBox statusBar = createVBoxContainer(940,50);
        statusBar.setStyle("-fx-background-color: green;\n" +
                " -fx-font-size: 15px;\n" +
                " -fx-padding: 15;");

        Text statusText = new Text("World of Warplanes");
        statusText.setFont(Font.font("Tahoma", FontWeight.NORMAL,30));
        statusBar.getChildren().addAll(statusText);
        statusBar.setAlignment(Pos.CENTER);


        HBox zone = createHBoxContainer(940,550);


        zone.setStyle("-fx-background-color: #2f4f4f;\n" +
                "    -fx-padding: 15;\n" +
                "    -fx-spacing: 10;");


        GridPane welcomeGrid = new GridPane();
        welcomeGrid.setMinSize(910,300);
        welcomeGrid.setHgap(20);
        welcomeGrid.setVgap(20);

        welcomeGrid.setStyle("-fx-background-color: yellow;");

        Text welcomeText = new Text("Welcome to World of Warplane! Please enter your username below:");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));

        TextField userName = new TextField();
        userName.setMaxWidth(300);
        userName.setMinHeight(30);
        userName.setTranslateX(75);

        Button loginButton = new Button("PLAY");
        loginButton.setMinHeight(40);
        loginButton.setMinWidth(100);
        loginButton.setTranslateX(175);


        welcomeGrid.add(welcomeText,0,0);
        welcomeGrid.add(userName,0,1);
        welcomeGrid.add(loginButton,0,2);
        welcomeGrid.setAlignment(Pos.CENTER);


        zone.getChildren().add(0,welcomeGrid);


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
               // tf.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> tf.setStyle("-fx-control-inner-background: #000000"));
              //  tf.addEventFilter(MouseEvent.MOUSE_EXITED, event -> tf.setStyle("-fx-control-inner-background: #FFFFFF"));
              //  tf.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> battlefield.getChildren().get(3).setStyle("-fx-control-inner-background: #000000"));
               // tf.addEventFilter(DragEvent.DRAG_DROPPED, event -> battlefield.getChildren().get(2).setStyle("-fx-control-inner-background: #000000"));

                tf.setOnDragOver(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {

                        System.out.println("onDragOver");

                        if (event.getGestureSource() != tf &&
                                event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }

                        event.consume();
                    }
                });


                tf.setOnDragEntered(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                     /* the drag-and-drop gesture entered the target */
                        System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                        if (event.getGestureSource() != tf &&
                                event.getDragboard().hasString()) {
                        }

                        event.consume();
                    }
                });

                tf.setOnDragExited(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                     /* mouse moved away, remove the graphical cues */
                        event.consume();
                    }
                });

                tf.setOnDragDropped(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                /* data dropped */
                    /* data dropped */
                        System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        if (db.hasString()) {
                            String confirm = new String(db.getString());
                            if (confirm.equals("OK")) {

                                Integer rowIndex = GridPane.getRowIndex(tf);
                                Integer columnIndex = GridPane.getColumnIndex(tf);

                                Boolean valide = updateUserBattlefield(rowIndex, columnIndex);

                                if (valide) {

                                    tf.setText(db.getString());
                                    tf.setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex + 2).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 2) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 3) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 3) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 3) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex - 2).setStyle("-fx-control-inner-background: #000000");
                                    battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                                    success = true;

                                    event.setDropCompleted(success);
                                    event.consume();
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Error Dialog");
                                    alert.setHeaderText("Look, an Error Dialog");
                                    alert.setContentText("Ooops, there was an error!");

                                    alert.showAndWait();
                                }
                            }
                        }
                    }
                });

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

        grid.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                     /* allow any transfer mode */
                Dragboard db = grid.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString("OK");
                db.setContent(content);


                event.consume();
            }
        });

        battlefieldPage.add(battlefield,0,0);
        battlefieldPage.add(grid,1,0);


        //zone.getChildren().addAll(connectPage,battlefieldPage);

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

    private boolean updateUserBattlefield(Integer rowIndex, Integer columnIndex){

        ObservableBattlefield observableBattlefield = new ObservableBattlefield();
        ObserverFactory factory = new ObserverFactory();
        observableBattlefield.addObserver(factory.getObserver("BATTLEFIELD",observableBattlefield));
        observableBattlefield.setValue(rowIndex,columnIndex);

        return planeOK;
    }

}
