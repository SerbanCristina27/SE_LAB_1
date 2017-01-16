package ro.mta.se.proiect.models;

import ro.mta.se.proiect.utils.Constants;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Cristina on 1/10/2017.
 */
public class FriendModel {

    String friendName;
    String friendIp;
    public static Socket clientSocket;
    Integer portNumber;

    static Constants.Battlefield[][] friendBattlefieldMatrix;

    public FriendModel() {
        this.friendName = "";
        this.friendIp = "";
        friendBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            friendBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }
        this.portNumber = 0;
        this.friendIp = new String("127.0.0.1");
    }

    public FriendModel(String name, String ip, Integer portNumber) {
        this.friendName = name;
        this.friendIp = ip;
        this.portNumber = portNumber;
        friendBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            friendBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }
    }

    public FriendModel(String ip, Integer portNumber) {
        this.friendName = "Default";
        this.friendIp = ip;
        this.portNumber = portNumber;
        friendBattlefieldMatrix = new Constants.Battlefield[15][];
        for(int i =0 ; i < 15 ; i++){
            friendBattlefieldMatrix[i] = new Constants.Battlefield[15];
        }
    }

    public String getFriendName(){return  friendName;}

    public String getFriendIp(){return friendIp;}

    public void setFriendName(String friendName) {this.friendName = friendName;}

    void setFriendIp(String friendIp) {this.friendIp = friendIp;}

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }


}
