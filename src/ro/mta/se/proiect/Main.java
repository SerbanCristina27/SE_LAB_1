package ro.mta.se.proiect;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import ro.mta.se.proiect.views.*;


public class Main extends Application {

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
        battlefieldPage.setMinSize(550,300);
        battlefieldPage.setStyle("-fx-background-color: blue");

        zone.getChildren().addAll(connectPage,battlefieldPage);


        screen.getChildren().addAll(statusBar,zone);


        // page.setHgap(10);
        // page.setVgap(10);
        // page.add(zoneTopLeft, 0, 0);
        // page.setColumnSpan(zoneTopLeft, 2);
        // page.add(zoneTopRight, 2, 0);
        // page.setColumnSpan(zoneTopRight,2);
        //  page.add(zoneBottomLeft, 0, 1);
        // page.add(zoneBottomRight, 1, 1);
        // page.setColumnSpan(zoneBottomRight,3);

        //root.getChildren().addAll(page);


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


    public static void main(String[] args) {
        launch(args);
    }}
