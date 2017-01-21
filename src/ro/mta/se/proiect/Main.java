package ro.mta.se.proiect;
import javafx.application.Application;
import javafx.application.Platform;
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
import ro.mta.se.proiect.controllers.*;
import ro.mta.se.proiect.models.*;
import ro.mta.se.proiect.views.*;


public class Main {


    public static void main(String[] args) {


        MainView view = new MainView();
        UserModel user = new UserModel();


        UserController userController = new UserController(view,user);


    }
}

