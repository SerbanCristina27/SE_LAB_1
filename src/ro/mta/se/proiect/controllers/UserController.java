package ro.mta.se.proiect.controllers;


import ro.mta.se.proiect.views.*;
import ro.mta.se.proiect.models.*;


/**
 * Created by Cristina on 1/9/2017.
 */
public class UserController {

    MainView mainView;
    UserModel userModel;

    public UserController(MainView mainView,UserModel userModel) {

        this.mainView = mainView;
        this.userModel = userModel;
    }



}
