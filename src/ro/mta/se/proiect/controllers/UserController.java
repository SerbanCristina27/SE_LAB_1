package ro.mta.se.proiect.controllers;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import ro.mta.se.proiect.utils.Constants;
import ro.mta.se.proiect.views.*;
import ro.mta.se.proiect.models.*;


/**
 * Created by Cristina on 1/9/2017.
 */
public class UserController {

    static MainView mainView;
    static UserModel userModel;

    public UserController(MainView mainView,UserModel userModel) {

        this.mainView = mainView;
        this.userModel = userModel;


        new Thread(new ServerController()).start();

        MainView.launch(mainView.getClass());
    }


    public static boolean updateBattlefieldMatrix(Integer rowIndex, Integer columnIndex)
    {



        if (rowIndex <= 15 - 4 && (2 <= columnIndex && columnIndex <= 15 - 3)){

            Constants.Battlefield[][] battlefield = new Constants.Battlefield[15][];

            for (int i = 0; i < 15; i++) {
                battlefield[i] = new Constants.Battlefield[15];
            }


            battlefield[rowIndex][columnIndex] = Constants.Battlefield.planeHead;
            battlefield[rowIndex+1][columnIndex] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+2][columnIndex] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+3][columnIndex] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+1][columnIndex + 1] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+1][columnIndex+2] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+1][columnIndex-1] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+1][columnIndex-2] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+3][columnIndex+1] = Constants.Battlefield.planeBody;
            battlefield[rowIndex+3][columnIndex-1] = Constants.Battlefield.planeBody;

            UserModel.setUserBattlefieldMatrix(battlefield);

            return true;
        }
        else {
            return false;
        }
    }

}
