package ro.mta.se.proiect.views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;


import ro.mta.se.proiect.factory.ObserverFactory;
import ro.mta.se.proiect.observables.ObservableBattlefield;
import ro.mta.se.proiect.utils.Constants;

import java.util.Random;


/**
 * Created by Cristina on 1/8/2017.
 */
public class MainView{

    public static boolean planeOK;
    public Button loginButton;
    TextField userName;
    HBox zone;
    GridPane connectPage;
    GridPane battlefieldPage;
    GridPane welcomeGrid;
    public Scene preloaderScene;
    Group root;
    ObservableBattlefield observableBattlefield;
    ObserverFactory factory;
    public GridPane battlefield;
    ImageView arrowView;
    ImageView imageView;

    public TextField getUserName() {
        return userName;
    }

    public ImageView getArrowView() {
        return arrowView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public GridPane getBattlefield() {
        return battlefield;
    }

    public MainView(){

        planeOK = false;
        root = new Group();


        VBox screen = createVBoxContainer(940,600);


        VBox statusBar = createVBoxContainer(940,50);
        statusBar.setStyle("-fx-background-color: green;\n" +
                " -fx-font-size: 15px;\n" +
                " -fx-padding: 15;");

        Text statusText = new Text("World of Warplanes");
        statusText.setFont(Font.font("Tahoma", FontWeight.NORMAL,30));
        statusBar.getChildren().addAll(statusText);
        statusBar.setAlignment(Pos.CENTER);


        zone = createHBoxContainer(940,550);


        zone.setStyle("-fx-background-color: #2f4f4f;\n" +
                "    -fx-padding: 15;\n" +
                "    -fx-spacing: 10;");


        welcomeGrid = new GridPane();
        welcomeGrid.setMinSize(910,300);
        welcomeGrid.setHgap(20);
        welcomeGrid.setVgap(20);

        welcomeGrid.setStyle("-fx-background-color: yellow;");

        Text welcomeText = new Text("Welcome to World of Warplane! Please enter your username below:");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));

        userName = new TextField();
        userName.setMaxWidth(300);
        userName.setMinHeight(30);
        userName.setTranslateX(75);

        loginButton = new Button("PLAY");
        loginButton.setMinHeight(40);
        loginButton.setMinWidth(100);
        loginButton.setTranslateX(175);


        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                zone.getChildren().removeAll(welcomeGrid);
                zone.getChildren().addAll(connectPage, battlefieldPage);
            }
        });

        welcomeGrid.add(welcomeText,0,0);
        welcomeGrid.add(userName,0,1);
        welcomeGrid.add(loginButton,0,2);
        welcomeGrid.setAlignment(Pos.CENTER);


        zone.getChildren().add(0,welcomeGrid);


        connectPage = new GridPane();
        battlefieldPage = new GridPane();


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


        Label userPort = new Label("User port:");
        connectPage.add(userPort,0,4);

        final ComboBox portComboBox = new ComboBox();
        portComboBox.getItems().addAll(
                "13131",
                "13132",
                "13133",
                "13134",
                "13135"
        );


        portComboBox.setValue("13131");


        connectPage.add(portComboBox,1,4);

        Button connectBtn = new Button("Connect");
        connectBtn.setMinWidth(200);
        HBox hbBtn = new HBox(10);


        connectBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        hbBtn.getChildren().add(connectBtn);
        connectPage.add(hbBtn,1,8,1,1);


        Label invitation = new Label("A friend invite you to battle!!");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(4.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        invitation.setEffect(ds);
        invitation.setCache(true);
        invitation.setTextFill(Color.BLUE);
        invitation.setFont(Font.font(null, FontWeight.BOLD, 16));

        connectPage.add(invitation,1,11);

        Button acceptInvitaton = new Button("Accept the invitation");
        acceptInvitaton.setMinWidth(200);

        HBox hbInvitation = new HBox(10);

        acceptInvitaton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        hbInvitation.getChildren().add(acceptInvitaton);
        connectPage.add(hbInvitation,1,13);

        battlefieldPage.setGridLinesVisible(true);
        battlefieldPage.setVgap(20);
        battlefieldPage.setHgap(20);
        battlefieldPage.setMinSize(550,300);
        battlefieldPage.setStyle("-fx-background-color: blue");

        int SIZE = 15;
        int length = SIZE;
        int width = SIZE;

        battlefield = new GridPane();
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


                // Iterate the Index using the loops
                battlefield.setRowIndex(tf,y);
                battlefield.setColumnIndex(tf,x);
                battlefield.getChildren().add(tf);

            }
        }


        Image image = new Image("/ro/mta/se/proiect/Images/plane.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        GridPane grid  = new GridPane();
        grid.setVgap(20);
        grid.setMinSize(100,100);

        grid.add(imageView,0,0);

        Image arrow = new Image("/ro/mta/se/proiect/Images/arrow.png");
        arrowView = new ImageView(arrow);
        arrowView.setFitHeight(20);
        arrowView.setFitWidth(20);
        arrowView.setRotate(arrowView.getRotate() + 270);
        arrowView.setTranslateX(40);



        grid .add(arrowView,0,1);

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


        screen.getChildren().addAll(statusBar,zone);

        root.getChildren().addAll(screen);

        observableBattlefield = new ObservableBattlefield();
        factory = new ObserverFactory();
        observableBattlefield.addObserver(factory.getObserver("BATTLEFIELD",observableBattlefield));

        preloaderScene = new Scene(root, 940, 600);

    }

    public void show(Stage stage){
        stage.setTitle("asda");
        stage.setScene(preloaderScene);
        stage.show();
    }




    private HBox createHBoxContainer(double width, double height) {
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

    public void updateUserBattlefield(Integer rowIndex, Integer columnIndex, Constants.PlanePosition position) {


        if (position.equals(Constants.PlanePosition.up)) {

            observableBattlefield.setValue(rowIndex, columnIndex);
            if(planeOK) {

                battlefield.getChildren().get((rowIndex * 15) + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex + 2).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 2) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 3) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 3) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 3) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex - 2).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }


        } else if (position.equals(Constants.PlanePosition.right)){

            observableBattlefield.setValue(rowIndex, columnIndex);
            if(planeOK) {

                battlefield.getChildren().get((rowIndex * 15) + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex) * 15 + columnIndex - 2).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex) * 15 + columnIndex - 3).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 2) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 2) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex - 3).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex - 3).setStyle("-fx-control-inner-background: #000000");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }

        }
        else if (position.equals(Constants.PlanePosition.down)){
            observableBattlefield.setValue(rowIndex, columnIndex);
            if(planeOK) {

                battlefield.getChildren().get((rowIndex * 15) + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 2) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 3) * 15 + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex + 2).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex - 2).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 3) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 3) * 15 + columnIndex - 1).setStyle("-fx-control-inner-background: #000000");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }
        }
        else if (position.equals(Constants.PlanePosition.left)){

            observableBattlefield.setValue(rowIndex, columnIndex);
            if(planeOK) {

                battlefield.getChildren().get((rowIndex * 15) + columnIndex).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex) * 15 + columnIndex + 2).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex) * 15 + columnIndex + 3).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex + 3).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex + 3).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 1) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex + 2) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 1) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
                battlefield.getChildren().get((rowIndex - 2) * 15 + columnIndex + 1).setStyle("-fx-control-inner-background: #000000");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

    }


    public void switchint() {
        zone.getChildren().removeAll(welcomeGrid);
        zone.getChildren().addAll(connectPage, battlefieldPage);
    }


}
