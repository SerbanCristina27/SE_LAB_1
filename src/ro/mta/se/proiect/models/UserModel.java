package ro.mta.se.proiect.models;

/**
 * Created by Cristina on 1/9/2017.
 */
public class UserModel {

    String userName;
    String userIp;

    public UserModel(){
        this.userName = "";
        this.userIp = "";
    }

    public UserModel(String name, String ip){
        this.userName = name;
        this.userIp = ip;
    }

    String getUserName(){return userName;}

    String getUserIp(){return userIp;}

    void setUserName(String userName) {this.userName = userName;}

    void setUserIp(String userIp) {this.userIp = userIp;}
}
