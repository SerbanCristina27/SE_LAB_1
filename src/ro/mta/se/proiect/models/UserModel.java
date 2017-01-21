package ro.mta.se.proiect.models;

/**
 * Created by Cristina on 1/9/2017.
 */

import javafx.stage.Stage;
import ro.mta.se.proiect.utils.Constants;

import javax.swing.text.Position;

public class UserModel {

    String userName;
    String userIp;
    Stage stage;
    public static Constants.PlanePosition position;

    public static Constants.Battlefield[][] userBattlefieldMatrix;


    public UserModel(Stage primaryStage){

        this.stage = primaryStage;
        this.position = Constants.PlanePosition.up;
        this.userName = "";
        this.userIp = "";
        userBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            userBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }
        for (int i = 0; i < Constants.SIZE; i++)
            for(int j = 0; j < Constants.SIZE; j++)
                userBattlefieldMatrix[i][j] = Constants.Battlefield.empty;
    }

    public Constants.PlanePosition getPosition() {
        return position;
    }

    public void setPosition(Constants.PlanePosition position) {
        this.position = position;
    }

    public Stage getStage() {
        return stage;
    }

    public UserModel(String name, String ip){
        this.userName = name;
        this.userIp = ip;
        userBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            userBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }

    }

    public int getStaticSize(){
        return Constants.SIZE;
    }

    public String getUserName(){return userName;}

    public String getUserIp(){return userIp;}

    public void setUserName(String userName) {this.userName = userName;}

    public void setUserIp(String userIp) {this.userIp = userIp;}


    public static Constants.Battlefield getPositionValue(Integer row, Integer column){
        return userBattlefieldMatrix[row][column];
    }
}
