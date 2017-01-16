package ro.mta.se.proiect.models;

/**
 * Created by Cristina on 1/9/2017.
 */

import ro.mta.se.proiect.utils.Constants;

public class UserModel {

    String userName;
    String userIp;

    static Constants.Battlefield[][] userBattlefieldMatrix;


    public UserModel(){
        this.userName = "";
        this.userIp = "";
        userBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            userBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }
    }

    public UserModel(String name, String ip){
        this.userName = name;
        this.userIp = ip;
        userBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            userBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }

    }

    public String getUserName(){return userName;}

    public String getUserIp(){return userIp;}

    public void setUserName(String userName) {this.userName = userName;}

    public void setUserIp(String userIp) {this.userIp = userIp;}

    public static void setUserBattlefieldMatrix(Constants.Battlefield[][] battlefieldMatrix) {



        for (int i = 0; i < 15; i++) {

            Constants.Battlefield[] aMatrix = battlefieldMatrix[i];
            int aLength = aMatrix.length;
            System.arraycopy(aMatrix, 0, userBattlefieldMatrix[i],0,aLength);

        }

    }
}
