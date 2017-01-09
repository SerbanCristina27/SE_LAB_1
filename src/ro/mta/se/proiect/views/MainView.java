package ro.mta.se.proiect.views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

/**
 * Created by Cristina on 1/8/2017.
 */
public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");


        GridPane connectGrid = new GridPane();
        connectGrid.setGridLinesVisible(true);
        connectGrid.setHgap(10);
        connectGrid.setVgap(10);
        connectGrid.setPadding(new Insets(10,10,10,10));

        Text connectText = new Text("Welcome");
        connectText.setFont(Font.font("Tahoma", FontWeight.NORMAL,30));
        connectText.setTextAlignment(TextAlignment.RIGHT);
        connectGrid.add(connectText,0,0,2,1);

        Label userIp = new Label("User IP:");
        connectGrid.add(userIp,0,1);

        TextField textIp = new TextField();
        connectGrid.add(textIp,1,1);

        Button connectBtn = new Button("Connect");
        HBox hbBtn = new HBox(10);

        hbBtn.getChildren().add(connectBtn);
        connectGrid.add(hbBtn,1,4,1,1);


        Scene scene = new Scene(connectGrid,1000, 550);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
