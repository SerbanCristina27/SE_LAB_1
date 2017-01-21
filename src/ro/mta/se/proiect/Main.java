package ro.mta.se.proiect;
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

