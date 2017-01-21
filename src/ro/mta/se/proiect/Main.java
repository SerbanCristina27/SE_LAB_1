package ro.mta.se.proiect;
import javafx.application.Application;
import javafx.stage.Stage;
import ro.mta.se.proiect.controllers.*;
import ro.mta.se.proiect.models.*;
import ro.mta.se.proiect.views.*;


public class Main extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        UserModel model = new UserModel(primaryStage);

        UserController userController = new UserController(model);
        userController.show();

    }
}

